/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.trainee.EJB;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.game.trainee.kurs.Kurs;

/**
 *
 * @author Jan
 */
public class KursEJB {
    private EntityManagerFactory factory;
    private EntityManager em;
    private EntityTransaction tx;
    
    public KursEJB() {
        factory = Persistence.createEntityManagerFactory("Diplomarbeit");
        em = factory.createEntityManager();
    }
    
    public void shutdown() {
        em.close();
        factory.close();
        em = null;
        factory = null;
    }
    
    public Kurs find(int KursID) {
        return em.find(Kurs.class, KursID);
    }
    
    public void persist(Kurs k) {
        em.getTransaction().begin();
        em.persist(k);
        em.getTransaction().commit();
    }
    
    public void delete(int KursID) {
        em.getTransaction().begin();
        Kurs k = em.getReference(Kurs.class, KursID);
        em.remove(k);
        em.getTransaction().commit();
    }
}
