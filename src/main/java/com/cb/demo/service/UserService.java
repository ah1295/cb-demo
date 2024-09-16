package com.cb.demo.service;

import com.cb.demo.model.User;

import java.util.List;

public interface UserService {
    public User save(User user);

    List<User> getUsers();

    List<User> findByProcessedFalse();
}
