/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpd;


public class Orphanage {
   String id;
   String Name;
  String Date_of_Birth;
   String Blood_group;
   String Gender;
   String District;
   String Upazila;

    public Orphanage(String id, String Name, String Date_of_Birth, String Blood_group, String Gender, String District, String Upazila) {
        this.id = id;
        this.Name = Name;
        this.Date_of_Birth = Date_of_Birth;
        this.Blood_group = Blood_group;
        this.Gender = Gender;
        this.District = District;
        this.Upazila = Upazila;
    }

    public Orphanage() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getDate_of_Birth() {
        return Date_of_Birth;
    }

    public void setDate_of_Birth(String Date_of_Birth) {
        this.Date_of_Birth = Date_of_Birth;
    }

    public String getBlood_group() {
        return Blood_group;
    }

    public void setBlood_group(String Blood_group) {
        this.Blood_group = Blood_group;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
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
 //Orphanage(String id, String Name, String Date_of_Birth, String Blood_group, String Gender, String District, String Upazila)
    public String toString() {
        return "Orphanage{" + "Name=" + Name + ", Blood_Group=" + Blood_group + ", ID=" + id + ", District=" + District + ", Upazila=" + Upazila + ", Date_of_Birth=" + Date_of_Birth + ", Gender=" + Gender  + '}';
    }
}
