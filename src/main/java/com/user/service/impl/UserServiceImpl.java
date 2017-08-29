package com.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.user.dao.UserDao;
import com.user.entity.UserEntity;
import com.user.service.UserSevice;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserSevice {

    @Autowired
    private UserDao userDao;

    @Override
    public UserEntity getUserByName(String username) {
        return this.userDao.getUserByName(username);
    }

    @Override
    public UserEntity getUserById(int id) {
        return this.userDao.getUserById(id);
    }

    @Override
    public List<UserEntity> getUsers() {
        return this.userDao.getUsers();
    }

}
