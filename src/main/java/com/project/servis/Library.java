package com.project.servis;

import com.project.exception.BookAlreadyExistsException;
import com.project.exception.BookIdInvalidException;
import com.project.exception.UserAlreadyExistsException;
import com.project.exception.UserIdInvalidException;
import com.project.model.BorrowedBook;
import com.project.model.Book;
import com.project.model.User;
import com.project.repository.BookRepository;
import com.project.repository.UserRepository;

import java.time.LocalDate;
import java.util.Objects;

public class Library {

    private BookRepository booksRep;
    private UserRepository usersRep;

    public Library(BookRepository booksRep, UserRepository usersRep) {
        this.booksRep = booksRep;
        this.usersRep = usersRep;
    }

    public Book crateBook(int bookId, String nameOfBook, String author) throws BookAlreadyExistsException {
        if (Objects.nonNull(booksRep.findBook(bookId))) {
            throw new BookAlreadyExistsException();
        }
        Book book = new Book(bookId, nameOfBook, author);
        booksRep.save(book);
        System.out.println("Book added");
        return book;
    }

    public User createUser(int userId, String nameOfUser) throws UserAlreadyExistsException {
        if (Objects.nonNull(usersRep.findUser(userId))) {
            throw new UserAlreadyExistsException();
        }
        User user = new User(userId, nameOfUser);
        usersRep.save(user);
        System.out.println("User added");
        return user;


    }

    public boolean borrowBook(Book book, User user) {
        if (booksRep.findBook(book.getBookId()) == null || usersRep.findUser(user.getUserId()) == null) {
            System.out.println("Book ID or user ID invalid.");
            return false;
        }
        book = booksRep.findBook(book.getBookId());

        if (book.isBorrowed()) {
            System.out.println("Book is already borrowed.");
            return false;
        }
        else {
            book.changeBorrowedStatus();
            for (int i = 0; i < usersRep.getUsers().size(); i++) {
                if (usersRep.getUsers().get(i).getUserId() == user.getUserId()) {
                    BorrowedBook borrowedBook = new BorrowedBook(book.getBookId());
                    usersRep.getUsers().get(i).getBorrowedBooks().add(borrowedBook);
                }
            }
            return true;
        }
    }

    public boolean returnBook(int bookId, int userId) {
        Book book = booksRep.findBook(bookId);
        User user = usersRep.findUser(userId);
        if (book == null || user == null) {
            System.out.println("Book ID or user ID invalid.");
            return false;
        }
        book.changeBorrowedStatus();
        for (int i = 0; i < usersRep.getUsers().size(); i++) {
            if (usersRep.getUsers().get(i).getUserId() == user.getUserId()) {
                for (int j = 0; j < usersRep.getUsers().get(i).getBorrowedBooks().size(); j++) {
                    if (usersRep.getUsers().get(i).getBorrowedBooks().get(j).getIdBook() == bookId) {
                        usersRep.getUsers().get(i).getBorrowedBooks().get(j).setDateOfReturn(LocalDate.now());
                    }
                }
            }
        }
        return true;
    }

    public boolean deleteUser(int userId) throws UserIdInvalidException {
        if (Objects.isNull(usersRep.findUser(userId))) {
            throw new UserIdInvalidException();
        }
        User user = usersRep.findUser(userId);
        usersRep.delete(user);
        return true;
    }

    public boolean deleteBook(int bookId) throws BookIdInvalidException {
        if (Objects.isNull(booksRep.findBook(bookId))) {
            throw new BookIdInvalidException();
        }
        Book book = booksRep.findBook(bookId);
        booksRep.delete(book);
        return true;
    }

    public void print() {
        booksRep.print();
    }

    public void printB() {
        usersRep.printBarrowedBook();
    }
}
