package com.project.ivana.servis;

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
        library.barrowBook(1,1);
        library.print();
        library.printB();
        library.barrowBook(1,2);
        library.returnBook(1,1);
        library.print();
        library.printB();
    }
}
