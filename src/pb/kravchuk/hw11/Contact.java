package pb.kravchuk.hw11;

import java.time.LocalDate;

public class Contact {
    // This class contains array of contacts
    private String name;
    private String phone;
    private LocalDate dateOfBirth;
    private String address;
    private LocalDate dateOfChange;

    public Contact(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public LocalDate getDateOfChange() {
        return dateOfChange;
    }

    public void setDateOfChange(LocalDate dateOfChange) {
        this.dateOfChange = dateOfChange;
    }

    public Contact(String name, String phone, LocalDate dateOfBirth, String address, LocalDate dateOfChange) {
        this.name = name;
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.dateOfChange = dateOfChange;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", address='" + address + '\'' +
                ", dateOfChange=" + dateOfChange +
                '}';
    }
}
