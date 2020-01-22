/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.trainee.employee;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Eric/Jan
 */

@Deprecated
public class Employee implements Serializable {
    @Id @GeneratedValue
    private int mitid;
    @NotNull @Column(unique=true)
    private String nickname;
    @NotNull
    private String name;
    private String abteilung;
    private int fortschritt;
    
    public Employee(){
        
    }
/*    
    public Employee(String name, String nickname, String abteilung, int fortschritt) {
        this.name = name;
        this.nickname = nickname;
        this.abteilung = abteilung;
        this.fortschritt = fortschritt;
    }
    public Employee(String name, String nickname, String abteilung) {
        this.name = name;
        this.nickname = nickname;
        this.abteilung = abteilung;
    }
    public Employee(String name, String nickname) {
        this.name = name;
        this.nickname = nickname;
    }
*/
    public int getMitid() {
        return mitid;
    }

    public void setMitid(int mitid) {
        this.mitid = mitid;
    }
    
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbteilung() {
        return abteilung;
    }

    public void setAbteilung(String abteilung) {
        this.abteilung = abteilung;
    }

    public int getFortschritt() {
        return fortschritt;
    }

    public void setFortschritt(int fortschritt) {
        this.fortschritt = fortschritt;
    }
    
}
