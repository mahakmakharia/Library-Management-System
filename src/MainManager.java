/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.ArrayList;

/**
 *
 * @author Mahak
 */
public class MainManager {

    private LoginManager loginMgr;
    private BookManager bMgr;
    private BookRequestManager brMgr;
    private BookLoanStatusManager blsMgr;
    private DisplayManager dispMgr;
    private int userId;
    private int bookId;
    private String userType;
//    private ArrayList<Book> BookList;

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

//    public ArrayList<Book> getBookList() {
//        return BookList;
//    }
//
//    public void setBookList(ArrayList<Book> BookList) {
//        this.BookList = BookList;
//    }
    public int getCurrentUserId() {
        return userId;
    }

    public void setCurrentUserId(int currentUserId) {
        this.userId = currentUserId;
    }

    //Functions of LoginManager
    public String verifyUser(int userId, String passwords, String userType) {
        return loginMgr.verifyUser(userId, passwords, userType);
    }

    //Functions of BookManager
    public boolean addBook(Book book) {
        return bMgr.addBook(book);
    }

    public boolean deleteBook(int bookId) {
        return bMgr.deleteBook(bookId);
    }

    public ArrayList<Book> getAllBooks() {
        return bMgr.getAllBooks();
    }

    public Book getBook(int bookId) {
        return bMgr.getBook(bookId);
    }

    public boolean editBook(Book book) {
        return bMgr.editBook(book);
    }

    public ArrayList<Book> searchBook(String bookName) {
        return bMgr.searchBook(bookName);
    }

    //Functions of BookLoanStatusManager
    public ArrayList<BookLoanStatus> getBooksLoaned() {
        return blsMgr.getBooksLoaned();
    }

    public boolean issueBook(int bId, int uId) {
        return blsMgr.issueBook(bId, uId);
    }

    public boolean returnBook(int bId, int uId) {
        return blsMgr.returnBook(bId, uId);
    }

    //Functions of BookRequestManager
    public ArrayList<BookRequest> getBookRequests() {
        return brMgr.getBookRequests();
    }

    public boolean newBookRequest(BookRequest bookRequest) {
        return brMgr.newBookRequest(bookRequest);
    }

    public boolean init() {
        loginMgr = new LoginManager();
        bMgr = new BookManager();
        brMgr = new BookRequestManager();
        blsMgr = new BookLoanStatusManager();
        boolean flag = bMgr.init() && brMgr.init() && blsMgr.init();
        dispMgr = new DisplayManager();
        if (!flag) {
            System.out.println("Error in Initialization");
            System.exit(0);
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        MainManager head = new MainManager();

        if (head.init()) {
            head.dispMgr.init(head);
            head.dispMgr.startApp();
        }

    }
}
