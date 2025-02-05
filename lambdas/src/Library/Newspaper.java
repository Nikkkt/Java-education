package Library;

import java.util.List;

class Newspaper implements LibraryItem {
    private String title, date;
    private List<String> headlines;

    public Newspaper(String title, String date, List<String> headlines) {
        this.title = title;
        this.date = date;
        this.headlines = headlines;
    }

    public String getTitle() { return title; }

    public void display() {
        System.out.println("Newspaper: " + title + " (" + date + ") Headlines: " + headlines);
    }
}