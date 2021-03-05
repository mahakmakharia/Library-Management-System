package javaapplication1;
/**
 *
 * @author Manish
 */
public class Book {
	private String BookName;
	private String Author;
	private String Publisher;
	private String ISBNCode;

	private int BookId;
	private int NoOfCopies;
	private int NoOfCopiesIssued;

	public Book() {

		BookName = "";
		Author = "";
		Publisher = "";
		ISBNCode = "";
		BookId = 0;
		NoOfCopies = 0;
		NoOfCopiesIssued = 0;
	}

	public Book(String bookName, String author, String publisher, String iSBNCode,  int noOfCopies,
			int noOfCopiesIssued,int bookId) {
		super();
		BookName = bookName;
		Author = author;
		Publisher = publisher;
		ISBNCode = iSBNCode;
		BookId = bookId;
		NoOfCopies = noOfCopies;
		NoOfCopiesIssued = noOfCopiesIssued;
	}

	public String getBookName() {
		return BookName;
	}



	public void setBookName(String bookName) {
		BookName = bookName;
	}


	public String getAuthor() {
		return Author;
	}


	public void setAuthor(String author) {
		Author = author;
	}


	public String getPublisher() {
		return Publisher;
	}


	public void setPublisher(String publisher) {
		Publisher = publisher;
	}


	public String getISBNCode() {
		return ISBNCode;
	}


	public void setISBNCode(String iSBNCode) {
		ISBNCode = iSBNCode;
	}


	public int getNoOfCopies() {
		return NoOfCopies;
	}


	public void setNoOfCopies(int noOfCopies) {
		NoOfCopies = noOfCopies;
	}


	public int getBookId() {
		return BookId;
	}


	public void setBookId(int bookId) {
		BookId = bookId;
	}

	public int getNoOfCopiesIssued() {
		return NoOfCopiesIssued;
	}


	public void setNoOfCopiesIssued(int noOfCopiesIssued) {
		NoOfCopiesIssued = noOfCopiesIssued;
	}



}
