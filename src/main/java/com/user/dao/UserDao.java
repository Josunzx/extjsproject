package com.user.dao;

import com.user.entity.UserEntity;

public interface UserDao {

    UserEntity getUserByName(String username);
}
