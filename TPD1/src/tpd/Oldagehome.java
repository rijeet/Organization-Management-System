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
public class Oldagehome {
   String id;
   String Name;
   String age;
   String Gender;
   String District;
   String Upazila;
   String PhoneNumber;
   String Blood_group;

    public Oldagehome(String id, String Name, String age, String Gender, String District, String Upazila, String PhoneNumber, String Blood_group) {
        this.id = id;
        this.Name = Name;
        this.age = age;
        this.Gender = Gender;
        this.District = District;
        this.Upazila = Upazila;
        this.PhoneNumber = PhoneNumber;
        this.Blood_group = Blood_group;
    }

    public Oldagehome() {
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
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

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public String getBlood_group() {
        return Blood_group;
    }

    public void setBlood_group(String Blood_group) {
        this.Blood_group = Blood_group;
    }
    //Oldagehome(String id, String Name, String age, String Gender, String District, String Upazila, String PhoneNumber, String Blood_group)
  public String toString() {
        return "Oldagehome{" + "Name=" + Name + ", Blood_Group=" + Blood_group + ", ID=" + id + ", District=" + District + ", Upazila=" + Upazila + ", age=" + age + ", PhoneNumber=" + PhoneNumber + ", Gender=" + Gender  + '}';
    }
  
   
}
