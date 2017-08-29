package com.user.service;

import java.util.List;

import com.user.entity.UserEntity;

public interface UserSevice {
    UserEntity getUserByName(String username);

    UserEntity getUserById(int id);

    List<UserEntity> getUsers(int start, int size);
}
