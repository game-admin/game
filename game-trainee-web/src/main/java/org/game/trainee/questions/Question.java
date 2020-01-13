/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.trainee.questions;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Eric/Jan
 */

@Entity
public class Question {
   @Id  @GeneratedValue
   private int fnr;
   private int qid;
   @NotNull
   private String text;
   @NotNull
   private Long points;
   //private String rightAnswer;
   //private String wrongAnswer;
   
   public Question() {}
   
   public Question(String text, String rightAnswer, String wrongAnswer) {
       this.text=text;
       /*this.rightAnswer = rightAnswer;
       this.wrongAnswer = wrongAnswer; */     
   }

    public int getFnr() {
        return fnr;
    }

    public void setFnr(int fnr) {
        this.fnr = fnr;
    }
   
   public void setQuestion(String text) {
       this.text = text;
   }
   public String getQuestion() {
       return this.text;
   }
   
    public Long getPoints() {
        return points;
    }

    public void setPoints(Long points) {
        this.points = points;
    }
}
