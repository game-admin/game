/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.trainee.employee;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 *
 * @author Eric
 */
@Named
@ApplicationScoped
@Deprecated
public class EmployeeSpeicher {
   private final String[] namen;
   private final String[] nicknamen;
   private final String[] abteilungen;
   private final int[] fortschritte;
   
   public EmployeeSpeicher() {
       namen = new String[5];
       namen[0] = "Eric Haneder";
       namen[1] = "Jan Binder";
       namen[2] = "Alex Saliger";
       namen[3] = "Alexander Wurst";
       namen[4] = "Bernd Brot";
       
       nicknamen = new String[5];
       nicknamen[0] = "ericbensi";
       nicknamen[1] = "Syreax";
       nicknamen[2] = "SaAlexX";
       nicknamen[3] = "Wursti";
       nicknamen[4] = "brotmann";
       
       abteilungen = new String[5];
       abteilungen[0] = "Development";
       abteilungen[1] = "Development";
       abteilungen[2] = "Development";
       abteilungen[3] = "Development";
       abteilungen[4] = "Development";
       
       fortschritte = new int[5];
       fortschritte[0] = 100;
       fortschritte[1] = 50;
       fortschritte[2] = 200;
       fortschritte[3] = 100;
       fortschritte[4] = 50;
   }

    public String[] getNamen() {
        return namen;
    }

    public String[] getNicknamen() {
        return nicknamen;
    }

    public String[] getAbteilungen() {
        return abteilungen;
    }

    public int[] getFortschritte() {
        return fortschritte;
    }
   
   
   
}
