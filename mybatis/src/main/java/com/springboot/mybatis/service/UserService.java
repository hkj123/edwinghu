package com.springboot.mybatis.service;

import com.springboot.mybatis.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
}
