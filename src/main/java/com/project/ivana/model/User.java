package com.project.ivana.model;

import java.util.ArrayList;

public class User {

    private int userId;
    private String nameOfUser;
    private ArrayList<BarrowBook> barrowedBooks = new ArrayList<>();

    public User() {

    }

    public User(int userId, String nameOfUser) {
        this.userId = userId;
        this.nameOfUser = nameOfUser;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getNameOfUser() {
        return nameOfUser;
    }

    public void setNameOfUser(String nameOfUser) {
        this.nameOfUser = nameOfUser;
    }

    public ArrayList<BarrowBook> getBarrowedBooks() {
        return barrowedBooks;
    }

    @Override
    public String toString() {
        return "ID: "+getUserId() + " Name: "+getNameOfUser();
    }
}
