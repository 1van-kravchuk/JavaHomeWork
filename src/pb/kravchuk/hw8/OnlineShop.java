package pb.kravchuk.hw8;

import java.util.Scanner;

public class OnlineShop {
    public static void main(String[] args) throws WrongLoginException, WrongPasswordException{
        Scanner scan = new Scanner(System.in);
        System.out.println("edit login:");
        String name = scan.next();
        System.out.println("edit password:");
        String pass = scan.next();
        System.out.println("Confirm password");
        String confirmPassword = scan.next();

        Auth user = new Auth(name, pass, confirmPassword);
        try{
            user.singUp();

        } catch (WrongLoginException|WrongPasswordException exception1){
            System.out.println(exception1);
        }

        System.out.println("enter login:");
        String name2 = scan.next();
        System.out.println("enter password:");
        String pass2 = scan.next();

        Auth user2 = new Auth(name2, pass2);
        try{
user2.singIn();
        }catch (WrongLoginException|WrongPasswordException exception2){
            System.out.println(exception2);
        }






    }
}
