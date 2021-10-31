package pb.kravchuk.hw5;

public class Library {

    public static void main(String[] args) {

        Book[] books = new Book[5];
        books[0] = new Book("В конце они оба умрут", "Адам Сильвера", 2021);
        books[1] = new Book("Не ной", "Джен Синсеро", 2019);
        books[2] = new Book("Гордость и предубеждение и зомби", "Сет Грэм-Смит", 2009);
        books[3] = new Book("Жизнь взаймы", "Эрих Мария Рекмарк", 1959);
        books[4] = new Book("Повелитель мух", "Уильям Голдинг", 1954);

        Reader[] reader = new Reader[3];
        reader[0] = new Reader("Джейн Остин", 1001, "Психология", "16.12.1775", "+44(115)1234567");
        reader[1] = new Reader("Джон Картер", 1002, "История", "01.12.1976", "+10(002)5467890");
        reader[2] = new Reader("Василий Пупкин", 1003, "Математика", "02.02.1998", "+38(099)9097052");

        for (Book book : books) {
            System.out.println(book.getTitle() + " (" + book.getAuthor() + " " + book.getYear() + ")");
        }

        for (Reader x : reader) {
            System.out.println(x.getName() + " " + x.getLibCardNum() + " " + x.getBirthDate() + " " + x.getFaculty() + " " + x.getPhoneNum());
        }

        reader[0].takeBook(2);
        reader[0].takeBook(books[2].getTitle(), books[3].getTitle());
        reader[1].takeBook(books[4].getInfo());

        reader[0].returnBook(3);
        reader[1].returnBook(books[2].getTitle(), books[3].getTitle(), books[1].getTitle());
        reader[2].returnBook(books[0].getInfo());


    }
}


