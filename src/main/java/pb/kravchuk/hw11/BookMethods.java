package pb.kravchuk.hw11;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookMethods {
Scanner sc = new Scanner(System.in);
public void addContact(){
    System.out.println("this method adds a contact");
    //write to json file
    // write adds to a file
    List<Contact> contactList = new ArrayList<>();
    contactList.add("vasili", "pupkin", "0501234567", "")
    System.out.println("Enter first name");

}
public void findContact(){
    System.out.println("this method find contact by name or something else");
    // read from json?
    //read from file
}
public void deleteContact(){
    System.out.println("this method deletes a contact");
    //rewrite changes to file
}
public void changeContact(){
    System.out.println("this method changes a chosen contact");
    //rewrite changes to file
}
public void sortByName(){
    System.out.println("this method sorts contacts by name");
    //sort from json list
}
public void sortByDate(){
    System.out.println("this method sorts contacts by date of change");
    //sort from json list
}
}
