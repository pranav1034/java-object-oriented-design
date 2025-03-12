import java.util.ArrayList;
// Book class
class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public String toString() {
        return "The details of the book is: ";
    }
}

// Library class that contains multiple Book objects (Aggregation)
class Library {
    private String name;
    private ArrayList<Book> books;

    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }
    public void addBook(Book book) {
        books.add(book);
    }
    public void displayBooks() {
        System.out.println("Library: " + name);
        for (Book book : books) {
            System.out.println(book);
            System.out.println("Title- "+book.getTitle());
            System.out.println("Author- "+book.getAuthor());
            System.out.println();
        }
    }
    public static void main(String[] args) {
        // Creating books
        Book book1 = new Book("Hamlet", "William Shakespeare");
        Book book2 = new Book("The Blue Umbrella", "Ruskin Bond");
        Book book3 = new Book("1984", "George Orwell");

        // Creating libraries
        Library library1 = new Library("Central Library");
        Library library2 = new Library("City Library");

        // Adding books to libraries (Aggregation)
        library1.addBook(book1);
        library1.addBook(book2);

        library2.addBook(book3);
        library2.addBook(book1); // The same book can be in multiple libraries

        // Displaying books in each library
        library1.displayBooks();
        System.out.println();
        library2.displayBooks();
    }
}
