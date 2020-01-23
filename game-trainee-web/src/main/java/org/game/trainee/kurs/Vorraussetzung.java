/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.trainee.kurs;

import java.io.Serializable;
import javax.persistence.CascadeType;
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
@Table(name="vorraussetzungen")
public class Vorraussetzung implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int VorraussetzID;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="KursID")
    private Kurs kurs;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="QID")
    private Quiz quiz;

    public int getVorraussetzID() {
        return VorraussetzID;
    }

    public void setVorraussetzID(int VorraussetzID) {
        this.VorraussetzID = VorraussetzID;
    }
    
}
