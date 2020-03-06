/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.trainee.testquiz;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Jan
 */
@Stateless
public class QuizVoraussetzungEJB {
    @PersistenceContext(unitName = "Diplomarbeit")
    private EntityManager em;
    
    public QuizVoraussetzung find(String QuizVoraussetzID) {
        return em.find(QuizVoraussetzung.class, QuizVoraussetzID);
    }
    
    
    
    public void update(QuizVoraussetzung QuizVoraussetzID) {
        em.merge(QuizVoraussetzID);
    }
    
    public void delete(String QuizVoraussetzID) {
        em.getTransaction().begin();
        QuizVoraussetzung quizvoraussetzung = em.getReference(QuizVoraussetzung.class, QuizVoraussetzID);
        em.remove(quizvoraussetzung);
        em.getTransaction().commit();
    }
    
    public List<QuizVoraussetzung> findAllQuizVoraussetzzungen(String qid) {
        return em.createNamedQuery(QuizVoraussetzung.QUERY_FINDALLVORAUSSETZUNGEN, QuizVoraussetzung.class)
                .setParameter("QID", qid).getResultList();
    }
}
