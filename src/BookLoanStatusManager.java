package javaapplication1;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
import java.util.*;

/**
 *
 * @author kousheya
 */
public class BookLoanStatusManager {

    private static ArrayList<BookLoanStatus> BooksLoaned;
    private static ArrayList<Book> Books;
    private String FILEPATH1;
    private String FILEPATH2;

    public boolean init() {
        this.BooksLoaned = new ArrayList<BookLoanStatus>();
        this.Books = new ArrayList<Book>();
        this.FILEPATH1 = "data\\bookloan.csv";
        this.FILEPATH2 = "data\\book.csv";
        boolean flag1 = readBooksLoaned();
        boolean flag2 = readBooks();
        return flag1 && flag2;
    }

    public boolean readBooksLoaned() {
        boolean flag = false;
        try {
            BufferedReader br = new BufferedReader(new FileReader(FILEPATH1));
            String s;
            while ((s = br.readLine()) != null) {
                String[] requestData = s.split(",");
                BookLoanStatus b3 = new BookLoanStatus();
                b3.setBookId(Integer.parseInt(requestData[0]));
                b3.setUserId(Integer.parseInt(requestData[1]));
                b3.setIssueId(Integer.parseInt(requestData[2]));
                b3.setIssueDate(requestData[3]);
                if (requestData.length == 5) {
                    b3.setReturnDate(requestData[4]);
                }
                BooksLoaned.add(b3);
                flag = true;

            }
        } catch (IOException e) {
            System.out.println("File not found!" + e.getLocalizedMessage());
        }
//        test(); //remove later
        return flag;
    }

    public ArrayList<BookLoanStatus> getBooksLoaned() {
        return BooksLoaned;

    }

    public boolean readBooks() {
        boolean flag = false;
        try {
            BufferedReader br = new BufferedReader(new FileReader(FILEPATH2));
            String s;
            while ((s = br.readLine()) != null) {
                String[] requestData = s.split(",");
                if (requestData.length < 3) {
                    continue;
                }
                Book b3 = new Book();
                b3.setBookName(requestData[0]);
                b3.setAuthor(requestData[1]);
                b3.setPublisher(requestData[2]);
                b3.setISBNCode(requestData[3]);
                b3.setNoOfCopies(Integer.parseInt(requestData[4]));
                b3.setNoOfCopiesIssued(Integer.parseInt(requestData[5]));
                b3.setBookId(Integer.parseInt(requestData[6]));
                Books.add(b3);
                flag = true;

            }
        } catch (IOException e) {
            System.out.println("File not found!" + e.getLocalizedMessage());
        }
        return flag;
    }

    public ArrayList<Book> getBooks() {
        return Books;

    }

    public boolean issueBook(int bId, int uId) {
        boolean canIssueBook = true;
        BookLoanStatus b2 = new BookLoanStatus();
        String tempId = (Integer.toString(bId)).concat(Integer.toString(uId));
        int issueId = Integer.parseInt(tempId);
        System.out.println(issueId);
        for (int i = BooksLoaned.size() - 1; i >= 0; i--) {
            if (BooksLoaned.get(i).getIssueId() == issueId) {
                if (BooksLoaned.get(i).getReturnDate() == "") {
                    System.out.println("Book already issued.");
                    canIssueBook = false;

                    break;
                }
            }
        }
        if (canIssueBook == true) {

            for (int i = 0; i < Books.size(); i++) {
                if ((Books.get(i).getBookId() == bId) && ((Books.get(i).getNoOfCopies() - Books.get(i).getNoOfCopiesIssued()) > 0)) {

                    Books.get(i).setNoOfCopiesIssued(Books.get(i).getNoOfCopiesIssued() + 1);

                    b2.setBookId(bId);
                    b2.setUserId(uId);
                    b2.setIssueId(issueId);
                    String issueDate = java.time.LocalDate.now().toString();
                    b2.setIssueDate(issueDate);
                    BooksLoaned.add(b2);

                    canIssueBook = true;
                    updateBooksLoaned();
                    updateBooks();
                    break;
                } else {
                    canIssueBook = false;
                }
            }
        }
        return canIssueBook;
    }

    public boolean returnBook(int bId, int uId) {
        String tempId = (Integer.toString(bId)).concat(Integer.toString(uId));
        int issueId = Integer.parseInt(tempId);
        boolean flag = false;
        for (int i = BooksLoaned.size() - 1; i >= 0; i--) {
            System.out.println(issueId + "," + BooksLoaned.get(i).getIssueId());
            if (BooksLoaned.get(i).getIssueId() == (issueId) && BooksLoaned.get(i).getReturnDate() != "") {
                System.out.println("Book returned already.");
                break;
            } else if (BooksLoaned.get(i).getIssueId() == (issueId)) {
                System.out.println(bId);
                String returnDate = java.time.LocalDate.now().toString();
                for (int j = 0; j < Books.size(); j++) {
                    if ((Books.get(j).getBookId() == bId) && (Books.get(j).getNoOfCopiesIssued() > 0)) {
                        Books.get(j).setNoOfCopiesIssued(Books.get(j).getNoOfCopiesIssued() - 1);
                        //System.out.println("Hello");
                        updateBooks();

                        break;
                    }
                }
                BooksLoaned.get(i).setReturnDate(returnDate);
                updateBooksLoaned();
                flag = true;
                break;
            }
        }
        return flag;
    }

    public boolean updateBooksLoaned() {
        boolean flag = false;
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(FILEPATH1));
            BookLoanStatus d3 = new BookLoanStatus();
            d3 = BooksLoaned.get(0);
            bw.write(d3.getBookId() + "," + d3.getUserId() + "," + d3.getIssueId() + ","
                    + d3.getIssueDate() + "," + d3.getReturnDate());
            bw.newLine();
            for (int i = 1; i < BooksLoaned.size(); i++) {
                d3 = BooksLoaned.get(i);
                try {
                    BufferedWriter bwr;
                    bwr = new BufferedWriter(new FileWriter(FILEPATH1, true));
                    bw.write(d3.getBookId() + "," + d3.getUserId() + "," + d3.getIssueId() + "," + d3.getIssueDate() + "," + d3.getReturnDate());
                    bw.newLine();
                    bwr.close();
                } catch (FileNotFoundException e) {
                    System.out.println("File not found! " + e.getLocalizedMessage());
                }
            }
            bw.close();
            flag = true;
        } catch (IOException e) {
            System.out.println("IOException!" + e.getLocalizedMessage());
        }
        return flag;
    }

    public boolean updateBooks() {
        boolean flag = false;
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(FILEPATH2));
            Book d3 = new Book();
            d3 = Books.get(0);
            bw.write(d3.getBookName() + "," + d3.getAuthor() + "," + d3.getPublisher() + "," + d3.getISBNCode() + "," + d3.getNoOfCopies() + "," + d3.getNoOfCopiesIssued() + "," + d3.getBookId());
            bw.newLine();
            for (int i = 1; i < Books.size(); i++) {
                d3 = Books.get(i);
                try {
                    BufferedWriter bwr;
                    bwr = new BufferedWriter(new FileWriter(FILEPATH2, true));
                    bw.write(d3.getBookName() + "," + d3.getAuthor() + "," + d3.getPublisher() + "," + d3.getISBNCode() + "," + d3.getNoOfCopies() + "," + d3.getNoOfCopiesIssued() + "," + d3.getBookId());
                    bw.newLine();
                    bwr.close();
                } catch (FileNotFoundException e) {
                    System.out.println("File not found! " + e.getLocalizedMessage());
                }
            }
            bw.close();
            flag = true;
        } catch (Exception e) {
            System.out.println("IOException!" + e.getLocalizedMessage());
        }
        return flag;
    }

//    public static void main(String args[]) {
//
//        BookLoanStatusManager m1 = new BookLoanStatusManager();
//        m1.init();
//        int length = m1.BooksLoaned.size();
//        m1.issueBook(3, 126);
//        m1.updateBooksLoaned();
//        System.out.println(length + "," + m1.BooksLoaned.size());
//        assert (m1.BooksLoaned.size() != length) : "Book not issued";
//
//    }
}
