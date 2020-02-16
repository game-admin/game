/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.trainee.testquiz;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import org.game.trainee.testquiz.Frage;

/**
 *
 * @author Jan
 */
@Stateless
public class FrageEJB {
    @PersistenceContext(unitName = "Diplomarbeit")
    private EntityManager em;

    public Frage find(int FID) {
        return em.find(Frage.class, FID);
    }
    
    public void update(Frage f) {
        em.merge(f);
    }
    
    public void delete(int FID) {
        em.getTransaction().begin();
        Frage f = em.getReference(Frage.class, FID);
        em.remove(f);
        em.getTransaction().commit();
    }
}
