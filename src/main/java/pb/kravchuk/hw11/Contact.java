package pb.kravchuk.hw11;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;


public class Contact {
    private int id;
    private String name;
    private List<String> phone;
    private LocalDate dateOfBirth;
    private String address;
    private LocalDateTime timeOfChange;

    public Contact() {
    }
    public Contact(int id, String name, List<String> phone, LocalDate dateOfBirth, String address) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.timeOfChange = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPhone(List<String> phone) {
        this.phone = phone;
    }

    public List<String> getPhone() {
        return phone;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return id == contact.id && Objects.equals(name, contact.name) && Objects.equals(phone, contact.phone) && Objects.equals(dateOfBirth, contact.dateOfBirth) && Objects.equals(address, contact.address) && Objects.equals(timeOfChange, contact.timeOfChange);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, phone, dateOfBirth, address, timeOfChange);
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", address='" + address + '\'' +
                ", dateOfChange=" + timeOfChange +
                '}';
    }
}
