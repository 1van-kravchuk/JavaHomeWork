package pb.kravchuk.hw5;

public class Book {
    private String title;
    private String author;
    private int year;
    private String info;

    public Book(String title, String author, int year) {
        this.author = author;
        this.title = title;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }
    public String getInfo(){
        info = title+" ("+author+", "+year+" год)";
        return info;
    }

}
