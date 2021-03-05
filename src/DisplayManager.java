/*
 * To change this license mainMgrer, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.ArrayList;

/**
 *
 * @author Mahak
 */
public class DisplayManager {

    private AddBookUI addBookScreen;
    private EditBookUI editBookScreen;
    private DeleteBookUI deleteBookScreen;
    private ViewBooksUI viewAllBooksScreen;
    private ViewRequestsUI viewRequestsScreen;
    private BookLoanUI viewBookLoanedScreen;
    private AdminDashboardUI adminScreen;
    private StudentDashboardUI studentScreen;
    private IssueBookUI issueBookScreen;
    private ReturnBookUI returnBookScreen;
    private RequestBookUI requestBookScreen;
    private LoginUI loginScreen;

    public void init(MainManager mainMgr) {
        this.loginScreen = new LoginUI(this, mainMgr);
        this.studentScreen = new StudentDashboardUI(this);
        this.adminScreen = new AdminDashboardUI(this);
        this.addBookScreen = new AddBookUI(this, mainMgr);
        this.editBookScreen = new EditBookUI(this, mainMgr);
        this.deleteBookScreen = new DeleteBookUI(mainMgr);
        this.viewAllBooksScreen = new ViewBooksUI(this, mainMgr);
        this.viewRequestsScreen = new ViewRequestsUI(mainMgr);
        this.viewBookLoanedScreen = new BookLoanUI(mainMgr);
        this.issueBookScreen = new IssueBookUI(this, mainMgr);
        this.returnBookScreen = new ReturnBookUI(mainMgr);
        this.requestBookScreen = new RequestBookUI(mainMgr);

    }

    public void startApp() {
        displayLoginUI();
    }

    public void displayLoginUI() {
        this.loginScreen.setVisible(true);
    }

    public void displayAdminUI() {
        this.adminScreen.setVisible(true);
    }

    public void displayStudentUI() {
        this.studentScreen.setVisible(true);
    }

    public void displayIssueBookUI() {
        this.issueBookScreen.setVisible(true);
    }

    public void displayReturnBookUI() {
        this.returnBookScreen.setVisible(true);
    }

    public void displayRequestBookUI() {
        this.requestBookScreen.setVisible(true);
    }

    public void displayAddBookUI() {
        this.addBookScreen.setVisible(true);
    }

    public void displayEditBookUI() {
        this.editBookScreen.setVisible(true);
    }

    public void displayDeleteBookUI() {
        this.deleteBookScreen.setVisible(true);
    }

    public void displayAllBooks() {
//        this.viewAllBooksScreen = new ViewBooksUI(this.BookList, new BookManager());
        this.viewAllBooksScreen.setVisible(true);
    }

    public void displayBookRequests() {
        this.viewRequestsScreen.setVisible(true);
    }

    public void displayAllLoanedBooks() {
        this.viewBookLoanedScreen.setVisible(true);
    }
}
