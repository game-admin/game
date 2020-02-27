/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.trainee.testquiz;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import org.game.trainee.testquiz.Quiz;

/**
 *
 * @author Jan
 */

@Stateless
public class QuizEJB {
    @PersistenceContext(unitName = "Diplomarbeit")
    private EntityManager em;
    
    public Quiz find(String QID) {
        return em.find(Quiz.class, QID);
    }
    
    public void update(Quiz q) {
        em.merge(q);
    }
    
    public void delete(int QID) {
        em.getTransaction().begin();
        Quiz q = em.getReference(Quiz.class, QID);
        em.remove(q);
        em.getTransaction().commit();
    }
    
    public List<Quiz> findByBeschreibung(String beschreibung) {
        return em.createNamedQuery(Quiz.QUERY_FINDBY_BESCHREIBUNG, Quiz.class)
                .setParameter("beschreibung", "%"+beschreibung+"%")
                .getResultList();
    }
}
