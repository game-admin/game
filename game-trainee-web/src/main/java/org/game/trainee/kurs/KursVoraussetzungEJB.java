/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.trainee.kurs;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 *
 * @author Jan
 */
@Stateless
public class KursVoraussetzungEJB {
    @PersistenceContext(unitName = "Diplomarbeit")
    private EntityManager em;
    
    public KursVoraussetzung find(String KursVoraussetzID) {
        return em.find(KursVoraussetzung.class, KursVoraussetzID);
    }
    
    
    
    public void update(KursVoraussetzung KursVoraussetzID) {
        em.merge(KursVoraussetzID);
    }
    
    public void delete(String KursVoraussetzID) {
        em.getTransaction().begin();
        KursVoraussetzung kursvoraussetzung = em.getReference(KursVoraussetzung.class, KursVoraussetzID);
        em.remove(kursvoraussetzung);
        em.getTransaction().commit();
    }
    
    public List<KursVoraussetzung> findAllKursVoraussetzzungen(String kursid) {
        return em.createNamedQuery(KursVoraussetzung.QUERY_FINDALLVORAUSSETZUNGEN, KursVoraussetzung.class)
                .setParameter("KursID", kursid).getResultList();
    }
}
