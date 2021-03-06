package com.project.repository;

import com.project.model.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    private List<User> users = new ArrayList<>();

    public UserRepository() {

    }

    public void save(User user) {
        users.add(user);
    }

    public boolean delete(User user) {
        users.remove(user);
        return true;
    }

    public User findUser(int userId) {
        for (User user: users) {
            if(user.getUserId() == userId) {
                return user;
            }
        }
        return null;
    }

    public void printBarrowedBook() {
        for (User user : users) {
            System.out.println("Id: " + user.getUserId() + " Name: " + user.getNameOfUser());
            for (int i = 0; i < user.getBorrowedBooks().size(); i++) {
                System.out.println("Name of book: " + user.getBorrowedBooks().get(i).getIdBook()
                        + " date: " + user.getBorrowedBooks().get(i).getDateOfBarrow()
                        + " dateR: " + user.getBorrowedBooks().get(i).getDateOfReturn());
            }
        }
    }

    public List<User> getUsers() {
        return users;
    }
}
