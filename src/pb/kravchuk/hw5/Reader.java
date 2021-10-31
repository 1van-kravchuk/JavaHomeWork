package pb.kravchuk.hw5;


import java.util.Arrays;

public class Reader {
    private String name;
    private int libCardNum;
    private String faculty;
    private String birthDate;
    private String phoneNum;
    public static int count = 0;



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

    public void returnBook(int count) {
        System.out.println(name + " has returned " + count + " books");
    }

    public void returnBook(String... book) {
        System.out.println(new StringBuilder().append(name).append(" has returned books ").append(Arrays.toString(book)).toString());
    }

    public void returnBook(String name, String title, String author, int year) {
        System.out.print(name + " has returned books: ");
        System.out.print(title + " (" + author + " " + " " + year + ") ");
    }
}
