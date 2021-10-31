package pb.kravchuk.hw5;


import java.util.Arrays;

public class Reader {
    private String name;
    private int libCardNum;
    private String faculty;
    private String birthDate;
    private String phoneNum;


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
        System.out.println(new StringBuilder().append(name).append(" has taken ").append(countOfBooks).append(" books: ").toString());
    }

    public void takeBook(String... books) {
        System.out.println(new StringBuilder().append(name).append(" has taken ").append(Arrays.toString(books)).toString());
    }

    public void takeBook(Book... books) {
        System.out.println(new StringBuilder().append(name).append(" has taken ").append(Arrays.toString(books)).toString());
    }

    public void returnBook(int count) {
        System.out.println(name + " has returned " + count + " books");
    }

    public void returnBook(String... books) {
        System.out.println(new StringBuilder().append(name).append(" has returned books ").append(Arrays.toString(books)).toString());
    }

    public void returnBook(Book... books) {
        System.out.println(new StringBuilder().append(name).append(" has returned books ").append(Arrays.toString(books)).toString());
    }
}

