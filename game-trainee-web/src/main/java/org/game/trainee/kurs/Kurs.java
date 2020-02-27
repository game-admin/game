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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Jan
 */
@Entity
@Table(name = "kurs", schema = "game")
public class Kurs implements Serializable {
    @Id
    @Column(name="KURSID")
    private String KursID;
    @NotNull
    @Column(name="TITEL")
    private String titel;
    @NotNull
    @Column(name="LINK")
    private URL link;
    @Column(name="BESCHREIBUNG")
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

    public URL getLink() {
        return link;
    }

    public void setLink(URL link) {
        this.link = link;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }
    
    
}
