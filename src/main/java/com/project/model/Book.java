package com.project.model;

public class Book {

    private int bookId;
    private String nameOfBook;
    private String author;
    private boolean borrowed;

    public Book() {

    }
    public Book(int bookId, String nameOfBook, String author) {
        this.bookId = bookId;
        this.nameOfBook = nameOfBook;
        this.author = author;
        borrowed = false;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getNameOfBook() {
        return nameOfBook;
    }

    public void setNameOfBook(String nameOfBook) {
        this.nameOfBook = nameOfBook;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isStatus() {
        return status;
    }

    public void changeBorrowedStatus() {
        borrowed = !borrowed;
    }

    @Override
    public String toString() {
        return "ID: "+getBookId() + " Title: "+getNameOfBook() + " Author: "+getAuthor();
    }
}
