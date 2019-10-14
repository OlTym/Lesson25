package com.tym.dao;

import com.tym.model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.validation.ConstraintViolationException;
import java.util.List;

public class UserDao {

    public UserDao() {
    }

    public List<User> getAll() {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            return session.createQuery("From User").list();
        }
    }

    public void addUser(User user) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        }
    }


}
