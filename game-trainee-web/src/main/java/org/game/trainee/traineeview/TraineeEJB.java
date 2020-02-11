/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.trainee.traineeview;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.game.trainee.traineeview.Trainee;

/**
 *
 * @author Jan
 */
public class TraineeEJB {
    private EntityManagerFactory factory;
    private EntityManager em;
    private EntityTransaction tx;
    
    public TraineeEJB() {
        factory = Persistence.createEntityManagerFactory("Diplomarbeit");
        em = factory.createEntityManager();
    }
    
    public void shutdown() {
        em.close();
        factory.close();
        em = null;
        factory = null;
    }
    
    public Trainee find(int MitID) {
        return em.find(Trainee.class, MitID);
    }
    
    public void persist(Trainee t) {
        em.getTransaction().begin();
        em.persist(t);
        em.getTransaction().commit();
    }
    
    public void delete(int MitID) {
        em.getTransaction().begin();
        Trainee t = em.getReference(Trainee.class, MitID);
        em.remove(t);
        em.getTransaction().commit();
    }
}
