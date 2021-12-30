package pb.kravchuk.hw12;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class BookMethods {
    private static final DateTimeFormatter CHANGE_TIME_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static final String DATA_FILE_PATH = "files/PhoneBook.json";

    private final Scanner scan = new Scanner(System.in);
    private final List<Contact> contacts = new ArrayList<>();
    private final ObjectMapper objectMapper;

    public BookMethods() {
        objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        SimpleModule module = new SimpleModule();
        module.addSerializer(LocalDate.class, new LocalDateSerializer());
        module.addDeserializer(LocalDate.class, new LocalDateDeserializer());
        module.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer());
        module.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer());
        objectMapper.registerModule(module);
    }

    public void addContact() {
        System.out.println("this method adds a contact");
        System.out.println("enter name");
        String name = scan.nextLine();
        System.out.println("enter phone number(s)");
        List<String> numbers = editPhoneNums();
        System.out.println("Enter date of birth");
        String dateOfBirths = scan.nextLine();
        LocalDate dateOfBirth = LocalDate.parse(dateOfBirths);
        System.out.println("enter address");
        String address = scan.nextLine();
        int id = getNextId();
        Contact contact = new Contact(id, name, numbers, dateOfBirth, address);
        contacts.add(contact);
    }

    private List<String> editPhoneNums() {
        List<String> numbers = new ArrayList<>();
        while (true) {
            System.out.println("Enter phone number \nto return to main menu press 0");
            String number = scan.nextLine();
            if (number.equals("0")) {
                return numbers;
            }
            numbers.add(number);
        }
    }

    private int getNextId() {
        if (contacts.isEmpty()) {
            return 1;
        }
        Contact idContact = Collections.max(contacts, (o1, o2) -> Integer.compare(o1.getId(), o2.getId()));
        return idContact.getId() + 1;
    }

    public void findContactByName() {
        System.out.println("this method find contact by name");
        System.out.println("enter the name of contact you are searching");
        String name = scan.nextLine();
        List<Contact> foundContacts = new ArrayList<>();
        for (Contact c :
                contacts) {
            if (c.getName().contains(name)) {
                foundContacts.add(c);
            }
        }
        printContacts(foundContacts);
    }

    public void findContactByPhone() {
        System.out.println("this method find contact by phone number");
        System.out.println("enter phone number");
        String number = scan.nextLine();
        List<Contact> foundContacts = new ArrayList<>();
        for (Contact c :
                contacts) {
            for (String phNumber :
                    c.getPhone()) {
                if (phNumber.contains(number)) {
                    foundContacts.add(c);
                    break;
                }
            }
        }
        printContacts(foundContacts);
    }

    public void printContacts(List<Contact> contacts) {
        System.out.println("-------------------------------------------------------------------------------------------------------------");
        System.out.println("| id |       Name       |  Phone numbers  |   Date of birth   |        Address         |   time of change   |");
        System.out.println("-------------------------------------------------------------------------------------------------------------");
        for (Contact c :
                contacts) {
            System.out.printf(
                    "| %2d | %15s | %13s| %14s | %20s | %19s |%n",
                    c.getId(), c.getName(),
                    c.getPhone().isEmpty() ? "" : c.getPhone().get(0),
                    c.getDateOfBirth(), c.getAddress(), c.getTimeOfChange().format(CHANGE_TIME_FORMAT)
            );
            if (c.getPhone().size() > 1) {
                for (int i = 1; i < c.getPhone().size(); i++) {
                    System.out.printf(
                            "|    |                 |               | %14s |                      |                     |%n", c.getPhone().get(i));
                }
            }
            System.out.println("------------------------------------------------------------------------------------------------------");
        }
    }

    public void deleteContact() {
        System.out.println("this method deletes a contact");
        //rewrite changes to file
        System.out.println("Enter the name of contact");
        String delName = scan.nextLine();
        for (Contact contact :
                contacts) {
            if (delName.equals(contact.getName())) {
                contacts.remove(contact);
                System.out.println("contact has been deleted");
            } else {
                System.out.println("contact has not been found");
            }
        }
    }

    public void changeContact() {
        System.out.println("this method changes a chosen contact");
        System.out.println("Enter the name of contact");
        String changeName = scan.nextLine();
        for (Contact contact :
                contacts) {
            if (changeName.equals(contact.getName())) {
                while (true) {
                    System.out.printf("Change a contact`s \n1. name \n2. phone(s) \n3. address \n4. date of birth \n0. to exit to main menu");
                    int choise = scan.nextInt();
                    switch (choise) {
                        case 1:
                            System.out.println("enter new name");
                            String newName = scan.nextLine();
                            contact.setName(newName);
                            contact.setTimeOfChange(LocalDateTime.now());
                            break;
                        case 2:
                            System.out.println("enter new phone(s)");
                            changePhoneNums(contact);
                            break;
                        case 3:
                            System.out.println("enter new address");
                            String newAddress = scan.nextLine();
                            contact.setAddress(newAddress);
                            contact.setTimeOfChange(LocalDateTime.now());
                            break;
                        case 4:
                            System.out.println("enter new date of birth");
                            String newDate = scan.nextLine();
                            contact.setDateOfBirth(LocalDate.parse(newDate));
                            contact.setTimeOfChange(LocalDateTime.now());
                            break;
                        case 0:
                            return;
                        default:
                            throw new IllegalStateException("Unexpected value " + choise);
                    }
                }
            } else
                System.out.println("contact has not been found");
        }
    }

    private void changePhoneNums(Contact contact) {
        List<String> phoneNumbers = contact.getPhone();
        while (true) {
            System.out.println("List of phones");
            for (int i = 0; i < phoneNumbers.size(); i++) {
                System.out.println((i + 1) + ". " + phoneNumbers.get(i));
            }
            System.out.printf("Choose an action \n1. to add phone \n2. to delete phone \n0. to exit to main menu");
            int choice = scan.nextInt();
            switch (choice) {
                case 1:
                    List<String> newNumbers = editPhoneNums();
                    phoneNumbers.addAll(newNumbers);
                    contact.setTimeOfChange(LocalDateTime.now());
                    break;
                case 2:
                    System.out.println("enter the number of phone, you want to delete \nto exit press 0");
                    int num = Integer.parseInt(scan.nextLine());
                    if (num == 0) {
                        break;
                    }
                    phoneNumbers.remove(num - 1);
                    contact.setTimeOfChange(LocalDateTime.now());
                    break;
                case 0:
                    return;
                default:
                    throw new IllegalStateException("Unexpected value: " + choice);
            }
        }
    }

    public void sortByName() {
        System.out.println("this method sorts contacts by name");
        contacts.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
        printContacts(contacts);
    }

    public void sortByDate() {
        System.out.println("this method sorts contacts by date of change");
        contacts.sort(((Comparator<Contact>) (o1, o2) -> o1.getTimeOfChange().compareTo(o2.getTimeOfChange())).reversed());
        printContacts(contacts);
    }

    public void saveToFile() {
        try {
            String json = objectMapper.writeValueAsString(contacts);
            Files.write(Paths.get(DATA_FILE_PATH), json.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            System.out.println("save file error" + e.getMessage());
            e.printStackTrace();
        }
    }

    public void downloadFromFile() {
        try {
            byte[] byteData = Files.readAllBytes(Paths.get(DATA_FILE_PATH));
            List<Contact> contacts = objectMapper.readValue(byteData, new TypeReference<List<Contact>>() {
            });
            this.contacts.clear();
            this.contacts.addAll(contacts);
        } catch (StreamReadException e) {
            System.out.println("error of reading file" + e.getMessage());
            e.printStackTrace();
        } catch (DatabindException e) {
            System.out.println("error of databind of file" + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("error of downloading from file" + e.getMessage());
            e.printStackTrace();
        }
    }
}
