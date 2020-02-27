/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.trainee.kurs;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import org.game.trainee.kurs.Kurs;

/**
 *
 * @author Jan
 */
@Stateless
public class KursEJB {
    @PersistenceContext(unitName = "Diplomarbeit")
    private EntityManager em;
    
    public Kurs find(String KursID) {
        return em.find(Kurs.class, KursID);
    }
    
    public void update(Kurs kurs) {
        em.merge(kurs);
    }
    
    public void delete(int KursID) {
        em.getTransaction().begin();
        Kurs k = em.getReference(Kurs.class, KursID);
        em.remove(k);
        em.getTransaction().commit();
    }
}
