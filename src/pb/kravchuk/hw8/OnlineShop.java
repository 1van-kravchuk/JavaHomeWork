package pb.kravchuk.hw8;

import java.util.Scanner;

public class OnlineShop {
    public static void main(String[] args) throws WrongLoginException, WrongPasswordException {
        Scanner scan = new Scanner(System.in);
        System.out.println("edit login:");
        String name = scan.next();
        System.out.println("edit password:");
        String pass = scan.next();
        System.out.println("Confirm password");
        String confirmPassword = scan.next();

        Auth user = new Auth();

        try {
            user.singUp(name, pass, confirmPassword);
        } catch (WrongLoginException | WrongPasswordException exception1) {
            System.out.println(exception1);
            System.exit(0);
        }

        System.out.println();
        System.out.println("enter your login:");
        name = scan.next();
        System.out.println("enter password:");
        pass = scan.next();

        try {
            user.singIn(name, pass);
        } catch (WrongLoginException | WrongPasswordException exception2) {
            System.out.println(exception2);
            System.exit(0);
        }
    }
}
