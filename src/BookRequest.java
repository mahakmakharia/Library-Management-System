/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

;

/**
 *
 * @author Mahak Makharia
 */
public class BookRequest {

    private int userId;
    private String requestId;
    private String bookName;
    private String authorName;
    private String publisher;

    BookRequest() {
    }

    BookRequest(String requestId, int userId, String bookName, String authorName, String publisher) {
        this.userId = userId;
        this.requestId = requestId;
        this.bookName = bookName;
        this.authorName = authorName;
        this.publisher = publisher;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

}
