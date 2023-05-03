package com.sp.midTerm.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.sp.midTerm.model.Booking;


public class BookingDao {
	EntityManagerFactory entityManagerFactory;
    EntityManager entityManager;
    

    public BookingDao() {
        entityManagerFactory = Persistence.createEntityManagerFactory("trainBookingSystem");
        entityManager = entityManagerFactory.createEntityManager();
    }
    public void close() {
        entityManager.close();
        entityManagerFactory.close();
    }
    public List<Booking> list() {
        entityManager.clear();
        return entityManager.createQuery("from bookingDetails", Booking.class).getResultList();
    }

    public void create(Booking booking) {
        entityManager.getTransaction().begin();
        entityManager.persist(booking);
        entityManager.getTransaction().commit();
        entityManager.clear();
    }

    public Booking read(Long id) {
        return entityManager.find(Booking.class, id);
    }

    public void update(Booking booking) {
        entityManager.getTransaction().begin();
        entityManager.merge(booking);
        entityManager.getTransaction().commit();
    }

    public void delete(long id) {
        entityManager.getTransaction().begin();
        entityManager.remove(read(id));
        entityManager.getTransaction().commit();
    }
}
