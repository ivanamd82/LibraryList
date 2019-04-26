package com.project.repository;

import com.project.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookRepository {

    private List<Book> books = new ArrayList<>();

    public BookRepository() {

    }

    public void save(Book book) {
        books.add(book);
    }

    public void delete(Book book) {
        books.remove(book);
    }

    public Book findBook(int bookId) {

        /*return books.stream()
                .filter(book -> book.getBookId() == bookId)
                .findFirst()
                .orElseGet(null);*/
        for (Book book : books) {
            if (book.getBookId() == bookId) {
                return book;
            }
        }

        return null;
    }

    public void print() {
        System.out.println("Knjige: ");
        for (Book book : books) {
            System.out.println(book.getNameOfBook() + " " + book.isBorrowed());
        }
    }
}
