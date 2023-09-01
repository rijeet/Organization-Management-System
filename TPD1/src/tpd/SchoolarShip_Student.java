
package tpd;


public class SchoolarShip_Student {
   String Name;
   String ScholarShip_Type;
   String StudentClass;
   String GPA;
   String email;
   String PhoneNumber;

    public SchoolarShip_Student(String Name, String ScholarShip_Type, String StudentClass, String GPA, String email, String PhoneNumber) {
        this.Name = Name;
        this.ScholarShip_Type = ScholarShip_Type;
        this.StudentClass = StudentClass;
        this.GPA = GPA;
        this.email = email;
        this.PhoneNumber = PhoneNumber;
    }

    public SchoolarShip_Student() {
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getScholarShip_Type() {
        return ScholarShip_Type;
    }

    public void setScholarShip_Type(String ScholarShip_Type) {
        this.ScholarShip_Type = ScholarShip_Type;
    }

    public String getStudentClass() {
        return StudentClass;
    }

    public void setStudentClass(String StudentClass) {
        this.StudentClass = StudentClass;
    }

    public String getGPA() {
        return GPA;
    }

    public void setGPA(String GPA) {
        this.GPA = GPA;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

  
   public String toString() {
        return "SchoolarShip_Student{" + "Name=" + Name + ", ScholarShip_Type=" + ScholarShip_Type + ", StudentClass=" + StudentClass + ", GPA=" + GPA + ", email=" + email + ", PhoneNumber=" + PhoneNumber  + '}';
    }
   
   
}
