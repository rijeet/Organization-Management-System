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
public class School {
    String Name;
    String District;
    String Upazila;
    String Vacancy;
    String Capacity;  

    public School(String Name, String District, String Upazila, String Vacancy, String Capacity) {
        this.Name = Name;
        this.District = District;
        this.Upazila = Upazila;
        this.Vacancy = Vacancy;
        this.Capacity = Capacity;
    }

    public School() {
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
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

    public String getVacancy() {
        return Vacancy;
    }

    public void setVacancy(String Vacancy) {
        this.Vacancy = Vacancy;
    }

    public String getCapacity() {
        return Capacity;
    }

    public void setCapacity(String Capacity) {
        this.Capacity = Capacity;
    }
public String toString() {
        return "School{" + "Name=" + Name + ", District=" + District + ", Upazila=" + Upazila + ", Capacity=" + Capacity + ", Vacancy=" + Vacancy  + '}';
    }
}
