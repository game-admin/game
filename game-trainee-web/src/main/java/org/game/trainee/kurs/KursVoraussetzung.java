/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.trainee.kurs;

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
import javax.persistence.Table;

/**
 *
 * @author Jan
 */
@Entity
@Table(name = "kursvoraussetzung", schema = "game")
public class KursVoraussetzung implements Serializable {
    @Id
    @Column(name="KURSVORAUSSETZID")
    private String KursVoraussetzID = UUID.randomUUID().toString();
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="KursID")
    private Kurs kurs;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="VoraussetzID")
    private Voraussetzung voraussetzung;

    public String getKursVoraussetzID() {
        return KursVoraussetzID;
    }

    public void setKursVoraussetzID(String KursVoraussetzID) {
        this.KursVoraussetzID = KursVoraussetzID;
    }

    public Kurs getKurs() {
        return kurs;
    }

    public void setKurs(Kurs kurs) {
        this.kurs = kurs;
    }

    public Voraussetzung getVoraussetzung() {
        return voraussetzung;
    }

    public void setVoraussetzung(Voraussetzung voraussetzung) {
        this.voraussetzung = voraussetzung;
    }
    
    
}
