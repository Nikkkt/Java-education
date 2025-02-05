package Library;

import java.util.ArrayList;
import java.util.List;

class LibraryCatalog {
    private List<LibraryItem> items = new ArrayList<>();

    public void addItem(LibraryItem item) { items.add(item); }

    public void removeItem(String title) { items.removeIf(item -> item.getTitle().equalsIgnoreCase(title)); }

    public void searchByTitle(String title) { items.stream().filter(item -> item.getTitle().equalsIgnoreCase(title)).forEach(LibraryItem::display); }

    public void searchByAuthor(String author) { items.stream().filter(item -> item instanceof Book && ((Book) item).getAuthor().equalsIgnoreCase(author)).forEach(LibraryItem::display); }

    public void displayAll() { items.forEach(LibraryItem::display); }
}