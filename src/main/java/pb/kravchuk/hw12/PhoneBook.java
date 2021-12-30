package pb.kravchuk.hw12;

import java.util.Scanner;

public class PhoneBook {
    public static void main(String[] args) {

        BookMethods book = new BookMethods();
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println(new StringBuilder("Hello. This is Phone book. \n")
                    .append("To add contact press 1 \n")
                    .append("To find contact press 2 \n")
                    .append("To change contact press 3 \n")
                    .append("To delete contact press 4 \n")
                    .append("To sort contacts press 5 \n")
                    .append("to save contacts to file press 6 \n")
                    .append("to download contacts from file press 7 \n")
                    .append("To exit the program press 0 \n")
                    .append("Please, make your choice:"));
            int choice = scan.nextInt();
            switch (choice) {
                case 1:
                    book.addContact();
                    break;
                case 2:
                    System.out.println(new StringBuilder("To find contact \n")
                            .append("by name press 1 \n")
                            .append("by phone number press 2 \n")
                            .append("to back to main menu press 0"));
                    choice = scan.nextInt();
                    switch (choice) {
                        case 1:
                            book.findContactByName();
                            break;
                        case 2:
                            book.findContactByPhone();
                            break;
                        case 0:
                            return;
                        default:
                            throw new IllegalStateException("Unexpected value: " + choice);
                    }
                    break;
                case 3:
                    book.changeContact();
                    break;
                case 4:
                    book.deleteContact();
                    break;
                case 5:
                    System.out.println(new StringBuilder("sort by: \n")
                            .append("1. name \n")
                            .append("2. date of change \n")
                            .append("0. back to main menu \n")
                            .append("make your choice."));
                    choice = scan.nextInt();
                    switch (choice) {
                        case 1:
                            book.sortByName();
                            break;
                        case 2:
                            book.sortByDate();
                            break;
                        case 0:
                            return;
                        default:
                            throw new IllegalStateException("Unexpected value: " + choice);
                    }
                    break;
                case 6:
                    book.saveToFile();
                    break;
                case 7:
                    book.downloadFromFile();
                    break;
                case 0:
                    System.out.println("Closing the phone book...");
                    scan.close();
                    System.exit(0);
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + choice);
            }
        }
    }
}