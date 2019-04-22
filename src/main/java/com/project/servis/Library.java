package com.project.servis;

import com.project.model.BarrowBook;
import com.project.model.Book;
import com.project.model.User;
import com.project.repository.BookRepository;
import com.project.repository.UserRepository;
/*
Repositories has to be provided as constructor arguments
Pleas consider using ternary operator instead of if else
bookRep is initialised on the beggining
But it should be provided as part of constructor
And there should be checked if it set
Otherwise exception should be thrown
 */


public class Library {

    private BookRepository booksRep = new BookRepository();
    private UserRepository usersRep = new UserRepository();

    public Library() {

    }

    public void crateBook(int bookId, String nameOfBook, String author) {
        if (booksRep.findBook(bookId) == null) {
            Book book = new Book(bookId, nameOfBook, author);
            booksRep.save(book);
            System.out.println("Book added");
        }
        else {
            System.out.println("Id is already in use");
        }
    }

    public void createUser(int userId, String nameOfUser) {
        if (usersRep.findUser(userId) == null) {
            User user = new User(userId, nameOfUser);
            usersRep.save(user);
            System.out.println("User added");
        }
        else {
            System.out.println("Id is already in use");
        }
    }

    public void barrowBook(Book book, User user) {
        if (booksRep.findBook(book.getBookId()) == null && usersRep.findUser(user.getUserId()) == null ) {
            System.out.println("Book ID or user ID invalid.");
        }
        else {
            book = booksRep.findBook(book.getBookId());
            if (book.isStatus()) {
                book.changeStatus();
                for (int i = 0; i < usersRep.getUsers().size(); i++ ) {
                    if (usersRep.getUsers().get(i).getUserId() == user.getUserId()) {
                    BarrowBook barrowBook = new BarrowBook(book.getBookId());
                        usersRep.getUsers().get(i).getBarrowedBooks().add(barrowBook);
                    }
                }
            }
            else {
                System.out.println("Book is already borrowed.");
            }
        }
    }

    public void returnBook(int bookId, int userId) {
        if (booksRep.findBook(bookId) == null && usersRep.findUser(userId) == null ) {
            System.out.println("Book ID or user ID invalid.");
        }
        else {
            Book book = booksRep.findBook(bookId);
            User user = usersRep.findUser(userId);
            book.changeStatus();
            usersRep.returnBook(book.getBookId(), user);
        }
    }

    public void deleteUser(int userId){
        User user = usersRep.findUser(userId);
        usersRep.delete(user);
    }

    public void deleteBook(int bookId) {
        Book book = booksRep.findBook(bookId);
        booksRep.delete(book);
    }

    public void print() {
        booksRep.print();
    }
    public void printB() {
        usersRep.printBarrowedBook();
    }
}
