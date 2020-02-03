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
import org.game.trainee.testquiz.Antwortmoeglichkeiten;


/**
 *
 * @author Jan
 */
public class AntwortmoeglichkeitenEJB {
    private EntityManagerFactory factory;
    private EntityManager em;
    private EntityTransaction tx;
    
    public AntwortmoeglichkeitenEJB() {
        factory = Persistence.createEntityManagerFactory("Diplomarbeit");
        em = factory.createEntityManager();
    }
    
    public void shutdown() {
        em.close();
        factory.close();
        em = null;
        factory = null;
    }
    
    public Antwortmoeglichkeiten find(int AntwID) {
        return em.find(Antwortmoeglichkeiten.class, AntwID);
    }
    
    public void persist(Antwortmoeglichkeiten antw) {
        em.getTransaction().begin();
        em.persist(antw);
        em.getTransaction().commit();
    }
    
    public void delete(int AntwID) {
        em.getTransaction().begin();
        Antwortmoeglichkeiten antw = em.getReference(Antwortmoeglichkeiten.class, AntwID);
        em.remove(antw);
        em.getTransaction().commit();
    }
}
