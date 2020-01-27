package org.game.trainee.testquiz;

import java.io.Serializable;

/**
 *
 * @author Eric
 */
public class TestQuiz implements Serializable {
        
   public String frage;
   public String[] antworten;
   public int indexrichtig;
   public Boolean[] buttons; // for multiple choice
   public String selectedAnswer; //for single choice radioButtons
   
   public TestQuiz(String frage, String[] antworten, int indexrichtig) {
      this.frage=frage;
      this.antworten=antworten;
      this.indexrichtig=indexrichtig;
      buttons = new Boolean[4];
   }
   
    public String getFrage() {
        return frage;
    }

    public void setFrage(String fragen) {
        this.frage = fragen;
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

    public Boolean[] getButtons() {
        return buttons;
    }

    public void setButtons(Boolean[] buttons) {
        this.buttons = buttons;
    }

    public String getSelectedAnswer() {
        return selectedAnswer;
    }

    public void setSelectedAnswer(String selectedAnswer) {
        this.selectedAnswer = selectedAnswer;
    }
}
