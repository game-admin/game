/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.trainee.EJB;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.game.trainee.testquiz.Quiz;

/**
 *
 * @author Jan
 */
@Stateless
public class QuizFacade extends AbstractFacade<Quiz> {

    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public QuizFacade() {
        super(Quiz.class);
    }
    
}
