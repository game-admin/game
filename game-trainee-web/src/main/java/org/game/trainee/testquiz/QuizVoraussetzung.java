/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.trainee.testquiz;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.game.trainee.kurs.Voraussetzung;

/**
 *
 * @author Jan
 */
@Entity
@Table(name = "quizvoraussetzung", schema = "game")
public class QuizVoraussetzung implements Serializable{
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="QUIZVORAUSSETZID")
    private int QuizVoraussetzID;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="QID")
    private Quiz quiz;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="VoraussetzID")
    private Voraussetzung voraussetzung;

    public int getQuizVorraussetzID() {
        return QuizVoraussetzID;
    }

    public void setQuizVorraussetzID(int QuizVorraussetzID) {
        this.QuizVoraussetzID = QuizVorraussetzID;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public Voraussetzung getVoraussetzung() {
        return voraussetzung;
    }

    public void setVorraussetzung(Voraussetzung voraussetzung) {
        this.voraussetzung = voraussetzung;
    }
    
    
}
