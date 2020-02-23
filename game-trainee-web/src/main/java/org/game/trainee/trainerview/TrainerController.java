package org.game.trainee.trainerview;

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
public class TrainerController implements Serializable {
     
    private List<Trainer> trainers;
     
    private Trainer selectedTrainer;
     
    @Inject
    private TrainerService service;
     
    @PostConstruct
    public void init() {
        trainers = service.createTrainers(6);
    }
 
    public List<Trainer> getTrainers() {
        return trainers;
    }
    
    public void setService(TrainerService service) {
        this.service = service;
    }
    
    public Trainer getSelectedTrainer() {
        return selectedTrainer;
    }
    
    public void setSelectedTrainer(Trainer selectedTrainer) {
        this.selectedTrainer = selectedTrainer;
    }
}
