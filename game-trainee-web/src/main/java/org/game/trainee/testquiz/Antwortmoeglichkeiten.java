/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.trainee.testquiz;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Jan
 */

@Entity
@Table(name = "antwortmoeglichkeiten", schema = "game")
@NamedQuery(name = Antwortmoeglichkeiten.QUERY_FINDANTWORTEN_BYFIDANDQID, query = "SELECT antwort FROM Antwortmoeglichkeiten antwort WHERE antwort.frage.FID = :FID AND antwort.frage.quiz.QID = :QID")
@NamedQuery(name = Antwortmoeglichkeiten.QUERY_FINDANTWORTEN_BYFID, query = "SELECT antwort FROM Antwortmoeglichkeiten antwort WHERE antwort.frage.FID = :FID")
public class Antwortmoeglichkeiten implements Serializable {
    public static final String QUERY_FINDANTWORTEN_BYFID="Antwortmoeglichkeiten.findAntwortenByFID";
    public static final String QUERY_FINDANTWORTEN_BYFIDANDQID="Antwortmoeglichkeiten.findAntwortenByFIDAndQID";
    @Id
    @Column(name="ANTWID")
    private String AntwID;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="FID")
    private Frage frage;
    @NotNull
    @Column(name="ANTWORT")
    private String antwort;
    @Column(name="RICHTIGEANTWORT")
    private boolean richtigeAntwort;

    public Antwortmoeglichkeiten() {
        
    }
    
    public Antwortmoeglichkeiten(String AntwID) {
        this.AntwID = AntwID;
    }
    
    public String getAntwID() {
        return AntwID;
    }

    public void setAntwID(String AntwID) {
        this.AntwID = AntwID;
    }

    public String getAntwort() {
        return antwort;
    }

    public void setAntwort(String Antwort) {
        this.antwort = Antwort;
    }

    public boolean isRichtigeAntwort() {
        return richtigeAntwort;
    }

    public void setRichtigeAntwort(boolean richtigeAntwort) {
        this.richtigeAntwort = richtigeAntwort;
    }

    public Frage getFrage() {
        return frage;
    }

    public void setFrage(Frage frage) {
        this.frage = frage;
    }
    
    
}
