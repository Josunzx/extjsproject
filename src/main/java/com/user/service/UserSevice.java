package com.user.service;

import com.user.entity.UserEntity;
import com.util.Page;

public interface UserSevice {
    UserEntity getUserByName(String username);

    UserEntity getUserById(int id);

    Page<UserEntity> getUsers(int start, int size);
}
