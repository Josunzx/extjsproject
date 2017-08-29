package com.book.dao;

import com.book.entity.Book;

public interface BookDao {
    public String findBookById(int id);

    public void saveBook(Book book);
}
