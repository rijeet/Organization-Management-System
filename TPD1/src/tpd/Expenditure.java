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
public class Expenditure {
    String Ammont;
    String Month;

    public Expenditure() {
    }

    public Expenditure(String Ammont, String Month) {
        this.Ammont = Ammont;
        this.Month = Month;
    }

    public String getAmmont() {
        return Ammont;
    }

    public void setAmmont(String Ammont) {
        this.Ammont = Ammont;
    }

    public String getMonth() {
        return Month;
    }

    public void setMonth(String Month) {
        this.Month = Month;
    }
    
}
