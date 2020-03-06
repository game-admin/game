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
public class QuizbeantwortungEJB {
    @PersistenceContext(unitName = "Diplomarbeit")
    private EntityManager em;
    
    public Quizbeantwortung find(String qbeid) {
        return em.find(Quizbeantwortung.class, qbeid);
    }
    
    
    
    public void update(Quizbeantwortung quizbeantw) {
        em.merge(quizbeantw);
    }
    
    public void delete(String qbeid) {
        em.getTransaction().begin();
        Quizbeantwortung quizbeantw = em.getReference(Quizbeantwortung.class, qbeid);
        em.remove(quizbeantw);
        em.getTransaction().commit();
    }
    
    public List<Quizbeantwortung> findByQIDAndMITID(String qid, String mitid) {
        return em.createNamedQuery(Quizbeantwortung.QUERY_FINDBY_QIDANDMITID, Quizbeantwortung.class)
                .setParameter("QID", qid).setParameter("MitID", mitid).getResultList();
    }
}
