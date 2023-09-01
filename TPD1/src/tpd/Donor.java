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
public class Donor {
    String Name;
    String Blood_Group;
    String PhoneNumber;
    String District;
    String Upazila;
    String DonateTimes;
    String LastDonation;

    public Donor(String Name, String Blood_Group, String PhoneNumber, String District, String Upazila, String DonateTimes, String LastDonation) {
        this.Name = Name;
        this.Blood_Group = Blood_Group;
        this.PhoneNumber = PhoneNumber;
        this.District = District;
        this.Upazila = Upazila;
        this.DonateTimes = DonateTimes;
        this.LastDonation = LastDonation;
    }

    public Donor() {
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getBlood_Group() {
        return Blood_Group;
    }

    public void setBlood_Group(String Blood_Group) {
        this.Blood_Group = Blood_Group;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public String getDistrict() {
        return District;
    }

    public void setDistrict(String District) {
        this.District = District;
    }

    public String getUpazila() {
        return Upazila;
    }

    public void setUpazila(String Upazila) {
        this.Upazila = Upazila;
    }

    public String getDonateTimes() {
        return DonateTimes;
    }

    public void setDonateTimes(String DonateTimes) {
        this.DonateTimes = DonateTimes;
    }

    public String getLastDonation() {
        return LastDonation;
    }

    public void setLastDonation(String LastDonation) {
        this.LastDonation = LastDonation;
    }
    
    
    public String toString() {
        return "Donor{" + "Name=" + Name + ", Blood_Group=" + Blood_Group + ", PhoneNumber=" + PhoneNumber + ", District=" + District + ", Upazila=" + Upazila + ", DonateTimes=" + DonateTimes + ", LastDonation=" + LastDonation  + '}';
    }
}
