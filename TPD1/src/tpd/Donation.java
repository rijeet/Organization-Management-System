/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpd;

/**
 *
 * @author Mukaffi
 */
public class Donation {
   String  Username;
    String Bkashno;
    String ammount;
    String TransectionID;
    String month;

    public Donation() {
    }

    public Donation(String Username, String Bkashno, String ammount, String TransectionID, String month) {
        this.Username = Username;
        this.Bkashno = Bkashno;
        this.ammount = ammount;
        this.TransectionID = TransectionID;
        this.month = month;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getBkashno() {
        return Bkashno;
    }

    public void setBkashno(String Bkashno) {
        this.Bkashno = Bkashno;
    }

    public String getAmmount() {
        return ammount;
    }

    public void setAmmount(String ammount) {
        this.ammount = ammount;
    }

    public String getTransectionID() {
        return TransectionID;
    }

    public void setTransectionID(String TransectionID) {
        this.TransectionID = TransectionID;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

   
}
