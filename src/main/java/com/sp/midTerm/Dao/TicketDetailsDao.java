package com.sp.midTerm.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.sp.midTerm.model.TicketDetails;


public class TicketDetailsDao {
	EntityManagerFactory entityManagerFactory;
    EntityManager entityManager;

    public TicketDetailsDao() {
        entityManagerFactory = Persistence.createEntityManagerFactory("trainBookingSystem");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public void close() {
        entityManager.close();
        entityManagerFactory.close();
    }


    public List<TicketDetails> list() {
        entityManager.clear();
        return entityManager.createQuery("from Ticket", TicketDetails.class).getResultList();
    }

    public void create(TicketDetails passenger) {
        entityManager.getTransaction().begin();
        entityManager.persist(passenger);
        entityManager.getTransaction().commit();
        entityManager.clear();
    }

    public TicketDetails read(Long id) {
        return entityManager.find(TicketDetails.class, id);
    }

    public void update(TicketDetails passenger) {
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
