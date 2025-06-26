import java.util.ArrayList;
import java.util.Scanner;

public class libraryManagementSystem{
    public static void main(String[] args) {
        Library lib=new Library();
        Scanner sc=new Scanner(System.in);

        //add books to library intially
        lib.addBook(new Book(1002,"Data Structures","Reema Thareja"));
        lib.addBook(new Book(1523,"The Art of Computer Programming","Donald knuth"));
        lib.addBook(new Book(1008,"Java:A Beginner's Guide","Herbert Schildt"));

        //pre defined data of users
        lib.addUser(new User(103 ,"Ram" ));
        lib.addUser(new User(153 ,"shyam" ));

        //menu
        System.out.println("1.add books");
        System.out.println("2.add users");
        System.out.println("3.view books");
        System.out.println("4.view users");
        System.out.println("5.issue book");
        System.out.println("6.return book");
        System.out.println("7.exit");


        while (true) {
            System.out.print("enter your option:");
            int opt=sc.nextInt();
            switch (opt) {
                case 1:
                    System.out.print("enter bookid,title,author:");
                    int bid=sc.nextInt();
                    String title=sc.nextLine();
                    String author=sc.next();
                    lib.addBook(new Book(bid, title, author));
                    break;
                case 2:
                    System.out.print("enter userid,username:");
                    int uid=sc.nextInt();
                    String uname=sc.nextLine();
                    lib.addUser(new User(uid, uname));
                    break;
                case 3:
                    lib.displayBooks();
                    break;
                case 4:
                    lib.displayUsers();
                    break;
                case 5:
                    System.out.print("enter book ID to issue:");
                    int id_issue=sc.nextInt();
                    lib.issueBook(id_issue);
                    break;
                case 6:
                    System.out.print("enter book ID to return:");
                    int id_return=sc.nextInt();
                    lib.returnBook(id_return);
                    break;
                case 7:
                    System.out.println("exiting library");
                    sc.close();
                    return;
                default:
                    System.out.println("invalid choice");
                    break;
            }

        }

    }
}
class Book{
    private int bookId;
    private String bookTitle;
    private String authorName;
    private boolean isIssued;
    public Book(int id,String title,String name){
        this.bookId=id;
        this.bookTitle=title;
        this.authorName=name;
        this.isIssued=false;
    }
    public int getId(){
        return bookId;
    }
    public String getTitle(){
        return bookTitle;
    }
    public String getAuthor(){
        return authorName;
    }
    public boolean isIssued(){
        return isIssued;
    }

    public void issue(){
        this.isIssued=true;
    }
    public void returned(){
        this.isIssued=false;
    }
    @Override
    public String toString() {
        return "[" + bookId + "] " + bookTitle + " by " + authorName + (isIssued ? " (Issued)" : "");
    }

}
class User{
    private int userId;
    private String userName;

    //constructor
    public User(int id,String name){
        this.userId=id;
        this.userName=name;
    }

    //getters
    public int getId(){
        return this.userId;
    }
    public String getName(){
        return this.userName;
    }

    @Override
    public String toString() {
        return "User ID: " + userId + ", Name: " + userName;
    }
}
class Library{
    private ArrayList<Book> books;
    private ArrayList<User> users;
    public Library(){
        this.books=new ArrayList<>();
        this.users=new ArrayList<>();
    }
    //adding book
    public void addBook(Book book){
        books.add(book);
    }
    //adding user
    public void addUser(User user){
        users.add(user);
    }
    //display books
    public void displayBooks(){
        for(Book book:books){
            System.out.println(book);
        }
    }
    //display users
    public void displayUsers(){
        for(User user:users){
            System.out.println(user);
        }
    }
    //issue book
    public void issueBook(int bookId){
        for(Book book:books){
            if(book.getId()==bookId){
                if(book.isIssued()){
                    System.out.println("book is already issued.");
                }
                else{
                    book.issue();
                    System.out.println("book issued successfully.");
                }
                return;
            }
        }
        System.out.println("there is no book with this ID");
    }
    //returning book
    public void returnBook(int bookId){
        for(Book book:books){
            if(book.getId()==bookId){
                if(book.isIssued()){
                    book.returned();
                    System.out.println("book returned succesfully.");
                }
                else{
                    System.out.println("book wasn't issued.");
                }
                return;
            }
        }
        System.out.println("there is no book with this ID");
    }
}