package com.munvegi.springmvc.dao;

import com.munvegi.springmvc.model.Phone;
import com.munvegi.springmvc.model.User;

// Develop branch changes
import java.util.List;

public interface PhoneDAO {
    void save(Phone phone);

    Phone findById(int id);

    void update(Phone phone);

    void deleteById(int id);

    List<Phone> findAll();
}
