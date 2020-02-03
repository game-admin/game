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
import org.game.trainee.testquiz.Quiz;

/**
 *
 * @author Jan
 */
public class QuizEJB {
    private EntityManagerFactory factory;
    private EntityManager em;
    private EntityTransaction tx;
    
    public QuizEJB() {
        factory = Persistence.createEntityManagerFactory("Diplomarbeit");
        em = factory.createEntityManager();
    }
    
    public void shutdown() {
        em.close();
        factory.close();
        em = null;
        factory = null;
    }
    
    public Quiz find(int QID) {
        return em.find(Quiz.class, QID);
    }
    
    public void persist(Quiz q) {
        em.getTransaction().begin();
        em.persist(q);
        em.getTransaction().commit();
    }
    
    public void delete(int QID) {
        em.getTransaction().begin();
        Quiz q = em.getReference(Quiz.class, QID);
        em.remove(q);
        em.getTransaction().commit();
    }
}
