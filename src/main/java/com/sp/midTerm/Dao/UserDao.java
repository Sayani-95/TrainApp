package com.sp.midTerm.Dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.sp.midTerm.model.User;


public class UserDao {
    EntityManagerFactory entityManagerFactory;
    EntityManager entityManager;

    public UserDao() {
        entityManagerFactory = Persistence.createEntityManagerFactory("trainBookingSystem");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public void close() {
        entityManager.close();
        entityManagerFactory.close();
    }

    public User read(String username) {
        return entityManager.createQuery("from User user where user.username = '" + username + "'", User.class).getSingleResult();
    }
}

