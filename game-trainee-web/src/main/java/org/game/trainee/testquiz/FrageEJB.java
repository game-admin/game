/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.trainee.testquiz;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import static java.util.stream.Collectors.toCollection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.game.trainee.testquiz.Frage;

/**
 *
 * @author Jan
 */
@Stateless
public class FrageEJB {
    @PersistenceContext(unitName = "Diplomarbeit")
    private EntityManager em;
    private Frage frage;

    public Frage find(String FID) {
        return em.find(Frage.class, FID);
    }
    
    public List<Frage> findAll() {
        return em.createNamedQuery(Frage.QUERY_FINDALLFRAGEN, Frage.class)
                .getResultList();
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
    
    public List<Frage> findFrageByQID(String qid) {
        return em.createNamedQuery(Frage.QUERY_FINDFRAGENZUQID, Frage.class)
                .setParameter("QID", qid).getResultList();
    }
    
    /*
    public List<Frage> findQuizFragen(int index) {
        Query query = em.createQuery("SELECT * FROM frage f WHERE QID ="+index+";");
        Collection<Frage> collection;
        collection = (Collection<Frage>) query.getResultList();
        ArrayList<Frage> newList = collection.stream().collect(toCollection(ArrayList::new));
        return newList;
    }
    */

    
}
