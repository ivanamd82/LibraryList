package com.project;

import com.project.repository.BookRepository;
import com.project.repository.UserRepository;
import com.project.servis.Library;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    static Scanner input = new Scanner(System.in);

    public static BookRepository bookRepository(){
        return new BookRepository();
    }

    public static UserRepository userRepository(){
        return new UserRepository();
    }

    public static void main(String[] args) {

        new Library(bookRepository(), userRepository());

        while (true) {
            printMainMenu();
        }
    }

    private static void printMainMenu() {

        System.out.println("1. Create user \n" +
                "2. Print user details\n" +
                "3. Create books\n" +
                "4. Print book details\n" +
                "5. Barrow a book\n" +
                "6. Return a book\n" +
                "0. Exit");


        try {
            int choice = input.nextInt();

            switch (choice) {
                case 1: {
                    break;
                }
                case 2: {
                    printUserDetails();
                    break;
                }
                case 3: {
                    crateBook();
                    break;
                }
                case 4: {
                    printBookDetails();
                    break;
                }
                case 5: {
                    barrowBook();
                    break;
                }
                case 6: {
                    returnBook();
                    break;
                }
                case 0: {
                    System.exit(0);
                }
                default: throw new InputMismatchException("Wrong input.");
            }

        }
        catch (InputMismatchException ex) {
            System.out.println("Wrong input. Try again: ");
            input.nextLine();
        }

    }

    private static void barrowBook() {
    }

    private static void returnBook() {
    }

    private static void printBookDetails() {
    }

    private static void crateBook() {
    }

    private static void printUserDetails() {
    }

}
