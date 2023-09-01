
package tpd;


public class RequestBlood {
   
    String patientName;
    String Number;
    String BloodGroup;
    String District;
    String Upazila;
    String othersInformation;

    public RequestBlood() {
    }

    public RequestBlood(String patientName, String Number, String BloodGroup, String District, String Upazila, String othersInformation) {
        this.patientName = patientName;
        this.Number = Number;
        this.BloodGroup = BloodGroup;
        this.District = District;
        this.Upazila = Upazila;
        this.othersInformation = othersInformation;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String Number) {
        this.Number = Number;
    }

    public String getBloodGroup() {
        return BloodGroup;
    }

    public void setBloodGroup(String BloodGroup) {
        this.BloodGroup = BloodGroup;
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

    public String getOthersInformation() {
        return othersInformation;
    }

    public void setOthersInformation(String othersInformation) {
        this.othersInformation = othersInformation;
    }

    
}
