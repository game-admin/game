/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.trainee.testquiz;

import java.util.ArrayList;
import java.util.List;
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
    
    private final  String[] fragen; //kein static!
    private final  String[][] antworten;
    private final  int[] indexrichtig;
    
         
    public TestQuizSpeicher() {
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
    
    public List<TestQuiz> createQuiz(int size) {
        List<TestQuiz> list = new ArrayList<>();
        for(int i = 0 ; i < size ; i++) {
            list.add(new TestQuiz(getFragenFromIndex(i), getAntwortenFromIndex(i), getIndexrichtigFromIndex(i) ));
        }
         
        return list;
    }
    /*public TestQuiz createQuiz() {
        TestQuiz neu = new TestQuiz(getFragen(), getAntworten(), getRichtige());
       return neu;
    } */
    
    public String getFragenFromIndex(int index) {
       
        return fragen[index];
    }
    
    public String[] getAntwortenFromIndex(int index) {
        return antworten[index];
    }
    
    public int getIndexrichtigFromIndex(int index) {
        return indexrichtig[index];
    }

    public String[] getFragen() {
        return fragen;
    }

    public String[][] getAntworten() {
        return antworten;
    }

    public int[] getIndexrichtig() {
        return indexrichtig;
    }
    
    
    
}
