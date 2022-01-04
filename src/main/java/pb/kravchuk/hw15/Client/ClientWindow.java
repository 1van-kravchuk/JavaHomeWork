package pb.kravchuk.hw15.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientWindow extends JFrame {
    private static final String SERVERHOST = "localhost";
    private static final int SERVERPORT = 3221;
    private Socket clSocket;
    private Scanner inMsg;
    private PrintWriter outMsg;
    private JTextField jtfMsg;
    private JTextField jtfName;
    private JTextArea jtaTextAreaMsg;
    private String clName = "";

    public String getClName() {
        return this.clName;
    }

    public ClientWindow() {
        try {
            clSocket = new Socket(SERVERHOST, SERVERPORT);
            inMsg = new Scanner(clSocket.getInputStream());
            outMsg = new PrintWriter(clSocket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        setBounds(600, 300, 600, 500);
        setTitle("User");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jtaTextAreaMsg = new JTextArea();
        jtaTextAreaMsg.setEditable(false);
        jtaTextAreaMsg.setLineWrap(true);
        JScrollPane jsp = new JScrollPane(jtaTextAreaMsg);
        add(jsp, BorderLayout.CENTER);
        JLabel jlUserCount = new JLabel("Count of users: ");
        add(jlUserCount, BorderLayout.NORTH);
        JPanel bottomPanel = new JPanel(new BorderLayout());
        add(bottomPanel, BorderLayout.SOUTH);
        JButton jbSendMsg = new JButton("Send");
        bottomPanel.add(jbSendMsg, BorderLayout.EAST);
        jtfMsg = new JTextField("Enter your message");
        bottomPanel.add(jtfMsg, BorderLayout.CENTER);
        jtfName = new JTextField("Enter your name: ");
        bottomPanel.add(jtfName, BorderLayout.WEST);
        jbSendMsg.addActionListener(this::actionPerformed);
        jtfMsg.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                jtfMsg.setText("");
            }
        });
        new Thread(() -> {
            try {
                while (true) {
                    if (inMsg.hasNext()) {
                        String inM = inMsg.nextLine();
                        String clInChat = "Users in chat: ";
                        if (inM.indexOf(clInChat) == 0) {
                            jlUserCount.setText(inM);
                        } else {
                            jtaTextAreaMsg.append(inM);
                            jtaTextAreaMsg.append("\n");
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                try {
                    if (!clName.isEmpty() && !clName.equals("Enter your name: ")) {
                        outMsg.println(clName + " has left of chat");
                    } else {
                        outMsg.println("user has left the chat");
                    }
                    outMsg.println("!exit!");
                    outMsg.flush();
                    outMsg.close();
                    inMsg.close();
                    clSocket.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        setVisible(true);
    }

    public void sendMsg() {
        String msgStr = jtfName.getText() + ": " + jtfMsg.getText();
        outMsg.println(msgStr);
        outMsg.flush();
        jtfMsg.setText("");
    }

    private void actionPerformed(ActionEvent e) {
        if (!jtfName.getText().trim().isEmpty() && !jtfMsg.getText().trim().isEmpty()) {
            clName = jtfName.getText();
            sendMsg();
            jtfMsg.grabFocus();
        }
    }
}
