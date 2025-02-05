package Library;

import java.util.Arrays;

public class Task4_Main {
    public static void main(String[] args) {
        LibraryCatalog catalog = new LibraryCatalog();

        catalog.addItem(new Book("J.K. Rowling", "Harry Potter", "Fantasy", 500));
        catalog.addItem(new Newspaper("Daily News", "2025-02-03", Arrays.asList("Headline 1", "Headline 2")));
        catalog.addItem(new Almanac("Best of Fiction", Arrays.asList(new Book("J.R.R. Tolkien", "The Hobbit", "Fantasy", 310))));

        System.out.println("All items:");
        catalog.displayAll();

        System.out.println("Search by title: 'Harry Potter'");
        catalog.searchByTitle("Harry Potter");

        System.out.println("Search by author: 'J.R.R. Tolkien'");
        catalog.searchByAuthor("J.R.R. Tolkien");
    }
}
