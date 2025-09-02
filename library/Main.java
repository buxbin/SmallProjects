package library;

public class Main{
    public static void main(String[] args) {
        Library lib = new Library();
        lib.addBook(new Book("J.K. Rowling", "Harry Potter and the Philosopher's Stone", "9783551557412"));
        lib.addBook(new Book("J.R.R. Tolkien", "The Lord of the Rings: The Fellowship of the Ring", "9783608939532"));
        lib.addBook(new Book("George Orwell", "1984", "9783499261405"));
        lib.addBook(new Book("Frank Herbert", "Dune", "9783453318368"));
        lib.addBook(new Book("Douglas Adams", "The Hitchhiker's Guide to the Galaxy", "9783492274268"));
        lib.addBook(new Book("Stephen King", "It", "9783453437434"));
        lib.addBook(new Book("Andrzej Sapkowski", "The Last Wish", "9783518467265"));
        lib.addBook(new Book("Patrick Rothfuss", "The Name of the Wind", "9783608939969"));
        lib.addBook(new Book("Suzanne Collins", "The Hunger Games", "9783785732432"));
        lib.addBook(new Book("Walter Moers", "The 13½ Lives of Captain Bluebear", "9783895844449"));

        lib.borrowBook("9783551557412");
        lib.borrowBook("9783499261405");
        lib.borrowBook("9783608939969");
        lib.borrowBook("9783551557412");
        lib.borrowBook("9783499261405");
        lib.borrowBook("9783608939969");
        lib.listAvailableBooks();
    }
}