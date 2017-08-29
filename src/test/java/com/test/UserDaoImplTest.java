package com.test;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.book.entity.Book;
import com.book.service.BookService;

public class UserDaoImplTest {
    private ApplicationContext context = null;
    private BookService bookService = null;

    {
        this.context = new ClassPathXmlApplicationContext(
            "applicationContext.xml");
        this.bookService = this.context.getBean(BookService.class);
    }

    @Test
    public void test() {
        DataSource dataSource = this.context.getBean(DataSource.class);
        System.out.println(dataSource);
    }

    @Test
    public void test2() {
        String bookName = this.bookService.findBookById(1);
        System.out.println(bookName);
    }

    @Test
    public void test3() {
        this.bookService.saveBook(new Book(2, "android源码分析", "1002", 45, 10));
    }
}