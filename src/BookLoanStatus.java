/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author kousheya
 */
public class BookLoanStatus {

    private int BookId = 0;
    private int UserId = 0;
    private int IssueId = 0;
    private String IssueDate = "";
    private String ReturnDate = "";
    
//    BookLoanStatus(int bookId, int userId, int issueId, String issueDate, 
//            String returnDate){
//        
//        this.BookId=bookId;
//        this.UserId=issueId;
//        this.UserId=userId;
//        this.IssueDate=issueDate;
//        this.ReturnDate=returnDate;
//    }

    public int getBookId() {
        return BookId;
    }

    public int getUserId() {
        return UserId;
    }

    public int getIssueId() {
        return IssueId;
    }

    public String getIssueDate() {
        return IssueDate;
    }

    public String getReturnDate() {
        return ReturnDate;
    }

    public void setBookId(int BookId) {
        this.BookId = BookId;
    }

    public void setUserId(int UserId) {
        this.UserId = UserId;
    }

    public void setIssueId(int IssueId) {
        this.IssueId = IssueId;
    }

    public void setIssueDate(String IssueDate) {
        this.IssueDate = IssueDate;
    }

    public void setReturnDate(String ReturnDate) {
        this.ReturnDate = ReturnDate;
    }
}
