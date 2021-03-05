package javaapplication1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;

/**
 *
 * @author Manish
 */
public class BookManager {

    private ArrayList<Book> BookList;
    private String FILE_PATH;
    private MainManager mainMgr;

    BookManager(MainManager mainMgr) {
        this.mainMgr = mainMgr;
    }

    public boolean init() {
        this.BookList = new ArrayList<Book>();
        this.FILE_PATH = "data/book.csv";
        return read();
    }

    public boolean read() {
        String path = FILE_PATH;
        boolean flag = false;
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String s;
            FileWriter fw = new FileWriter(path, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.newLine();
            while ((s = br.readLine()) != null) {

                String[] data = s.split(",");

                //order: book name,author name,publisher,ISBN Code, no of copies, no of copies issued, book ID
                Book book = new Book();
                book.setBookName(data[0]);
                book.setAuthor(data[1]);
                book.setPublisher(data[2]);
                book.setISBNCode(data[3]);
                book.setNoOfCopies(Integer.parseInt(data[4]));
                book.setNoOfCopiesIssued(Integer.parseInt(data[5]));
                book.setBookId(Integer.parseInt(data[6]));
                BookList.add(book);
                flag = true;
            }
            br.close();
            bw.close();
        } catch (Exception e) {

            System.out.println("File not found!" + e.getLocalizedMessage());
        }

        return flag;
    }

    public boolean addBook(Book book) {
        BookList.add(book);
        updateBookList();
        return true;

    }

    public boolean deleteBook(int bookId) {

        for (int i = 0; i < BookList.size(); i++) {

            if (BookList.get(i).getBookId() == bookId) {
                BookList.remove(i);
                updateBookList();
                return true;
            }
        }
        return false;

    }

    public ArrayList<Book> getAllBooks() {
        return this.BookList;
    }

    public Book getBook(int bookId) {

        for (int i = 0; i < BookList.size(); i++) {
            Book b = BookList.get(i);
            if (bookId == b.getBookId()) {
                return b;
            }
        }
        return null;
    }

    public boolean editBook(Book book) {
        int bookid = book.getBookId();
        for (int i = 0; i < BookList.size(); i++) {
            Book b = BookList.get(i);
            if (bookid == b.getBookId()) {
                BookList.set(i, book);
                updateBookList();
                return true;
            }
        }
        return false;
    }

    public boolean updateBookList() {

        boolean flag = false;
        try {
            String path = FILE_PATH;
            BufferedWriter bw = new BufferedWriter(new FileWriter(path));
            bw.write("");

            for (int i = 0; i < BookList.size(); i++) {
                Book b = BookList.get(i);
                bw.write(b.getBookName() + "," + b.getAuthor() + "," + b.getPublisher()
                        + "," + b.getISBNCode() + "," + b.getNoOfCopies()
                        + "," + b.getNoOfCopiesIssued() + "," + b.getBookId());

                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            System.out.print(e.getLocalizedMessage());

        }

        return flag;
    }

    public ArrayList<Book> searchBook(String bookName) {
        ArrayList<Book> bookList = new ArrayList<>();
        for (int i = 0; i < BookList.size(); i++) {
            String book = (BookList.get(i).getBookName()).toLowerCase();

            if (book.contains(bookName.toLowerCase()) || book.equalsIgnoreCase(bookName)) {
                bookList.add(BookList.get(i));
            }
        }
        return bookList;
    }

//    public static void main(String args[]) {
//        BookManager bm = new BookManager();
//        bm.init();
//		bm.read();
//		Book book=new Book("as","asd","asd","12",1,2,3);
//		ArrayList<Book> bookList=bm.getAllBooks();
//		int length=bookList.size();
//		bm.addBook(book);
//
//		assert bm.getAllBooks().size()==length+1:"error while adding book";
//		JFrame AdminDashboard = new AdminDashboardUI(bm);
//        AdminDashboard.setVisible(true);
//		bm.deleteBook(3);
//		assert bm.getAllBooks().size()==length:"cant delete";
//		bm.editBook(new Book("asasdw","asdsada","asdasdas","12",1,2,3));
//    }
}
