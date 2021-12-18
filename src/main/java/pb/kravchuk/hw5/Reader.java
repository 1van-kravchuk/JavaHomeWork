package pb.kravchuk.hw5;


import java.util.Arrays;

public class Reader {
    private final String name;
    private final int libCardNum;
    private final String faculty;
    private final String birthDate;
    private final String phoneNum;


    public Reader(String name, int libCardNum, String faculty, String birthDate, String phoneNum) {
        this.name = name;
        this.libCardNum = libCardNum;
        this.faculty = faculty;
        this.birthDate = birthDate;
        this.phoneNum = phoneNum;
    }

    public String getName() {
        return name;
    }

    public int getLibCardNum() {
        return libCardNum;
    }

    public String getFaculty() {
        return faculty;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void takeBook(int countOfBooks) {
        System.out.println(name + " has taken " + countOfBooks + " books: ");
    }

    public void takeBook(String... books) {
        System.out.println(name + " has taken " + Arrays.toString(books));
    }

    public void takeBook(Book... books) {
        System.out.println(name + " has taken " + Arrays.toString(books));
    }

    public void returnBook(int count) {
        System.out.println(name + " has returned " + count + " books");
    }

    public void returnBook(String... books) {
        System.out.println(name + " has returned books " + Arrays.toString(books));
    }

    public void returnBook(Book... books) {
        System.out.println(name + " has returned books " + Arrays.toString(books));
    }
}

