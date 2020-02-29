/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.trainee.testquiz;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Jan
 */
@Entity
@Table(name = "frage", schema = "game")
@NamedQuery(name = Frage.QUERY_FINDALLFRAGEN, query = "SELECT frage FROM Frage frage")
//@NamedQuery(name = "QUERY_FINDALLANTWORTEN", query = "SELECT frage, antwort FROM Antwortmoeglichkeiten antwort INNER JOIN antwort.frage frage");
public class Frage implements Serializable {
    //public static final NAMED_QUERY = "SELECT antwort FROM Frage frage";
    public static final String QUERY_FINDALLFRAGEN = "Frage.findAll";
    //public static final String QUERY_FINDALLANTWORTEN = "Frage.findAllAntworten";
    @Id
    private String FID;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="QID")
    private Quiz quiz;
    @NotNull
    @Column(name="FRAGE")
    private String Frage;
    @NotNull
    @Column(name="PUNKTEZAHL")
    private int punktezahl;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name="ANTWID")
    private List<Antwortmoeglichkeiten> antworten;
    
    public Frage() {
        
    }
    
    public Frage(String FID) {
        this.FID = FID;
    }

    public String getFID() {
        return FID;
    }

    public void setId(String FID) {
        this.FID = FID;
    }

    public String getFrage() {
        return Frage;
    }

    public void setFrage(String Frage) {
        this.Frage = Frage;
    }

    public int getPunktezahl() {
        return punktezahl;
    }

    public void setPunktezahl(int Punktezahl) {
        this.punktezahl = Punktezahl;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public List<Antwortmoeglichkeiten> getAntworten() {
        System.out.println(antworten.size());
        return antworten;
    }

    public void setAntworten(List<Antwortmoeglichkeiten> antworten) {
        this.antworten = antworten;
    }
    
    
}
