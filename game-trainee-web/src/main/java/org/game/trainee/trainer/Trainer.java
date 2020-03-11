/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.trainee.trainer;

import java.io.Serializable;

/**
 *
 * @author Eric
 */
public class Trainer implements Serializable {
     
    public String name;
    public String branch;
    public String role;
    
    public Trainer() {}
     
    public Trainer(String name) {
        this.name = name;
        
    }
     
    public Trainer(String name, String branch, String role) {
        this.name = name;
        this.branch = branch;
        this.role = role;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
 
    public String getBranch() {
        return branch;
    }
    public void setBranch(String branch) {
        this.branch = branch;
    }
 
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
  
}