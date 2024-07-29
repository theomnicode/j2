package com.brytcode.springjdbc.book;

import java.math.BigDecimal;
import java.util.Objects;

public class Book {
    private int bookId;
    private String bookName;
    private BigDecimal price;
    private int noOfPages;
    private int publisherId;

    public Book() {
    }

    public Book(int bookId, String bookName, BigDecimal price, int noOfPages, int publisherId) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.price = price;
        this.noOfPages = noOfPages;
        this.publisherId = publisherId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getNoOfPages() {
        return noOfPages;
    }

    public void setNoOfPages(int noOfPages) {
        this.noOfPages = noOfPages;
    }

    public int getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return bookId == book.bookId;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(bookId);
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", price=" + price +
                ", noOfPages=" + noOfPages +
                ", publisherId=" + publisherId +
                '}';
    }
}
