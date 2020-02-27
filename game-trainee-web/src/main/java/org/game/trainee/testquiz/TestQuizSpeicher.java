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
    
    private final  List<String> fragen; 
    private final  String[][] antworten;
    private final  List<Integer> indexrichtig;
    
         
    public TestQuizSpeicher() {
       fragen = new ArrayList<>();
        fragen.add("Ist Java gut?");
        fragen.add("Ist Java auch eine Insel?");
        fragen.add("Wie gibt man Text in Java aus?");
        fragen.add("Wie muss man bei Klassennamen beachten?");
        
        antworten = new String[4][4];
        antworten[0][0] = "Ja";
        antworten[0][1] = "Nein";
        antworten[0][2] = "Vielleicht";
        antworten[0][3] = "kA";
        
        antworten[1][0] = "Ja";
        antworten[1][1] = "Nein";
        antworten[1][2] = "Vielleicht";
        antworten[1][3] = "kA";
        
        antworten[2][0] = "System.print();";
        antworten[2][1] = "System.out.print();";
        antworten[2][2] = "System.print.out();";
        antworten[2][3] = "Print();";
        
        antworten[3][0] = "Der Anfangsbuchstabe muss klein sein!";
        antworten[3][1] = "Der Anfangsbuchstabe muss groß sein!";
        antworten[3][2] = "Vielleicht";
        antworten[3][3] = "Antwortmöglichkeit 4";
        
        indexrichtig = new ArrayList<>();
        indexrichtig.add(0);
        indexrichtig.add(0);
        indexrichtig.add(1);
        indexrichtig.add(1); 
    }
    
    public List<TestQuiz> createQuiz(int size, boolean isMultipleChoice) {
        List<TestQuiz> list = new ArrayList<>();
        for(int i = 0 ; i < size ; i++) {
            list.add(new TestQuiz(getFragenFromIndex(i), getAntwortenFromIndex(i), getIndexrichtigFromIndex(i) ));
        }
        return list;
    }
    
    public boolean[] createButtons(int size) { //Deprecated?
        boolean[] b = new boolean[size];
        for(int i=0; i<b.length; i++)
            b[i] = false;
        return b;
    }
    
    public String getFragenFromIndex(int index) {
        return fragen.get(index);
    }
    
    public String[] getAntwortenFromIndex(int index) {
        return antworten[index];
    }
    
    public int getIndexrichtigFromIndex(int index) {
        return indexrichtig.get(index);
    }

    public List<String> getFragen() {
        return fragen;
    }

    public String[][] getAntworten() {
        return antworten;
    }

    public List<Integer> getIndexrichtig() {
        return indexrichtig;
    }   
}
