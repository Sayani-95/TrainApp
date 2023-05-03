package com.sp.midTerm.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.sp.midTerm.model.Passenger;

public class PassengerDao {
	EntityManagerFactory entityManagerFactory;
    EntityManager entityManager;
    

    public PassengerDao() {
        entityManagerFactory = Persistence.createEntityManagerFactory("trainBookingSystem");
        entityManager = entityManagerFactory.createEntityManager();
    }
    public void close() {
        entityManager.close();
        entityManagerFactory.close();
    }


    public List<Passenger> list() {
        entityManager.clear();
        return entityManager.createQuery("from Passenger", Passenger.class).getResultList();
    }

    public void create(Passenger passenger) {
        entityManager.getTransaction().begin();
        entityManager.persist(passenger);
        entityManager.getTransaction().commit();
        entityManager.clear();
    }

    public Passenger read(Long id) {
        return entityManager.find(Passenger.class, id);
    }

    public void update(Passenger passenger) {
        entityManager.getTransaction().begin();
        entityManager.merge(passenger);
        entityManager.getTransaction().commit();
    }

    public void delete(long id) {
        entityManager.getTransaction().begin();
        entityManager.remove(read(id));
        entityManager.getTransaction().commit();
    }
}
