package com.munvegi.springmvc.dao;

import com.munvegi.springmvc.model.User;

import java.util.List;

// Feature branch comment
public interface UserDAO {
    void save(User user);

    User findById(int id);

    void update(User user);

    void deleteById(int id);

    List<User> findAll();

    User findByName(String name);
}
