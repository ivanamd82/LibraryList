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
        if (books.size() != 0) {
            for (int i = 0; i < books.size(); i++) {
                if (books.get(i).getBookId() == bookId) {
                    return books.get(i);
                }
            }
        }
        return null;
    }

    public void print() {
        System.out.println("Knjige: ");
        for (Book book: books
             ) {
            System.out.println(book.getNameOfBook() + " " + book.isStatus());
        }
    }
}
