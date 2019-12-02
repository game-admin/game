/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.trainee.questions;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.model.menu.*;

/**
 *
 * @author Eric
 */
@Named
@RequestScoped
public class ButtonView {
 
    private MenuModel model;
 
    @PostConstruct
    public void init() {
        model = new DefaultMenuModel();
    }
    public MenuModel getModel() {
        return model;
    }
 
    public String save() {
        addMessage("Data saved");
        return null;
    }
 
    public void update() {
        addMessage("Data updated");
    }
 
    public void delete() {
        addMessage("Data deleted");
    }
 
    public void buttonSubmit() {
        addMessage("Die Frage wurde dem Fragebogen hinzugefügt!");
    }
 
    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
