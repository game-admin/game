/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.trainee.quiz;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Eric
 */
@Named
@RequestScoped
public class QuizController {
    private Quiz quiz = new Quiz();
    
    public String check() {
        return "result.xhtml";
    }
}
