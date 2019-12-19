/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.trainee.testquiz;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 *
 * @author Eric
 */
@Named
@ApplicationScoped
public class TestQuizSpeicher {
    
    public final static String[] fragen;
    public final static String[][] antworten;
    public final static int[] indexrichtig;
    
    static {
        fragen = new String[4];
        fragen[0] = "Ist Java gut?";
        fragen[1] = "Ist Java auch eine Insel?";
        fragen[2] = "Wie gibt man Text in Java aus?";
        fragen[3] = "Wie muss man bei Klassennamen beachten?";
        
        antworten = new String[4][2];
        antworten[0][0] = "Ja";
        antworten[0][1] = "Nein";
        
        antworten[1][0] = "Ja";
        antworten[1][1] = "Nein";
        
        antworten[2][0] = "System.print();";
        antworten[2][1] = "System.out.print();";
        
        antworten[3][0] = "Der Anfangsbuchstabe muss klein sein!";
        antworten[3][1] = "Der Anfangsbuchstabe muss groß sein!";
        
        indexrichtig = new int[4];
        indexrichtig[0]=0;
        indexrichtig[1]=0;
        indexrichtig[2]=1;
        indexrichtig[3]=1;
    }
    public TestQuiz createQuiz() {
        TestQuiz neu = new TestQuiz(getFragen(), getAntworten(), getRichtige());
       return neu;
    }
    
    public String[] getFragen() {
        return fragen;
    }
    
    public String[][] getAntworten() {
        return antworten;
    }
    
    public int[] getRichtige() {
        return indexrichtig;
    }
    
}
