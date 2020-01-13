/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.trainee.testquiz;

/**
 *
 * @author Eric
 */
public class TestQuiz {
        
   public String fragen;
   public String[] antworten;
   public int indexrichtig;
   
   public TestQuiz() {}
   
   public TestQuiz(String fragen, String[] antworten, int indexrichtig) {
      this.fragen=fragen;
      this.antworten=antworten;
      this.indexrichtig=indexrichtig;
   }
   
    public String getFragen() {
        return fragen;
    }

    public void setFragen(String fragen) {
        this.fragen = fragen;
    }

    public String[] getAntworten() {
        return antworten;
    }

    public void setAntworten(String[] antworten) {
        this.antworten = antworten;
    }

    public int getIndexrichtig() {
        return indexrichtig;
    }

    public void setIndexrichtig(int indexrichtig) {
        this.indexrichtig = indexrichtig;
    }
}
