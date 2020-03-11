/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.trainee.kurs;

import java.io.Serializable;
import java.util.Date;
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
import javax.validation.constraints.NotNull;
import org.game.trainee.trainee.Trainee;

/**
 *
 * @author Jan
 */

@Entity
@Table(name = "kursbesuch", schema = "game")
public class KursBesuch implements Serializable {
    @Id
    @Column(name="KURSBESUCHID")
    private String KursBesuchID;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="MitID")
    @NotNull
    private Trainee trainee;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="KursID")
    @NotNull
    private Kurs kurs;
    @NotNull
    @Column(name="DATUM")
    private Date datum;
    
    public KursBesuch(){
    
    }
    
    public KursBesuch(String KursBesuchID) {
        this.KursBesuchID=KursBesuchID;
    }

    public String getKursBesuchID() {
        return KursBesuchID;
    }

    public void setKursBesuchID(String KursBesuchID) {
        this.KursBesuchID = KursBesuchID;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Trainee getTrainee() {
        return trainee;
    }

    public void setTrainee(Trainee trainee) {
        this.trainee = trainee;
    }

    public Kurs getKurs() {
        return kurs;
    }

    public void setKurs(Kurs kurs) {
        this.kurs = kurs;
    }
    
    
}