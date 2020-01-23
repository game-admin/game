/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.trainee.traineeview;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Eric/Jan
 */

@Entity
public class Trainee implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    public int MitID;
    @NotNull
    public String name;
    @NotNull @Column(unique = true)
    public String nickname;
    public String abteilung;
    public double progress;
    
    public Trainee() {}
    
    public Trainee(String name, String nickname, String abteilung, double progress) {
        this.name=name;
        this.nickname=nickname;
        this.abteilung=abteilung;
        this.progress=progress;
    }
    
    public Trainee(String name, String nickname, String abteilung) {
        this.name=name;
        this.nickname=nickname;
        this.abteilung=abteilung;
    }

    public int getMitID() {
        return MitID;
    }

    public void setMitID(int MitID) {
        this.MitID = MitID;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAbteilung() {
        return abteilung;
    }

    public void setAbteilung(String abteilung) {
        this.abteilung = abteilung;
    }

    public double getProgress() {
        return progress;
    }

    public void setProgress(double progress) {
        this.progress = progress;
    }
    
    
}
