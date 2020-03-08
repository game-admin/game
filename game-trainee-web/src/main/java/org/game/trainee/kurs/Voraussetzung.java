/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.trainee.kurs;

import java.io.Serializable;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.game.trainee.testquiz.Quiz;

/**
 *
 * @author Jan
 */

@Entity
@Table(name="voraussetzung", schema = "game")
public class Voraussetzung implements Serializable {
    @Id @Column(name="VORAUSSETZID")
    private String VoraussetzID;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="KursID")
    private Kurs kurs;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="qid")
    private Quiz quiz;
    
    public Voraussetzung() {
        
    }
    
    public Voraussetzung(String VoraussetzID) {
        this.VoraussetzID=VoraussetzID;
    }

    public String getVoraussetzID() {
        return VoraussetzID;
    }

    public void setVoraussetzID(String VoraussetzID) {
        this.VoraussetzID = VoraussetzID;
    }

    public Kurs getKurs() {
        return kurs;
    }

    public void setKurs(Kurs kurs) {
        this.kurs = kurs;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }
    
}
