package library;

public class Book{
    String author; 
    String title;
    String isbn;
    boolean isBorrowed;

    {
        isBorrowed = false;
    }

    public Book(String author, String title, String isbn) {
        this.author = author;
        this.title = title;
        this.isbn = isbn;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public boolean isBorrowed() {
        return isBorrowed;
    }
    public void setBorrowed(boolean isBorrowed) {
        this.isBorrowed = isBorrowed;
    }

    public String toString() {
        return "Book [author=" + author + ", title=" + title + ", isbn=" + isbn + ", isBorrowed=" + isBorrowed + "]";
    }    
}