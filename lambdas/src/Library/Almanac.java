package Library;

import java.util.List;
import java.util.stream.Collectors;

class Almanac implements LibraryItem {
    private String title;
    private List<Book> books;

    public Almanac(String title, List<Book> books) {
        this.title = title;
        this.books = books;
    }

    public String getTitle() { return title; }

    public void display() {
        System.out.println("Almanac: " + title + " Includes: " + books.stream().map(Book::getTitle).collect(Collectors.joining(", ")));
    }
}