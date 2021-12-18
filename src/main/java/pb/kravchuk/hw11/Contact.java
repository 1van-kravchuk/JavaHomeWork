package pb.kravchuk.hw11;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Contact {
    // This class contains array of contacts
    private String firstName;
    private String secondName;
    private String phone;
    private LocalDate dateOfBirth;
    private String address;
    private LocalDateTime timeOfChange;

    public Contact() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDateTime getTimeOfChange() {
        return timeOfChange;
    }

    public void setTimeOfChange(LocalDateTime timeOfChange) {
        this.timeOfChange = timeOfChange;
    }

    public Contact(String firstName, String secondName, String phone, LocalDate dateOfBirth, String address, LocalDateTime dateOfChange) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.timeOfChange = dateOfChange;
    }

    public static void addContact() {
        System.out.println("this method adds a contact");
        //write to json file
        // write adds to a file
        Scanner sc = new Scanner(System.in);
        List<Contact> contactList = new ArrayList<>();
        System.out.println("Enter first name");
        String firstName = sc.next();
        System.out.println("Enter second name");
        String secondName = sc.next();
        System.out.println("enter phone number");
        String phone = sc.next();
        System.out.println("enter date of birth");
        LocalDate dateOfBirth = LocalDate.of(sc.nextInt(), sc.nextInt(), sc.nextInt());
        System.out.println("enter address");
        String address = sc.next();
        LocalDateTime timeOfChange = LocalDateTime.now();
        try {
            contactList.add(new Contact(firstName, secondName, phone, dateOfBirth, address, timeOfChange));
            System.out.println("contact has been add \n");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("String: " + e);
        }
    }

    public static void findContact(){
        System.out.println("this method find contact by name or something else");
        System.out.println("enter the name of contact you are searching");
        Scanner sc = new Scanner(System.in);
        String name = sc.next();

        // read from json?
        //read from file
    }
    public static void deleteContact(){
        System.out.println("this method deletes a contact");
        //rewrite changes to file
    }
    public static void changeContact(){
        System.out.println("this method changes a chosen contact");
        //rewrite changes to file
    }
    public static void sortByName(){
        System.out.println("this method sorts contacts by name");
        //sort from json list
    }
    public static void sortByDate(){
        System.out.println("this method sorts contacts by date of change");
        //sort from json list
    }




    @Override
    public String toString() {
        return "Contact{" +
                "name='" + firstName + " " + secondName + '\'' +
                ", phone='" + phone + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", address='" + address + '\'' +
                ", dateOfChange=" + timeOfChange +
                '}';
    }
}
