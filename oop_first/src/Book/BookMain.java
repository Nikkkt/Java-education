package Book;

public class BookMain {
    public static void main(String[] args) {
        Book book = new Book(
                "Java",
                "Іван Іванович",
                2010,
                "Харків",
                "Технічна література",
                100);

        System.out.println("Інформація про книгу:");
        book.displayData();
    }
}
