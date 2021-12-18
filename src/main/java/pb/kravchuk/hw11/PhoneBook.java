package pb.kravchuk.hw11;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PhoneBook extends BookMethods {
    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        SimpleModule module = new SimpleModule();
        module.addSerializer(LocalDate.class, new LocalDateSerializer());
        module.addDeserializer(LocalDate.class, new LocalDateDeserializer());
        mapper.registerModule(module);

        List<Contact> contactList = new ArrayList<>();

        PhoneBook book = new PhoneBook();
        while (true) {
            System.out.println(new StringBuilder()
                    .append("Hello. This is Phone book. \n")
                    .append("To add contact press 1 \n")
                    .append("To find contact press 2 \n")
                    .append("To change contact press 3 \n")
                    .append("To delete contact press 4 \n")
                    .append("To sort contacts by name press 5 \n")
                    .append("To sort contacts by date of change press 6 \n")
                    .append("To exit the program press 0 \n")
                    .append("Please, make your choice:"));
            Scanner scan = new Scanner(System.in);
            int choice = scan.nextInt();
            switch (choice) {
                case 1:
                    book.addContact();
                    List<Contact> list = Arrays.asList(
                            new Contact ()
                    );

                    break;
                case 2:
                    book.findContact();
                    break;
                case 3:
                    book.changeContact();
                    break;
                case 4:
                    book.deleteContact();
                    break;
                case 5:
                    book.sortByName();
                    break;
                case 6:
                    book.sortByDate();
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

