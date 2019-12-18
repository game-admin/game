/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.trainee.testquiz;

import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Eric
 */
@Named
@ViewScoped
public class TestQuizAnzeigen implements Serializable {
    private TestQuiz quiz;
    
    @Inject
    private TestQuizSpeicher speicher;
    
    public TestQuizAnzeigen() {}
} 

