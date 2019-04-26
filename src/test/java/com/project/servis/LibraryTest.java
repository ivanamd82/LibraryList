package com.project.servis;

import com.project.exception.BookAlreadyExistsException;
import com.project.exception.BookIdInvalidException;
import com.project.exception.UserAlreadyExistsException;
import com.project.exception.UserIdInvalidException;
import com.project.model.Book;
import com.project.model.User;
import com.project.repository.BookRepository;
import com.project.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class LibraryTest {

    private UserRepository userRepositoryMock = Mockito.mock(UserRepository.class);
    private BookRepository bookRepositoryMock = Mockito.mock(BookRepository.class);

    private Library library;

    @Before
    public void setup(){
        library = new Library(bookRepositoryMock, userRepositoryMock);
            }

    @Test
    public void createBook_successfullySavesANewBook() throws BookAlreadyExistsException {
        //Given non existing book
        Book newBook = library.crateBook(1, "BOOK", "AUTHOR");

        assertThat(newBook.getBookId(), is(1));
        assertThat(newBook.getAuthor(), is("AUTHOR"));
        assertThat(newBook.getNameOfBook(), is("BOOK"));
    }

    @Test(expected = BookAlreadyExistsException.class)
    public void createBook_throws_BookAlreadyExistsException_when_tryToSaveAlreadyExistingBook() throws BookAlreadyExistsException {
        Mockito.when(bookRepositoryMock.findBook(1)).thenReturn(new Book());

        library.crateBook(1, "BOOK", "AUTHOR");
    }

    @Test
    public void createUser_successfullySaveesNewUser() throws UserAlreadyExistsException {
        User newUser = library.createUser(1,"Name");

        assertThat(newUser.getUserId(), is(1));
        assertThat(newUser.getNameOfUser(), is("Name"));
    }

    @Test(expected = UserAlreadyExistsException.class)
    public void createUser_throws_UserAlreadyExsistException_when_tryToSaveAlreadyExistingUser() throws UserAlreadyExistsException {
        Mockito.when(userRepositoryMock.findUser(1)).thenReturn(new User());

        library.createUser(1, "Name");
    }

    @Test(expected = UserIdInvalidException.class)
    public void deleteUser_throws_UserIdInvalidException_when_User_no_exist() throws UserIdInvalidException {
        Mockito.when(userRepositoryMock.findUser(1)).thenReturn(null);
        library.deleteUser(1);
    }

    @Test
    public void deleteUser_return_true_when_user_is_deleted() {

    }

    @Test(expected = BookIdInvalidException.class)
    public void deleteBook_throws_BookIdInvalidException_when_Book_no_exist() throws BookIdInvalidException {
        Mockito.when(bookRepositoryMock.findBook(1)).thenReturn(null);
        library.deleteBook(1);
    }

}
