/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.trainee.traineeview;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Eric
 */
@Named
@ViewScoped
public class TraineeView implements Serializable {
    private List<Trainee> trainees;
    private Trainee selectedTrainee;
    
    @Inject
    private TraineeGenerator generator;
    
    @PostConstruct
    public void init() {
        trainees=generator.createTrainees(4);
    }

    public List<Trainee> getTrainees() {
        return trainees;
    }

    public void setSelectedTrainee(Trainee selectedTrainee) {
        this.selectedTrainee = selectedTrainee;
    }

    public void setGenerator(TraineeGenerator generator) {
        this.generator = generator;
    }

    public Trainee getSelectedTrainee() {
        return selectedTrainee;
    }
    
    
    
}
