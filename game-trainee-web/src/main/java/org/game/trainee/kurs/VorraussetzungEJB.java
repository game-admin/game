/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.trainee.kurs;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.game.trainee.kurs.Vorraussetzung;

/**
 *
 * @author Jan
 */
public class VorraussetzungEJB {
    private EntityManagerFactory factory;
    private EntityManager em;
    private EntityTransaction tx;
    
    public VorraussetzungEJB() {
        factory = Persistence.createEntityManagerFactory("Diplomarbeit");
        em = factory.createEntityManager();
    }
    
    public void shutdown() {
        em.close();
        factory.close();
        em = null;
        factory = null;
    }
    
    public Vorraussetzung find(int VorraussetzID) {
        return em.find(Vorraussetzung.class, VorraussetzID);
    }
    
    public void persist(Vorraussetzung v) {
        em.getTransaction().begin();
        em.persist(v);
        em.getTransaction().commit();
    }
    
    public void delete(int VorraussetzID) {
        em.getTransaction().begin();
        Vorraussetzung v = em.getReference(Vorraussetzung.class, VorraussetzID);
        em.remove(v);
        em.getTransaction().commit();
    }
}