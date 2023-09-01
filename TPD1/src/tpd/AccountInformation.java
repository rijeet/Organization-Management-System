
package tpd;

public class AccountInformation {
    String Name;
    String Username;
    String Date_of_Birth;
    String District;
    String Upazila;
    String PhoneNumber;
    String DonationTimes;
    String BloodGroup;
    String Password;
    String Sequirity_ques1;
    String Sequirity_ques2;
    String Sequirity_ques3;
    String AccountType;

    public AccountInformation() {
    }

    public AccountInformation(String Name, String Username, String Date_of_Birth, String District, String Upazila, String PhoneNumber, String DonationTimes, String BloodGroup, String Password, String Sequirity_ques1, String Sequirity_ques2, String Sequirity_ques3, String AccountType) {
        this.Name = Name;
        this.Username = Username;
        this.Date_of_Birth = Date_of_Birth;
        this.District = District;
        this.Upazila = Upazila;
        this.PhoneNumber = PhoneNumber;
        this.DonationTimes = DonationTimes;
        this.BloodGroup = BloodGroup;
        this.Password = Password;
        this.Sequirity_ques1 = Sequirity_ques1;
        this.Sequirity_ques2 = Sequirity_ques2;
        this.Sequirity_ques3 = Sequirity_ques3;
        this.AccountType = AccountType;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getDate_of_Birth() {
        return Date_of_Birth;
    }

    public void setDate_of_Birth(String Date_of_Birth) {
        this.Date_of_Birth = Date_of_Birth;
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

    public String getDonationTimes() {
        return DonationTimes;
    }

    public void setDonationTimes(String DonationTimes) {
        this.DonationTimes = DonationTimes;
    }

    public String getBloodGroup() {
        return BloodGroup;
    }

    public void setBloodGroup(String BloodGroup) {
        this.BloodGroup = BloodGroup;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getSequirity_ques1() {
        return Sequirity_ques1;
    }

    public void setSequirity_ques1(String Sequirity_ques1) {
        this.Sequirity_ques1 = Sequirity_ques1;
    }

    public String getSequirity_ques2() {
        return Sequirity_ques2;
    }

    public void setSequirity_ques2(String Sequirity_ques2) {
        this.Sequirity_ques2 = Sequirity_ques2;
    }

    public String getSequirity_ques3() {
        return Sequirity_ques3;
    }

    public void setSequirity_ques3(String Sequirity_ques3) {
        this.Sequirity_ques3 = Sequirity_ques3;
    }

    public String getAccountType() {
        return AccountType;
    }

    public void setAccountType(String AccountType) {
        this.AccountType = AccountType;
    }
    
}
