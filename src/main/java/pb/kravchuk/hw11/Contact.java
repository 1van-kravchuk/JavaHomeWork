package pb.kravchuk.hw11;

import java.time.LocalDate;
import java.time.LocalDateTime;


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
