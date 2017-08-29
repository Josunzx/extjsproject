package com.book.service;

import com.book.entity.Book;

public interface BookService {
    public String findBookById(int id);

    public void saveBook(Book book);
}
