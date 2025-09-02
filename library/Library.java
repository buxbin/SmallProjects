package library;

import java.util.ArrayList;
import java.util.List;

public class Library{
    private List<Book> libraryHoldings = new ArrayList<>();

    public void addBook(Book book){
        libraryHoldings.add(book);
    }

    public boolean borrowBook(String identifier){
        Book wantedBook = null;
        for(Book book : libraryHoldings){
            if (book.isbn.equals(identifier)){
                wantedBook = book;
                break;
            }
        }
        
        if(wantedBook == null){
            System.out.println("Book not found");
            return false;
        } else if(wantedBook.isBorrowed == true){
            System.out.println("Book already borrowed");
            return false;
        } else {
            wantedBook.setBorrowed(true);
            System.out.println("Book can be borrowed");
            return true;
        }
    }

    public boolean returnBook(String identifier) {
        for(Book book : libraryHoldings){
            if(book.getIsbn().equals(identifier)){
                if(book.isBorrowed()){
                    book.setBorrowed(false);
                    System.out.println("Book successfully returned: " + book.getTitle());
                    return true;
                } else {
                    System.out.println("Book was not borrowed: " + book.getTitle());
                    return false;
                }
            }
        }
        System.out.println("Book not found: " + identifier);
        return false;
    }

    public void listAvailableBooks(){
        libraryHoldings.forEach(info -> {
            if(info.isBorrowed() == false) System.out.println(info.toString());
        });
    }
}