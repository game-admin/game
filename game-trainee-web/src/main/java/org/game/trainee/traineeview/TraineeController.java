package org.game.trainee.traineeview;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
    

    public List<Trainee> getTraineesByID(String mitid) {
        List<Trainee> list = new ArrayList<>(1);
        Trainee trainee = traineebean.find(mitid);
        list.add(trainee);
        return list;
    }
    
    public List<Trainee> getTrainees() {
        return trainees;    
    }

    public void setSelectedTrainee(Trainee selectedTrainee) {
        this.selectedTrainee = selectedTrainee;
    }

    public Trainee getSelectedTrainee() {
        return selectedTrainee;
    }
    
    
    
}
