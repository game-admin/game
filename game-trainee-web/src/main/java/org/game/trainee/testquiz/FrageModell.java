package org.game.trainee.testquiz;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Eric
 */
public class FrageModell implements Serializable {
        
   public String frage;
   public List<String> antworten;
   public int indexrichtig;
   public Boolean[] buttons; // for multiple choice
   public String selectedAnswer; //for single choice radioButtons
   public String qid;
   
   public FrageModell(String frage, List<String> antworten, int indexrichtig, String qid) {
      this.frage=frage;
      this.antworten=antworten;
      this.indexrichtig=indexrichtig;
      buttons = new Boolean[4];
      this.qid = qid;
   }
   
   public FrageModell() {}
   
    public String getFrage() {
        return frage;
    }

    public void setFrage(String fragen) {
        this.frage = fragen;
    }

    public List<String> getAntworten() {
        return antworten;
    }

    public void setAntworten(List<String> antworten) {
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

    public String getQid() {
        return qid;
    }

    public void setQid(String qid) {
        this.qid = qid;
    }
    
}
