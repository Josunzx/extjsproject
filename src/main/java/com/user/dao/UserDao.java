package com.user.dao;

import java.util.List;

import com.user.entity.UserEntity;

public interface UserDao {

    UserEntity getUserByName(String username);

    UserEntity getUserById(int id);

    List<UserEntity> getUsers();
}
