package com.project.servis;

import com.project.model.Book;
import com.project.model.User;
import com.project.repository.BookRepository;

public class Test {

    public static void main(String[] args) {

        Library library = new Library();
        library.crateBook(1,"Plavi cuperak", "Misroslav Antic");
        library.crateBook(2, "Bajke", "Braca Grim");
        library.createUser(1,"Mateo");
        library.createUser(2,"Klara");
        library.print();
        library.crateBook(1,"Plavi cuperak", "Misroslav Antic");
        library.print();
        Book book = new Book(1, "Plavi cuperak", "Misroslav Antic");
        User user = new User(1, "Mateo");
       // library.barrowBook(book,user);
        library.print();
        library.printB();
        library.barrowBook(book, user);
        library.print();
        library.printB();
        library.barrowBook(book, user);
        library.returnBook(1,1);
        library.print();
        library.printB();
    }
}
