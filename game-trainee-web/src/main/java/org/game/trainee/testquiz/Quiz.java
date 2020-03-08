/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.trainee.testquiz;

import java.io.Serializable;
import java.sql.Blob;
import java.util.List;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.game.trainee.kurs.Voraussetzung;

/**
 *
 * @author Jan
 */
@NamedQuery(name = Quiz.QUERY_FINDBY_BESCHREIBUNG, query = "SELECT quiz FROM Quiz quiz WHERE quiz.beschreibung like :beschreibung")
@NamedQuery(name = Quiz.QUERY_FINDALL, query = "SELECT quiz FROM Quiz quiz")
@Entity
@Table(name = "quiz", schema = "game")
public class Quiz implements Serializable {
    public static final String QUERY_FINDBY_BESCHREIBUNG="Quiz.findByBeschreibung";
    public static final String QUERY_FINDALL="Quiz.findAll";
    @Id @Column(name = "qid")
    private String QID;
    @NotNull @Column(name = "titel")
    private String titel;
    @Column(name = "beschreibung")
    private String beschreibung;
    @NotNull @Column(name = "reward")
    private String reward;
    @Column(name="multiplechoice")
    private Boolean multiplechoice;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "quiz")
    private List<Frage> fragen;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "quiz")
    private List<Quizbeantwortung> quizbeantwortung;
    @OneToOne(fetch = FetchType.EAGER, mappedBy = "quiz")
    private Voraussetzung voraussetzung;
    
    public Quiz () {
        
    }

    public Quiz(String QID) {
        this.QID = QID;
    }
    
    public String getQID() {
        return QID;
    }

    public void setQID(String QID) {
        this.QID = QID;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String Titel) {
        this.titel = Titel;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String Beschreibung) {
        this.beschreibung = Beschreibung;
    }

    public String getReward() {
        return reward;
    }

    public void setReward(String reward) {
        this.reward = reward;
    }

    public List<Frage> getFragen() {
        return fragen;
    }

    public void setFragen(List<Frage> fragen) {
        this.fragen = fragen;
    }

    public Boolean getMultiplechoice() {
        return multiplechoice;
    }

    public void setMultiplechoice(Boolean multiplechoice) {
        this.multiplechoice = multiplechoice;
    }

    public List<Quizbeantwortung> getQuizbeantwortung() {
        return quizbeantwortung;
    }

    public void setQuizbeantwortung(List<Quizbeantwortung> quizbeantwortung) {
        this.quizbeantwortung = quizbeantwortung;
    }

    public Voraussetzung getVoraussetzung() {
        return voraussetzung;
    }

    public void setVoraussetzung(Voraussetzung voraussetzung) {
        this.voraussetzung = voraussetzung;
    }

}
