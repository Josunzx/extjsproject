package com.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.user.dao.UserDao;
import com.user.entity.UserEntity;
import com.user.service.UserSevice;
import com.util.Page;

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
    public Page<UserEntity> getUsers(int start, int size) {
        Page<UserEntity> page = new Page<>();
        int count = this.userDao.getCount();
        page.setCount(count);
        List<UserEntity> list = this.userDao.getUsers(start, size);
        page.setItems(list);
        return page;
    }

}
