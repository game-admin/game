/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.trainee.questions;

/**
 *
 * @author Eric
 */

public class Question {
   private String text;
   private String rightAnswer;
   private String wrongAnswer;
   
   public Question() {}
   
   public Question(String text, String rightAnswer, String wrongAnswer) {
       this.text=text;
       this.rightAnswer = rightAnswer;
       this.wrongAnswer = wrongAnswer;      
   }
   
   public void setQuestion(String text) {
       this.text = text;
   }
   public String getQuestion() {
       return this.text;
   }
   
   public void setRightAnswer(String rightAnswer) {
       this.rightAnswer = rightAnswer;
   }
   public String getRightAnswer() {
       return this.rightAnswer;
   }
   
   public void setWrongAnswer(String wrongAnswer) {
       this.wrongAnswer = wrongAnswer;
   }
   public String getWrongAnswer() {
       return this.wrongAnswer;
   }
}
