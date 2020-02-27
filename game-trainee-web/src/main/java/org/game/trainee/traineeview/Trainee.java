/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.trainee.traineeview;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
@Table(name = "trainee", schema = "game")
@NamedQuery(name = "QUERY_FINDBY_PROGRESS", query = "SELECT trainee.progress FROM Trainee trainee")
public class Trainee implements Serializable {
    public static final String QUERY_FINDBY_PROGRESS = "Trainee.findProgress";
    @Id
    @Column(name="mitid")
    private String MitID;
    @NotNull @Column(name="vorname")
    private String vorname;
    @NotNull @Column(name="nachname")
    private String nachname;
    @NotNull @Column(unique = true, name="nickname")
    private String nickname;
    @Column(name="abteilung")
    private String abteilung;
    @Column(name="progress")
    private int progress;
    @Column(name="embleme")
    public List<String> embleme;
    
    public Trainee() {}
    
 /*   public Trainee(String name, String nickname, String abteilung, double progress) {
        this.name=name;
        this.nickname=nickname;
        this.abteilung=abteilung;
        this.progress=progress;
        embleme = new ArrayList<>();
    }
    
    public Trainee(String name, String nickname, String abteilung) {
        this.name=name;
        this.nickname=nickname;
        this.abteilung=abteilung;
    }
  */  
    public Trainee(String MitID) {
        this.MitID=MitID;
    }

    public String getMitID() {
        return MitID;
    }

    public void setMitID(String MitID) {
        this.MitID = MitID;
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

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public List<String> getEmbleme() {
        return embleme;
    }

    public void setEmbleme(List<String> embleme) {
        this.embleme = embleme;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }    
}
