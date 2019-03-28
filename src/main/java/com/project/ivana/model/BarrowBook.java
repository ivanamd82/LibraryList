package com.project.ivana.model;

import java.time.LocalDate;

public class BarrowBook {

    private int idBook;
    private LocalDate dateOfBarrow;
    private LocalDate dateOfReturn;

    public BarrowBook() {

    }

    public BarrowBook(int idBook) {
        this.idBook = idBook;
        dateOfBarrow = LocalDate.now();
    }

    /*ova metoda mi se cini potpuno nepotrebna ovde, ali sad ne mogu da mislim o njoj posle cu to rijestiti
    jer mislim da bi trebalo da ova klasa sadrzi vezu na objekt Book i koristi metodu Book klase za dobijanje idBook
     */
    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public LocalDate getDateOfBarrow() {
        return dateOfBarrow;
    }

    public LocalDate getDateOfReturn() {
        return dateOfReturn;
    }

    public void setDateOfReturn(LocalDate dateOfReturn) {
        this.dateOfReturn = dateOfReturn;
    }

    @Override
    public String toString() {
        return "ID Book: "+idBook + " Date of barrow: "+ dateOfBarrow + " Date of return: "+dateOfReturn;
    }
}


