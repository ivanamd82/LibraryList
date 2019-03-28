package com.project.ivana.servis;

import com.project.ivana.model.Book;
import com.project.ivana.model.User;
import com.project.ivana.repository.BookRepository;
import com.project.ivana.repository.UserRepository;


public class Library {

    private BookRepository booksRep = new BookRepository();
    private UserRepository usersRep = new UserRepository();

    public Library() {

    }

    public boolean checkUserID(int userId) {
        if (usersRep.findUser(userId) == null) {
            return false;
        }
        else {
            return true;
        }
    }

    public boolean checkBookID(int bookId) {
        if (booksRep != null) {
            if (booksRep.findBook(bookId) == null) {
                return false;
            }
            else {
                return true;
            }
        }
        return false;
    }

    public void crateBook(int bookId, String nameOfBook, String author) {
        if (checkBookID(bookId) == false) {
            Book book = new Book(bookId, nameOfBook, author);
            booksRep.addBook(book);
            System.out.println("Book added");
        }
        else {
            System.out.println("Id is already in use");
        }
    }
    public void createUser(int userId, String nameOfUser) {
        if (checkUserID(userId) == false) {
            User user = new User(userId, nameOfUser);
            usersRep.addUser(user);
            System.out.println("User added");
        }
        else {
            System.out.println("Id is already in use");
        }
    }
    public void barrowBook(int bookId, int userId) {
        if (booksRep.findBook(bookId) != null && usersRep.findUser(userId) != null ) {
            Book book = booksRep.findBook(bookId);
            User user = usersRep.findUser(userId);
            if (book.isStatus()) {
                book.changeStatus();
                usersRep.barrowBook(book.getBookId(),user);
            }
            else {
                System.out.println("Book is already borrowed.");
            }
        }
        else {
            System.out.println("Book ID or user ID invalid.");
        }

    }
    public void returnBook(int bookId, int userId) {
        if (booksRep.findBook(bookId) != null && usersRep.findUser(userId) != null ) {
            Book book = booksRep.findBook(bookId);
            User user = usersRep.findUser(userId);
            book.changeStatus();
            usersRep.returnBook(book.getBookId(), user);
        }
        else {
            System.out.println("Book ID or user ID invalid.");
        }
    }

    public void print() {

        booksRep.print();
    }
    public void printB() {
        usersRep.printBarrowedBook();
    }
}
