package com.user.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.user.dao.UserDao;
import com.user.entity.UserEntity;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private SessionFactory sessionFactory;

    //获取和当前线程绑定的Session
    private Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public UserEntity getUserByName(String username) {
        String hql = "from UserEntity where username=:username";
        Query query = this.getSession().createQuery(hql)
            .setString("username", username);
        UserEntity user = (UserEntity) query.uniqueResult();
        return user;
    }
}
