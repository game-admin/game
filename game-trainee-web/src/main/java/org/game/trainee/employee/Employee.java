/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.trainee.employee;

import java.io.Serializable;

/**
 *
 * @author Eric
 */
public class Employee implements Serializable {
    private String nickname;
    private String name;
    private String abteilung;
    private int fortschritt;
    
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
