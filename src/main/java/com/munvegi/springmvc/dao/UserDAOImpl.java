package com.munvegi.springmvc.dao;

import com.munvegi.springmvc.model.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("userDAO")
@Transactional // Optional?
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public User findById(int id) {
        return (User) sessionFactory.getCurrentSession().get(User.class, id);
    }

    @Override
    public void deleteById(int id) {
        Session session = sessionFactory.getCurrentSession();

        Query<User> query = session.createQuery("delete User where id = :id");
        query.setParameter("id", id);
        int result = query.executeUpdate();

//        session.delete(findById(id));


//        User user = (User) session.createCriteria(User.class).add(Restrictions.idEq(id))
//                .uniqueResult();
//        session.delete(user);

    }

    @Override
    public void update(User user) {
        sessionFactory.getCurrentSession().update(user);

    }


    @Override
    public List<User> findAll() {
        Query<User> query = getSession().createQuery("from User");
        List<User> list = query.list();
        return list;
    }

    @Override
    public User findByName(String name) {
        Query<User> query = sessionFactory.getCurrentSession().createQuery("from User where name = :name");
        query.setParameter("name", name);
        try {
            return query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Unused, replaced by an HQL query in the findAll() method
    public <T> List<T> getAll(final Class<T> type) {
        final Session session = sessionFactory.getCurrentSession();
        final Criteria crit = session.createCriteria(type);
        return crit.list();
    }

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

}