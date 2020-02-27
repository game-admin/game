/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.trainee.traineeview;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import org.game.trainee.traineeview.Trainee;

/**
 *
 * @author Jan
 */
@Stateless
public class TraineeEJB {
    @PersistenceContext(unitName = "Diplomarbeit")
    private EntityManager em;

    public Trainee find(String MitID) {
        return em.find(Trainee.class, MitID);
    }
    
    public List<Trainee> findAll() {
        return em.createNamedQuery(Trainee.QUERY_FINDALLTRAINEES, Trainee.class).getResultList();
    }
    
    public void update(Trainee t) {
        em.merge(t);
    }
    
    public 
    
    public void delete(int MitID) {
        em.getTransaction().begin();
        Trainee t = em.getReference(Trainee.class, MitID);
        em.remove(t);
        em.getTransaction().commit();
    }
}
