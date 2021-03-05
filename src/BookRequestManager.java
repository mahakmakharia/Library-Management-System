/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.io.*;
import java.util.*;

/**
 *
 * @author Mahak Makharia
 */
public class BookRequestManager {

    private ArrayList<BookRequest> bookRequestList;
    private String FILE_PATH;

    public boolean init() {
        this.bookRequestList = new ArrayList<>();
        this.FILE_PATH = "data\\bookrequest.csv";
        return read();
    }

    public boolean read() {
        boolean flag = false;
        File file = new File(FILE_PATH);
        //reads the file only if the file contains anything
        if (file.length() != 0) {
            try {
                BufferedReader br = new BufferedReader(new FileReader(FILE_PATH));
                String fileContent;
                while ((fileContent = br.readLine()) != null) {
                    String[] requestData = fileContent.split(",");
                    if (requestData.length != 5) {
                        continue;
                    }
                    BookRequest bookRequest = new BookRequest();
                    bookRequest.setRequestId(requestData[0]);
                    bookRequest.setUserId(Integer.parseInt(requestData[1]));
                    bookRequest.setBookName(requestData[2]);
                    bookRequest.setAuthorName(requestData[3]);
                    bookRequest.setPublisher(requestData[4]);
                    //adding each row to the array list
                    bookRequestList.add(bookRequest);
                    flag = true;
                }
                br.close();

            } catch (IOException e) {
                System.out.println("Error while reading file:" + e.getLocalizedMessage());
            }
        }

        return flag;
    }

    public ArrayList<BookRequest> getBookRequests() {
        return bookRequestList;
    }

    public boolean newBookRequest(BookRequest bookRequest) {
        bookRequest.setRequestId(Integer.toString(bookRequest.getUserId()) + bookRequest.getBookName());
        boolean flag = false;
        bookRequestList.add(bookRequest);
        flag = writeBookRequestToFile(bookRequest);
        return flag;
    }

    public boolean writeBookRequestToFile(BookRequest bookRequest) {
        boolean flag = false;
        try {
            FileWriter fw = new FileWriter(FILE_PATH, true);
            try ( BufferedWriter bw = new BufferedWriter(fw)) {
                bw.newLine();
                bw.write(bookRequest.getRequestId() + "," + bookRequest.getUserId() + "," + bookRequest.getBookName() + ","
                        + bookRequest.getAuthorName() + "," + bookRequest.getPublisher());
            } catch (IOException e) {
                System.out.println("Error while writing into file: " + e.getLocalizedMessage());
            }
            flag = true;
        } catch (IOException e) {
            System.out.println("File not found " + e.getLocalizedMessage());
        }
        return flag;
    }

//    public static void main(String[] args) {
//
//        BookRequestManager requestManager = new BookRequestManager();
//        requestManager.init();
//        int length=requestManager.bookRequestList.size();
//        requestManager.newBookRequest(new BookRequest("", 1 ,"Physics", "Das Pal", "SChand"));
//        assert requestManager.bookRequestList.size() == length+1: "request couldn't be processed";
//    }
}
