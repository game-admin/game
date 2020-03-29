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
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.game.trainee.trainee.Trainee;

/**
 *
 * @author Jan
 */

@Entity
@Table(name = "kursbesuch", schema = "game")
@NamedQuery(name = KursBesuch.QUERY_FINDBY_KURSIDANDMITID, query="SELECT kursbe FROM KursBesuch kursbe WHERE kursbe.kurs.KursID = :KursID AND kursbe.trainee.MitID = :MitID")
public class KursBesuch implements Serializable {
    public static final String QUERY_FINDBY_KURSIDANDMITID="KursBesuch.findByKursIDAndMITID";
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
    @Column(name="istbesucht")
    private boolean istbesucht;
    
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

    public boolean isIstbesucht() {
        return istbesucht;
    }

    public void setIstbesucht(boolean istbesucht) {
        this.istbesucht = istbesucht;
    }
    
}
