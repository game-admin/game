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
import org.game.trainee.kurs.Voraussetzung;

/**
 *
 * @author Jan
 */
@Stateless
public class VoraussetzungEJB {
    @PersistenceContext(unitName = "Diplomarbeit")
    private EntityManager em;
    
    public Voraussetzung find(int VoraussetzID) {
        return em.find(Voraussetzung.class, VoraussetzID);
    }
    
    public void update(Voraussetzung v) {
        em.merge(v);
    }
    
    public void delete(int VoraussetzID) {
        em.getTransaction().begin();
        Voraussetzung v = em.getReference(Voraussetzung.class, VoraussetzID);
        em.remove(v);
        em.getTransaction().commit();
    }
}