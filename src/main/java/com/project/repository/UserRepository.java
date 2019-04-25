package com.project.repository;

import com.project.model.BarrowBook;
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

    public void barrowBook(int bookId, User user) {
        for (int i = 0; i < users.size(); i++ ) {
            if (users.get(i).getUserId() == user.getUserId()) {
                BarrowBook barrowBook = new BarrowBook(bookId);
                users.get(i).getBarrowedBooks().add(barrowBook);
            }
        }
    }
     public void returnBook(int bookId, User user) {
        for (int i = 0; i < users.size(); i++ ) {
            if (users.get(i).getUserId() == user.getUserId()) {
                for(int j = 0; j < users.get(i).getBarrowedBooks().size(); j++) {
                    if (users.get(i).getBarrowedBooks().get(j).getIdBook() == bookId) {
                        users.get(i).getBarrowedBooks().get(j).setDateOfReturn(LocalDate.now());
                    }
                }
            }
        }
    }

    public void printBarrowedBook() {
        for (User user : users) {
            System.out.println("Id: " + user.getUserId() + " Name: " + user.getNameOfUser());
            for (int i = 0; i < user.getBarrowedBooks().size(); i++) {
                System.out.println("Name of book: "+user.getBarrowedBooks().get(i).getIdBook()
                        +" date: "+user.getBarrowedBooks().get(i).getDateOfBarrow()
                        +" dateR: "+user.getBarrowedBooks().get(i).getDateOfReturn());
            }
        }
    }

    public List<User> getUsers() {
        return users;
    }
}
