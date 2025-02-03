package Book;

import java.util.Scanner;

public class Book {
    private String title;
    private String author;
    private int year;
    private String publisher;
    private String genre;
    private int pages;

    public Book() {
        this.title = "";
        this.author = "";
        this.year = 0;
        this.publisher = "";
        this.genre = "";
        this.pages = 0;
    }

    public Book(String title,
                String author,
                int year,
                String publisher,
                String genre,
                int pages) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.publisher = publisher;
        this.genre = genre;
        this.pages = pages;
    }

    public void inputData() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введіть назву книги: ");
        this.title = sc.nextLine();

        System.out.print("Введіть ПІБ автора: ");
        this.author = sc.nextLine();

        System.out.print("Введіть рік випуску: ");
        this.year = sc.nextInt();
        sc.nextLine();

        System.out.print("Введіть назву видавництва: ");
        this.publisher = sc.nextLine();

        System.out.print("Введіть жанр книги: ");
        this.genre = sc.nextLine();

        System.out.print("Введіть кількість сторінок: ");
        this.pages = sc.nextInt();
    }

    public void displayData() {
        System.out.println("Назва книги: " + title);
        System.out.println("ПІБ автора: " + author);
        System.out.println("Рік випуску: " + year);
        System.out.println("Назва видавництва: " + publisher);
        System.out.println("Жанр книги: " + genre);
        System.out.println("Кількість сторінок: " + pages);
    }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    public String getPublisher() { return publisher; }
    public void setPublisher(String publisher) { this.publisher = publisher; }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    public int getPages() { return pages; }
    public void setPages(int pages) { this.pages = pages; }
}
