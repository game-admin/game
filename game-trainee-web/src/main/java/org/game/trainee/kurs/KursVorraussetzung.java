/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.trainee.kurs;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Jan
 */
@Entity
public class KursVorraussetzung implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int KursVorraussetzID;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="KursID")
    private Kurs kurs;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="VorraussetzID")
    private Vorraussetzung vorraussetzung;

    public int getKursVorraussetzID() {
        return KursVorraussetzID;
    }

    public void setKursVorraussetzID(int KursVorraussetzID) {
        this.KursVorraussetzID = KursVorraussetzID;
    }
    
    
}
