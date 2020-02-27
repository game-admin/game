  /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.trainee.testquiz;

import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author Jan
 */
public class FrageModell {
    
    @Inject
    FrageEJB fragebean;
    
    public Boolean[] buttons;
    public List<String> selectedAnswer;
    
    
    public Frage getFrage(String index) {
        return fragebean.find(index);
    }
    
    public List<Frage> getAllFragen() {
        return fragebean.findAll();
    }
    
    public List<Antwortmoeglichkeiten> getAntwortenZuIndex(String index) {
        return fragebean.find(index).getAntworten();
    }

    public Boolean[] getButtons() {
        if(buttons==null){
            buttons = new Boolean[4];
        }
        return buttons;
    }

    public void setButtons(Boolean[] buttons) {
        this.buttons = buttons;
    }

    public List<String> getSelectedAnswer() {
        return selectedAnswer;
    }

    public void setSelectedAnswer(List<String> selectedAnswer) {
        this.selectedAnswer = selectedAnswer;
    }
    
    
    
}
