/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.trainee.kurs;

import java.io.Serializable;
import java.net.URL;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Jan
 */
@Entity
@Table(name = "kurs", schema = "game")
@NamedQuery(name = Kurs.QUERY_FINDALLKURSE, query = "SELECT kurs FROM Kurs kurs")
public class Kurs implements Serializable {
    public static final String QUERY_FINDALLKURSE = "Kurs.findAll";
    @Id
    @Column(name="kursid")
    private String KursID;
    @NotNull
    @Column(name="titel")
    private String titel;
    @NotNull
    @Column(name="link")
    private String link;
    @Column(name="beschreibung")
    private String beschreibung;
    
    public Kurs() {
        
    }
    
    public Kurs(String KursID) {
        this.KursID=KursID;
    }

    public String getKursID() {
        return KursID;
    }

    public void setKursID(String KursID) {
        this.KursID = KursID;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }
    
    
}
