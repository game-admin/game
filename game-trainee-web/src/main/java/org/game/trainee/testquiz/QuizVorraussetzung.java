/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.trainee.testquiz;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.game.trainee.kurs.Vorraussetzung;

/**
 *
 * @author Jan
 */
@Entity
public class QuizVorraussetzung implements Serializable{
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int QuizVorraussetzID;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="QID")
    private Quiz quiz;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="VorraussetzID")
    private Vorraussetzung vorraussetzung;

    public int getQuizVorraussetzID() {
        return QuizVorraussetzID;
    }

    public void setQuizVorraussetzID(int QuizVorraussetzID) {
        this.QuizVorraussetzID = QuizVorraussetzID;
    }
    
    
}
