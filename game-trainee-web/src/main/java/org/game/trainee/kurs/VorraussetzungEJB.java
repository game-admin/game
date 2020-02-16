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
import org.game.trainee.kurs.Vorraussetzung;

/**
 *
 * @author Jan
 */
@Stateless
public class VorraussetzungEJB {
    @PersistenceContext(unitName = "Diplomarbeit")
    private EntityManager em;
    
    public Vorraussetzung find(int VorraussetzID) {
        return em.find(Vorraussetzung.class, VorraussetzID);
    }
    
    public void update(Vorraussetzung v) {
        em.merge(v);
    }
    
    public void delete(int VorraussetzID) {
        em.getTransaction().begin();
        Vorraussetzung v = em.getReference(Vorraussetzung.class, VorraussetzID);
        em.remove(v);
        em.getTransaction().commit();
    }
}