package com.book.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.dao.BookDao;
import com.book.entity.Book;
import com.book.service.BookService;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    @Override
    public String findBookById(int id) {
        return this.bookDao.findBookById(id);
    }

    @Override
    public void saveBook(Book book) {
        this.bookDao.saveBook(book);
    }
}
