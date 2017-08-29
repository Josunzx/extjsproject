package com.book.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Book {
    private Integer id;
    private String bookName;
    private String isbn;
    private int price;
    private int stock;

    // 主键 ：@Id    主键生成方式：strategy = "increment"
    //映射表中id这个字段，不能为空，并且是唯一的
    @GenericGenerator(name = "generator", strategy = "increment")
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "ID", unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "BOOK_NAME")
    public String getBookName() {
        return this.bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    @Column(name = "ISBN")
    public String getIsbn() {
        return this.isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Column(name = "PRICE")
    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Column(name = "STOCK")
    public int getStock() {
        return this.stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Book(Integer id, String bookName, String isbn, int price, int stock) {
        super();
        this.id = id;
        this.bookName = bookName;
        this.isbn = isbn;
        this.price = price;
        this.stock = stock;
    }
}