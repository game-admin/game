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
public class TraineeController implements Serializable {
    private List<Trainee> trainees;
    private Trainee selectedTrainee;
    
    @Inject
    private TraineeEJB traineebean;
    

    public List<Trainee> getTrainees() {
        if(trainees == null)
            trainees = traineebean.findAll();
        return trainees;
    }

    public void setSelectedTrainee(Trainee selectedTrainee) {
        this.selectedTrainee = selectedTrainee;
    }

    public Trainee getSelectedTrainee() {
        return selectedTrainee;
    }
    
    
    
}
