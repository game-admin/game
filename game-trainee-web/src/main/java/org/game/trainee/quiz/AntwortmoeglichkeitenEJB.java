/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.trainee.quiz;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import org.game.trainee.quiz.Antwortmoeglichkeiten;


/**
 *
 * @author Jan
 */
@Stateless
public class AntwortmoeglichkeitenEJB {
    @PersistenceContext(unitName = "Diplomarbeit")
    private EntityManager em;
    
    public Antwortmoeglichkeiten find(int AntwID) {
        return em.find(Antwortmoeglichkeiten.class, AntwID);
    }
    
    public void update(Antwortmoeglichkeiten antw) {
        em.merge(antw);
    }
    
    public void delete(int AntwID) {
        em.getTransaction().begin();
        Antwortmoeglichkeiten antw = em.getReference(Antwortmoeglichkeiten.class, AntwID);
        em.remove(antw);
        em.getTransaction().commit();
    }
    
    public List<Antwortmoeglichkeiten> findAntwortenByFID(String fid) {
        return em.createNamedQuery(Antwortmoeglichkeiten.QUERY_FINDANTWORTEN_BYFID, Antwortmoeglichkeiten.class)
                .setParameter("FID", fid).getResultList();
    }
    
}
