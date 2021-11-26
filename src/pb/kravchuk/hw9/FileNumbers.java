package pb.kravchuk.hw9;

import java.io.*;
import java.util.NoSuchElementException;

public class FileNumbers {
    int[][] arr = new int[10][10];

    public void createNumbersFile() throws IOException {
        File file = new File("files/numbers.txt");
        if (file.createNewFile()) {
            System.out.println("File numbers.txt was created");
        } else {
            System.out.println("File numbers.txt is already exist");
        }

        try (Writer writer = new FileWriter("files/numbers.txt")) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    arr[i][j] = (int) ((Math.random() * 100) + 1);
                    System.out.print(arr[i][j] + " ");
                    writer.write(arr[i][j] + " ");
                }
                System.out.println();
                writer.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("file has been written");
    }

    public void createOddNumbersFile() {
        try {
            File file1 = new File("files/odd-numbers.txt");
            if (file1.createNewFile()) {
                System.out.println("File numbers.txt was created");
            } else {
                System.out.println("File numbers.txt is already exist");
            }
            try (Writer writer = new FileWriter("files/odd-numbers.txt")) {
                for (int i = 0; i < arr.length; i++) {
                    for (int j = 0; j < arr[i].length; j++) {
                        if (arr[i][j] % 2 == 0) arr[i][j] = 0;
                        System.out.print(arr[i][j] + " ");
                        writer.write(arr[i][j] + " ");
                    }
                    System.out.println();
                    writer.write("\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (NoSuchElementException e) {
            System.out.println("No such element " + e);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("file has been read");
    }

    public static void main(String[] args) throws IOException {

        FileNumbers fileNumbers = new FileNumbers();

        System.out.println("Write elements");
        fileNumbers.createNumbersFile();
        System.out.println();
        System.out.println("read elements");
        fileNumbers.createOddNumbersFile();
    }
}
