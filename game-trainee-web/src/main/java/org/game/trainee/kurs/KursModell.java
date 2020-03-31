/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.trainee.kurs;

/**
 *
 * @author Eric
 */
public class KursModell {
   public String kursid;
   public String titel;
   public String beschreibung;
   public String link;
   public Boolean isDone;
   
   public KursModell(String kursid, String titel, String beschreibung, String link) {
       this.kursid=kursid;
       this.titel=titel;
       this.beschreibung=beschreibung;
       this.link=link;
       isDone = Boolean.FALSE;
   }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Boolean getIsDone() {
        return isDone;
    }

    public void setIsDone(Boolean isDone) {
        this.isDone = isDone;
    }

    public String getKursid() {
        return kursid;
    }

    public void setKursid(String kursid) {
        this.kursid = kursid;
    }
   
}
