import java.util.*;

class Book {
    private int id;
    private String title;
    private String author;
    private int quantity;


    public Book(String title, String author, int id, int quantity) {
        this.title = title;
        this.author = author;
        this.id = id;
        this.quantity = quantity;

    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Book ID: " + id + ", Title: " + title + ", Author: " + author + ", Quantity: " + quantity;
    }
}

class Library {
    private List<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully!");
    }

    public void deleteBook(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                books.remove(book);
                System.out.println("Book deleted successfully!");
                return;
            }
        }
        System.out.println("Book not found!");
    }

    public void modifyBook(int id, int newQuantity) {
        for (Book book : books) {
            if (book.getId() == id) {
                book.setQuantity(newQuantity);
                System.out.println("Book quantity updated successfully!");
                return;
            }
        }
        System.out.println("Book not found!");
    }

    public void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            System.out.println("Books in the Library:");
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }
    public void issueBook(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                if (book.getQuantity() > 0) {
                    book.setQuantity(book.getQuantity() - 1);
                    System.out.println("Book issued successfully!");
                } else {
                    System.out.println("Book out of stock!");
                }
                return;
            }
        }
        System.out.println("Book not found!");
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            System.out.println("Books in the Library:");
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }
}

public class DigitalLibraryManagement {
    public static void main(String[] args) {
        Library library = new Library(); // Create a Library instance
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Digital Library Management ---");
            System.out.println("1. Add Book");
            System.out.println("2. Delete Book");
            System.out.println("3. Modify Book Quantity");
            System.out.println("4. View All Books");
            System.out.println("5. Issue Book");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    System.out.print("Enter the number of books to add: ");
                    int numBooks = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline

                    for (int i = 1; i <= numBooks; i++) {
                        System.out.println("\nEnter details for book " + i + ":");

                        System.out.print("Enter Book Title: ");
                        String title = scanner.nextLine();

                        System.out.print("Enter Author: ");
                        String author = scanner.nextLine();

                        System.out.print("Enter Book ID: ");
                        int id = scanner.nextInt();

                        System.out.print("Enter Quantity: ");
                        int quantity = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline

                        library.addBook(new Book(title, author, id, quantity));
                    }
                    System.out.println("\nAll books added successfully!");
                    break;

                case 2:
                    System.out.print("Enter Book ID to delete: ");
                    int deleteId = scanner.nextInt();
                    library.deleteBook(deleteId);
                    break;

                case 3:
                    System.out.print("Enter Book ID to modify: ");
                    int modifyId = scanner.nextInt();

                    System.out.print("Enter new quantity: ");
                    int newQuantity = scanner.nextInt();

                    library.modifyBook(modifyId, newQuantity);
                    break;

                case 4:
                    library.viewBooks();
                    break;

                case 5:
                    System.out.print("Enter Book ID to issue: ");
                    int issueId = scanner.nextInt();
                    library.issueBook(issueId);
                    break;

                case 0:
                    System.out.println("Exiting... Thank you for using Digital Library Management!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");


            }


        }
    }
}