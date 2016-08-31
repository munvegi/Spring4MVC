package com.munvegi.springmvc.dao;

import com.munvegi.springmvc.model.Phone;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("phoneDAO")
//@Transactional // Optional?
public class PhoneDAOImpl implements PhoneDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Phone phone) {
        sessionFactory.getCurrentSession().save(phone);
    }

    @Override
    public Phone findById(int id) {
        return (Phone) sessionFactory.getCurrentSession().get(Phone.class, id);
    }

    @Override
    public void deleteById(int id) {
        Session session = sessionFactory.getCurrentSession();

        Query<Phone> query = session.createQuery("delete Phone where id = :id");
        query.setParameter("id", id);
        int result = query.executeUpdate();
    }

    @Override
    public void update(Phone phone) {
        sessionFactory.getCurrentSession().update(phone);

    }

    @Override
    public List<Phone> findAll() {
        Query<Phone> query = getSession().createQuery("from Phone");
        List<Phone> list = query.list();
        return list;
    }

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

}