package com.book.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.book.dao.BookDao;
import com.book.entity.Book;

@Repository
public class BookDaoImpl implements BookDao {
    @Autowired
    private SessionFactory sessionFactory;

    //获取和当前线程绑定的Session
    private Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public String findBookById(int id) {
        String hql = "SELECT bookName from Book where id=?";
        Query query = this.getSession().createQuery(hql).setInteger(0, id);
        String str = query.uniqueResult().toString();
        return str;
    }

    @Override
    public void saveBook(Book book) {
        this.getSession().save(book);
    }
}
