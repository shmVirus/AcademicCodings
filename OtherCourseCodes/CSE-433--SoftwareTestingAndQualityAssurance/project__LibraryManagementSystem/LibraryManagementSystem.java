import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

class Library {
    private List<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        if (isDuplicate(book)) {
            System.out.println("This book already exists in the library!");
            return;
        } else {
            books.add(book);
            saveBooksToFile(); // Save books to the database

            // Check if the library was initially empty
            boolean initiallyEmpty = books.size() == 1;
            if (!initiallyEmpty) {
                System.out.println("Book added successfully.");
            }
        }
    }

    private boolean isDuplicate(Book book) {
        for (Book existingBook : books) {
            if (existingBook.getIsbn().equals(book.getIsbn())) {
                return true;
            }
        }
        return false;
    }

    public void removeBook(String isbn) {
        Iterator<Book> iterator = books.iterator();
        boolean bookFound = false;
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getIsbn().equals(isbn)) {
                iterator.remove();
                bookFound = true;
                break;
            }
        }

        if (bookFound) {
            saveBooksToFile(); // Save books to the database
            System.out.println("Book removed successfully.");
        } else {
            System.out.println("Book not found in the library.");
        }
    }

    public List<Book> getBooks() {
        return books;
    }

    private void saveBooksToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("books.txt"))) {
            for (Book book : books) {
                writer.println(book.toString());
            }
        } catch (IOException e) {
            System.out.println("Error saving books to the database.");
        }
    }

    public void displayBooks() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        if (books.isEmpty()) {
            System.out.println("No books in the library!");
        } else {
            System.out.println("Books in the library:");
            for (Book book : books) {
                System.out.println("\t-------------------------");
                System.out.println("\tTitle: " + book.getTitle());
                System.out.println("\tAuthor: " + book.getAuthor());
                System.out.println("\tPublication Year: " + book.getPublicationYear());
                System.out.println("\tISBN: " + book.getIsbn());
            }
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
}

class Book {
    private String title;
    private String author;
    private int publicationYear;
    private String isbn;

    public Book(String title, String author, int publicationYear, String isbn) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return title + "|" + author + "|" + publicationYear + "|" + isbn;
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();

        // Load books from the database
        loadBooksFromFile(library);

        Scanner scanner = new Scanner(System.in);

        boolean exit = false;

        while (!exit) {
            showMenuOptions();

            System.out.print("Select: ");
            try {
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        addBook(library, scanner);
                        break;
                    case 2:
                        removeBook(library, scanner);
                        break;
                    case 3:
                        library.displayBooks();
                        break;
                    case 4:
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid choice, try again...");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, please enter a valid choice!");
            }
        }
    }

    private static void addBook(Library library, Scanner scanner) {
        System.out.print("ISBN: ");
        String isbn = scanner.nextLine();

        if (library.getBooks().stream().anyMatch(book -> book.getIsbn().equals(isbn))) {
            System.out.println("This book already exists in the library!");
            library.displayBooks();
            return;
        }

        System.out.print("Title: ");
        String title = scanner.nextLine();

        System.out.print("Author(s): ");
        String author = scanner.nextLine();

        int publicationYear = 0;
        boolean validYear = false;
        while (!validYear) {
            System.out.print("Publication Year: ");
            try {
                publicationYear = Integer.parseInt(scanner.nextLine());
                validYear = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, please enter a valid year!");
            }
        }

        Book book = new Book(title, author, publicationYear, isbn);
        library.addBook(book);

        library.displayBooks();
    }

    private static void removeBook(Library library, Scanner scanner) {
        System.out.print("ISBN: ");
        String isbn = scanner.nextLine();

        library.removeBook(isbn);

        library.displayBooks();
    }

    private static void loadBooksFromFile(Library library) {
        try (BufferedReader reader = new BufferedReader(new FileReader("books.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] bookData = line.split("\\|");
                if (bookData.length == 4) {
                    String title = bookData[0];
                    String author = bookData[1];
                    int publicationYear = Integer.parseInt(bookData[2]);
                    String isbn = bookData[3];
                    Book book = new Book(title, author, publicationYear, isbn);
                    library.addBook(book);
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading books from the database.");
        }
    }

    private static void showMenuOptions() {
        System.out.println("Choices: ");
        System.out.println("\t1. Add a book");
        System.out.println("\t2. Remove a book");
        System.out.println("\t3. Display all books");
        System.out.println("\t4. Exit");
    }
}
