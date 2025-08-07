 import java.util.ArrayList;
import java.util.Scanner;
                class Book {
                    int id;
                    String title;
                    String author;
                    boolean issued;

                    Book(int id, String title, String author) {
                        this.id = id;
                        this.title = title;
                        this.author = author;
                        this.issued = false;
                    }
                    void issue() { issued = true; }
                    void returned() { issued = false; }
                    public String toString() {
                        return id + ": " + title + " by " + author + (issued ? " [Issued]" : " [Available]");
                    }
                }
                class User {
                    int id;
                    String name;

                    User(int id, String name) {
                        this.id = id;
                        this.name = name;
                    }

                    public String toString() {
                        return id + ": " + name;
                    }
                }
                class Library {
                    ArrayList<Book> books = new ArrayList<>();
                    ArrayList<User> users = new ArrayList<>();

                    void addBook(Book b) { books.add(b); }
                    void addUser(User u) { users.add(u); }

                    void showBooks() {
                        if (books.isEmpty()) System.out.println("No books.");
                        for (Book b : books) System.out.println(b);
                    }

                    void showUsers() {
                        if (users.isEmpty()) System.out.println("No users.");
                        for (User u : users) System.out.println(u);
                    }

                    void issueBook(int id) {
                        for (Book b : books) {
                            if (b.id == id) {
                                if (!b.issued) {
                                    b.issue();
                                    System.out.println("Issued.");
                                } else {
                                    System.out.println("Already issued.");
                                }
                                return;
                            }
                        }
                        System.out.println("Book not found.");
                    }

                    void returnBook(int id) {
                        for (Book b : books) {
                            if (b.id == id) {
                                if (b.issued) {
                                    b.returned();
                                    System.out.println("Returned.");
                                } else {
                                    System.out.println("Not issued.");
                                }
                                return;
                            }
                        }
                        System.out.println("Book not found.");
                    }
                }

                public class BookLibrary {
                    public static void main(String[] args) {
                        Library lib = new Library(); // Use Library object
                        Scanner sc = new Scanner(System.in);

                        lib.addBook(new Book(1, "King's Path", "Oda"));
                        lib.addBook(new Book(2, "Sea Map", "Nami"));
                        lib.addBook(new Book(3, "Devil Fruits", "Vegapunk"));

                        lib.addUser(new User(1, "Luffy"));
                        lib.addUser(new User(2, "Zoro"));
                        lib.addUser(new User(3, "Nami"));

                        int ch;
                        do {
                            System.out.println("\n--- OP Library ---");
                            System.out.println("1. Show Books\n2. Show Users\n3. Issue Book\n4. Return Book\n5. Exit");
                            System.out.print("Choose: ");
                            ch = sc.nextInt();

                            switch (ch) {
                                case 1 -> lib.showBooks();
                                case 2 -> lib.showUsers();
                                case 3 -> {
                                    System.out.print("Book ID: ");
                                    lib.issueBook(sc.nextInt());
                                }
                                case 4 -> {
                                    System.out.print("Book ID: ");
                                    lib.returnBook(sc.nextInt());
                                }
                                case 5 -> System.out.println("Closed.");
                                default -> System.out.println("Invalid.");
                            }
                        } while (ch != 5);

                        sc.close();
                    }
                }