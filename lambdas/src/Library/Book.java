package Library;

class Book implements LibraryItem {
    private String author, title, genre;
    private int pages;

    public Book(String author, String title, String genre, int pages) {
        this.author = author;
        this.title = title;
        this.genre = genre;
        this.pages = pages;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }

    public void display() {
        System.out.println("Book: " + title + " by " + author + ", Genre: " + genre + ", Pages: " + pages);
    }
}