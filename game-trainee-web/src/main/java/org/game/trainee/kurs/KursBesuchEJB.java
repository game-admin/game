/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.trainee.kurs;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Jan
 */
public class KursBesuchEJB {
    @PersistenceContext(unitName = "Diplomarbeit")
    private EntityManager em;
    
    public KursBesuch find(String kursbesuchid) {
        return em.find(KursBesuch.class, kursbesuchid);
    }
    
    
    
    public void update(KursBesuch kursbesuch) {
        em.merge(kursbesuch);
    }
    
    public void delete(String kursbesuchid) {
        em.getTransaction().begin();
        KursBesuch kursbesuch = em.getReference(KursBesuch.class, kursbesuchid);
        em.remove(kursbesuch);
        em.getTransaction().commit();
    }
    
    public List<KursBesuch> findByKursIDAndMITID(String kursid, String mitid) {
        return em.createNamedQuery(KursBesuch.QUERY_FINDBY_KURSIDANDMITID, KursBesuch.class)
                .setParameter("KursID", kursid).setParameter("MitID", mitid).getResultList();
    }
}
