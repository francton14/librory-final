package com.tcl.librory.models;

import java.util.Date;

/**
 * Created by franc on 12/8/2016.
 */
public class BookBorrow {

    private Long id;
    private Book book;
    private String borrower;
    private Librarian librarian;
    private Date startDate;
    private Date dueDate;
    private Date returnedDate;

    public BookBorrow() {
    }

    public BookBorrow(Long id, Book book, String borrower, Librarian librarian, Date startDate, Date dueDate, Date returnedDate) {
        this.id = id;
        this.book = book;
        this.borrower = borrower;
        this.librarian = librarian;
        this.startDate = startDate;
        this.dueDate = dueDate;
        this.returnedDate = returnedDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getBorrower() {
        return borrower;
    }

    public void setBorrower(String borrower) {
        this.borrower = borrower;
    }

    public Librarian getLibrarian() {
        return librarian;
    }

    public void setLibrarian(Librarian librarian) {
        this.librarian = librarian;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getReturnedDate() {
        return returnedDate;
    }

    public void setReturnedDate(Date returnedDate) {
        this.returnedDate = returnedDate;
    }

}
