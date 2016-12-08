package com.tcl.librory.models;

import java.util.Date;

/**
 * Created by franc on 12/8/2016.
 */
public class Book {

    private Long id;
    private Long controlNumber;
    private String isbn;
    private String title;
    private String author;
    private String publisher;
    private Date publishedDate;
    private Genre genre;
    private Librarian librarian;

    public Book() {
    }

    public Book(Long id, Long controlNumber, String isbn, String title, String author, String publisher, Date publishedDate, Genre genre, Librarian librarian) {
        this.id = id;
        this.controlNumber = controlNumber;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.publishedDate = publishedDate;
        this.genre = genre;
        this.librarian = librarian;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getControlNumber() {
        return controlNumber;
    }

    public void setControlNumber(Long controlNumber) {
        this.controlNumber = controlNumber;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Librarian getLibrarian() {
        return librarian;
    }

    public void setLibrarian(Librarian librarian) {
        this.librarian = librarian;
    }

}
