
package tpd;


public class student {
   String id;
   String Name;
   
   String Blood_group;
   String Sclass;
   String District;
   String Upazila;
   String gender;
   String Date_Of_Birth;
   String PhoneNumber;
 //  String SchoolName;

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

    public String getBlood_group() {
        return Blood_group;
    }

    public void setBlood_group(String Blood_group) {
        this.Blood_group = Blood_group;
    }

    public String getSclass() {
        return Sclass;
    }

    public void setSclass(String Sclass) {
        this.Sclass = Sclass;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDate_Of_Birth() {
        return Date_Of_Birth;
    }

    public void setDate_Of_Birth(String Date_Of_Birth) {
        this.Date_Of_Birth = Date_Of_Birth;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public student(String id, String Name, String Blood_group, String Sclass, String District, String Upazila, String gender, String Date_Of_Birth, String PhoneNumber) {
        this.id = id;
        this.Name = Name;
        this.Blood_group = Blood_group;
        this.Sclass = Sclass;
        this.District = District;
        this.Upazila = Upazila;
        this.gender = gender;
        this.Date_Of_Birth = Date_Of_Birth;
        this.PhoneNumber = PhoneNumber;
    }

  
 
    public String toString() {
        return "Donor{" + "Name=" + Name + ", Blood_Group=" + Blood_group + ", PhoneNumber=" + PhoneNumber + ", District=" + District + ", Upazila=" + Upazila + ", Date_Of_Birth=" + Date_Of_Birth + ", ID=" + id  + '}';
    }
    

   
}
