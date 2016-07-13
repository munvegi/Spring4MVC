package com.munvegi.springmvc.dao;

import com.munvegi.springmvc.model.User;

import java.util.List;

/**
 * Created by admin on 07/07/2016.
 */
public interface UserDAO {
    void save(User user);

    User findById(int id);

    void update(User user);

    void deleteById(int id);

    List<User> findAll();
}
