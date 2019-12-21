/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.trainee.testquiz;

import com.sun.faces.component.visit.FullVisitContext;
import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIViewRoot;
import javax.faces.component.visit.VisitCallback;
import javax.faces.component.visit.VisitContext;
import javax.faces.component.visit.VisitResult;
import javax.faces.context.FacesContext;




/**
 *
 * @author Eric
 */
@Named
@ViewScoped
public class TestQuizAnzeigen implements Serializable {
     
    private List<TestQuiz> quiz;
     
    private TestQuiz selectedQuestion;
     
    @Inject
    private TestQuizSpeicher speicher;
     
    @PostConstruct
    public void init() {
        quiz = speicher.createQuiz(4);
    }
 
    public List<TestQuiz> getQuiz() {
        return quiz;
    }
 
    public void setSpeicher(TestQuizSpeicher speicher) {
        this.speicher = speicher;
    }
 
    public TestQuiz getSelectedQuestion() {
        return selectedQuestion;
    }
 
    public void setSelectedQuestion(TestQuiz selectedQuestion) {
        this.selectedQuestion = selectedQuestion;
    }
    
    public void check(String id) {
       if(id=="button1" && selectedQuestion.getIndexrichtig()==0) {
          FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Richtig")); 
       } else if(id=="button2" && selectedQuestion.getIndexrichtig()==1) {
           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Richtig"));
       } else {
       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Falsch"));
       }
    }
    
    public UIComponent findComponent(final String id) {

        FacesContext context = FacesContext.getCurrentInstance(); 
        UIViewRoot root = context.getViewRoot();
        final UIComponent[] found = new UIComponent[1];

        root.visitTree(new FullVisitContext(context), new VisitCallback() {     
            @Override
            public VisitResult visit(VisitContext context, UIComponent component) {
                if (component != null 
                    && component.getId() != null 
                    && component.getId().equals(id)) {
                    found[0] = component;
                    return VisitResult.COMPLETE;
                }
                return VisitResult.ACCEPT;              
            }
        });

        return found[0];

    }
}