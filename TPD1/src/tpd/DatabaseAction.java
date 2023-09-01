package tpd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes.Name;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DatabaseAction {

    Connection getConnection() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/the people's dream", "root", "");
        return conn;
    }
//AccountImformation
    void insertAccount(AccountInformation accountInformation) throws SQLException {
    Connection conn = getConnection();
        Statement statement = (Statement) conn.createStatement();
        
   String n = "INSERT INTO accountinformation(Name, Username,DateofBirth,District, Upazila, PhoneNumber, DonationTimes, BloodGroup, Password, SecuirityQues1, SecuirityQues2, SecuirityQues3, AccountType) VALUES ('"+accountInformation.getName()+"','"+accountInformation.getUsername()+"','"+accountInformation.getDate_of_Birth()+"','"+accountInformation.getDistrict()+"','"+accountInformation.getUpazila()+"','"+accountInformation.getPhoneNumber()+"','"+accountInformation.getDonationTimes()+"','"+accountInformation.getBloodGroup()+"','"+accountInformation.getPassword()+"','"+accountInformation.getSequirity_ques1()+"','"+accountInformation.getSequirity_ques2()+"','"+accountInformation.getSequirity_ques3()+"','"+accountInformation.getAccountType()+"')";
        statement.execute(n);
    
    }
    
//user
    ObservableList<User> getAllUser() throws SQLException {
        ObservableList<User> userList = FXCollections.observableArrayList();
        Connection conn = getConnection();

        Statement statement = conn.createStatement();
        String query = "select * from logininfo";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            String username = rs.getString("username");
            String password = rs.getString("password");
            String accountType = rs.getString("accountType");
            User user = new User(username, password, accountType);
            userList.add(user);

        }
        return userList;

    }
    void insertUser(User user) throws SQLException {
    Connection conn = getConnection();
        Statement statement = (Statement) conn.createStatement();
        String n="INSERT INTO logininfo(username, password, accountType) VALUES ('"+user.getUsername()+"','"+user.getPassword()+"','"+user.getAccountType()+"')";
        statement.execute(n);
    
    }

    ObservableList<Donor> getAllDonor() throws SQLException {
        ObservableList<Donor> dnrList = FXCollections.observableArrayList();

        Connection conn = getConnection();

        Statement statement = conn.createStatement();
        String query = "select * from donor";
        ResultSet rs = statement.executeQuery(query);

        while (rs.next()) {
            String Name = rs.getString("Name");
            String Blood_Group = rs.getString("Blood");
            String PhoneNumber = rs.getString("Number");
            String District = rs.getString("District");
            String Upazila = rs.getString("Upazila");
            String DonateTime = rs.getString("Times");
            String lastDonation = rs.getString("Donation");

            Donor donor = new Donor(Name, Blood_Group, PhoneNumber, District, Upazila, DonateTime, lastDonation);
            dnrList.add(donor);

        }

        return dnrList;

    }

    void insertDonor(Donor donor) throws SQLException {

        Connection conn = getConnection();
        Statement statement = (Statement) conn.createStatement();

        String n = "INSERT INTO donor(Name, Blood, Number, District, Upazila, Times,Donation) VALUES ('" + donor.getName() + "','" + donor.getBlood_Group() + "','" + donor.getPhoneNumber() + "','" + donor.getDistrict() + "','" + donor.getUpazila() + "','" + donor.getDonateTimes() + "','" + donor.getLastDonation() + "')";
        statement.execute(n);

    }

    void deleteDonor(ObservableList<Donor> selectedDonors) throws SQLException {

        Connection conn = getConnection();
        Statement statement = conn.createStatement();
        for (Donor donor : selectedDonors) {
            String query = "DELETE FROM donor WHERE Name='" + donor.getName() + "'";
            statement.executeUpdate(query);
        }

    }
    void deletePateint(ObservableList<OnlineConsult> selectedDonors) throws SQLException {

        Connection conn = getConnection();
        Statement statement = conn.createStatement();
        for (OnlineConsult donor : selectedDonors) {
            String query = "DELETE FROM problemlist WHERE Name='" + donor.getName() + "'";
            statement.executeUpdate(query);
        }

    }

    ObservableList<Donor> searchDonor(String type, String value) throws SQLException {
        ObservableList<Donor> dnrList = FXCollections.observableArrayList();
        Connection conn = getConnection();
        Statement statement = (Statement) conn.createStatement();
        String n = "SELECT * FROM donor  WHERE " + type + "='" + value + "'";
        ResultSet rs = statement.executeQuery(n);
        while (rs.next()) {
            String Name = rs.getString("Name");
            String Blood_Group = rs.getString("Blood");
            String PhoneNumber = rs.getString("Number");
            String District = rs.getString("District");
            String Upazila = rs.getString("Upazila");
            String DonateTime = rs.getString("Times");
            String lastDonation = rs.getString("Donation");

            Donor donor = new Donor(Name, Blood_Group, PhoneNumber, District, Upazila, DonateTime, lastDonation);
            dnrList.add(donor);

        }

        return dnrList;
    }

    void deleteOrphan(ObservableList<Orphanage> selectedOrphan) throws SQLException {
        Connection conn = getConnection();
        Statement statement = conn.createStatement();
        for (Orphanage or : selectedOrphan) {
            String query = "DELETE FROM orphanage WHERE Name='" + or.getName() + "'";
            statement.executeUpdate(query);
        }

    }

    void deleteOrphanage(ObservableList<Orphanage_houses> selectedOrphanage) throws SQLException {
        Connection conn = getConnection();
        Statement statement = conn.createStatement();
        for (Orphanage_houses or : selectedOrphanage) {
            String query = "DELETE FROM orphanageinfo WHERE Name='" + or.getName() + "'";
            statement.executeUpdate(query);
        }

    }

    void deleteperson(ObservableList<Oldagehome> selectedperson) throws SQLException {
        Connection conn = getConnection();
        Statement statement = conn.createStatement();
        for (Oldagehome or : selectedperson) {
            String query = "DELETE FROM oldagehomeinfo WHERE Name='" + or.getName() + "'";
            statement.executeUpdate(query);
        }

    }

    void deletehome(ObservableList<OldAgeHome_Houses> selectedhome) throws SQLException {
        Connection conn = getConnection();
        Statement statement = conn.createStatement();
        for (OldAgeHome_Houses or : selectedhome) {
            String query = "DELETE FROM oldagehome WHERE Name='" + or.getName() + "'";
            statement.executeUpdate(query);
        }

    }

    void deleteSchool(ObservableList<School> selectedSchool) throws SQLException {

        Connection conn = getConnection();
        Statement statement = conn.createStatement();
        for (School or : selectedSchool) {
            String query = "DELETE FROM school WHERE Name='" + or.getName() + "'";
            statement.executeUpdate(query);
        }

    }
    //Orphange

    ObservableList<Orphanage> getAllOrphan() throws SQLException {
        ObservableList<Orphanage> orphanList = FXCollections.observableArrayList();
        Connection conn = getConnection();

        Statement statement = conn.createStatement();
        String query = "SELECT * FROM orphanage";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            String ID = rs.getString("ID");
            String Name = rs.getString("Name");
            String Blood_Group = rs.getString("BloodGroup");
            String Gender = rs.getString("Gender");
            String District = rs.getString("District");
            String Upazila = rs.getString("Upazila");
            String DateofBirth = rs.getString("DateofBirth");

            Orphanage orphan = new Orphanage(ID, Name, DateofBirth, Blood_Group, Gender, District, Upazila);

            orphanList.add(orphan);

        }       

        return orphanList;

    }
    //reqBlood
     ObservableList<RequestBlood>   GetAllRequest() throws SQLException{
   ObservableList<RequestBlood> reqList = FXCollections.observableArrayList();
        Connection conn = getConnection();

        Statement statement = conn.createStatement();
        String query = "SELECT * FROM bloodrequest";
        ResultSet rs = statement.executeQuery(query);
    while (rs.next()) {

            String patientName = rs.getString("Name");
            String Number = rs.getString("Number");
            String BloodGroup = rs.getString("BloodGroup");
            String Dis = rs.getString("District");
            String Upazila = rs.getString("Upazila");
            String othersInformation = rs.getString("othersInformation");

            RequestBlood rb = new RequestBlood(patientName,Number ,BloodGroup,Dis,Upazila,othersInformation);
            reqList.add(rb);

        }

       
         
         return reqList;
   
   
   }
     void inserRequest(RequestBlood rb) throws SQLException{
        Connection conn = getConnection();
        Statement statement = (Statement) conn.createStatement();
        String n = "INSERT INTO `bloodrequest`(Name, Number, BloodGroup, District, Upazila, othersInformation) VALUES ('" + rb.getPatientName() + "','" +rb.getNumber()+ "','" +rb.getBloodGroup() + "','" + rb.getDistrict() + "','" + rb.getUpazila()+ "','" + rb.getOthersInformation()+ "')";
        statement.execute(n);
 
     } 
    ObservableList<Orphanage_houses> getAllOrphanage() throws SQLException {
        ObservableList<Orphanage_houses> orphanageList = FXCollections.observableArrayList();
        Connection conn = getConnection();

        Statement statement = conn.createStatement();
        String query = "SELECT * FROM orphanageinfo";
        ResultSet rs = statement.executeQuery(query);

        while (rs.next()) {

            String Name = rs.getString("Name");
            String District = rs.getString("District");
            String Upazila = rs.getString("Upazila");
            String Capacity = rs.getString("Capacity");
            String Vaccancy = rs.getString("Vaccancy");

            Orphanage_houses orphanage = new Orphanage_houses(Name, District, Upazila, Vaccancy, Capacity);
            orphanageList.add(orphanage);

        }

        return orphanageList;

    }

    ObservableList<Orphanage_houses> SearchOrphanage(String type, String value) throws SQLException {

        ObservableList<Orphanage_houses> orphanageList = FXCollections.observableArrayList();
        Connection conn = getConnection();

        Statement statement = conn.createStatement();
        String query = "SELECT * FROM orphanageinfo WHERE " + type + "='" + value + "'";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {

            String Name = rs.getString("Name");
            String District = rs.getString("District");
            String Upazila = rs.getString("Upazila");
            String Capacity = rs.getString("Capacity");
            String Vaccancy = rs.getString("Vaccancy");

            Orphanage_houses orphanage = new Orphanage_houses(Name, District, Upazila, Vaccancy, Capacity);
            orphanageList.add(orphanage);

        }

        return orphanageList;

    }

    ObservableList<Orphanage> SearchOrphan(String type, String value) throws SQLException {
        ObservableList<Orphanage> orphanList = FXCollections.observableArrayList();
        Connection conn = getConnection();

        Statement statement = conn.createStatement();
        String query = "SELECT * FROM orphanage WHERE " + type + "='" + value + "'";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            String ID = rs.getString("ID");
            String Name = rs.getString("Name");
            String Blood_Group = rs.getString("BloodGroup");
            String Gender = rs.getString("Gender");
            String District = rs.getString("District");
            String Upazila = rs.getString("Upazila");
            String DateofBirth = rs.getString("DateofBirth");

            Orphanage orphan = new Orphanage(ID, Name, DateofBirth, Blood_Group, Gender, District, Upazila);

            orphanList.add(orphan);

        }

        return orphanList;
    }

    void inserOrphan(Orphanage orphanage) throws SQLException {

        Connection conn = getConnection();
        Statement statement = (Statement) conn.createStatement();

        String n = "INSERT INTO `orphanage`(ID, Name, BloodGroup, Gender, District, Upazila, DateofBirth) VALUES ('" + orphanage.getId() + "','" + orphanage.getName() + "','" + orphanage.getBlood_group() + "','" + orphanage.getGender() + "','" + orphanage.getDistrict() + "','" + orphanage.getUpazila() + "','" + orphanage.getDate_of_Birth() + "')";
        statement.execute(n);
    }

    void insertOrphanage(Orphanage_houses orphanage_houses) throws SQLException {

        Connection conn = getConnection();
        Statement statement = (Statement) conn.createStatement();
        String n = "INSERT INTO `orphanageinfo`(Name, District, Upazila, Capacity, Vaccancy) VALUES ('" + orphanage_houses.getName() + "','" + orphanage_houses.getDistrict() + "','" + orphanage_houses.getUpazila() + "','" + orphanage_houses.getCapacity() + "','" + orphanage_houses.getVacancy() + "')";
        statement.execute(n);

    }
//OldAgehome

    ObservableList<Oldagehome> getAllOldAgePerson() throws SQLException {
        ObservableList<Oldagehome> personList = FXCollections.observableArrayList();
        Connection conn = getConnection();

        Statement statement = conn.createStatement();
        String query = "SELECT * FROM oldagehomeinfo";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            String ID = rs.getString("ID");
            String Name = rs.getString("Name");
            String District = rs.getString("District");
            String Upazila = rs.getString("Upazila");
            String Age = rs.getString("Age");
            String BloodGroup = rs.getString("BloodGroup");
            String Gender = rs.getString("Gender");
            String Number = rs.getString("Number");
            Oldagehome oldhome = new Oldagehome(ID, Name, Age, Gender, District, Upazila, Number, BloodGroup);
            personList.add(oldhome);

        }

        return personList; 

    }
     ObservableList<Oldagehome> SearchPerson(String type, String value) throws SQLException {
      ObservableList<Oldagehome> personList = FXCollections.observableArrayList();
        Connection conn = getConnection();

        Statement statement = conn.createStatement();
        String query = "SELECT * FROM oldagehomeinfo WHERE " + type + "='" + value + "'";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            String ID = rs.getString("ID");
            String Name = rs.getString("Name");
            String District = rs.getString("District");
            String Upazila = rs.getString("Upazila");
            String Age = rs.getString("Age");
            String BloodGroup = rs.getString("BloodGroup");
            String Gender = rs.getString("Gender");
            String Number = rs.getString("Number");
            Oldagehome oldhome = new Oldagehome(ID, Name, Age, Gender, District, Upazila, Number, BloodGroup);
            personList.add(oldhome);

        }

        return personList;
     
     
     }

    ObservableList<OldAgeHome_Houses> getAllOldAgeHome() throws SQLException {
        ObservableList<OldAgeHome_Houses> homelist = FXCollections.observableArrayList();
        Connection conn = getConnection();
        Statement statement = conn.createStatement();
        String query = "SELECT * FROM oldagehome";
        ResultSet rs = statement.executeQuery(query);

        while (rs.next()) {

            String Name = rs.getString("Name");
            String District = rs.getString("District");
            String Upazila = rs.getString("Upazila");
            String Capacity = rs.getString("Capacity");
            String Vaccancy = rs.getString("Vaccancy");

            OldAgeHome_Houses olaAgeHome = new OldAgeHome_Houses(Name, District, Upazila, Vaccancy, Capacity);
            homelist.add(olaAgeHome);
        }
        return homelist;

    }

    ObservableList<OldAgeHome_Houses> searchHomes(String type, String value) throws SQLException {

        ObservableList<OldAgeHome_Houses> HomeList = FXCollections.observableArrayList();
        Connection conn = getConnection();
        Statement statement = (Statement) conn.createStatement();
        String n = "SELECT * FROM oldagehome  WHERE " + type + "='" + value + "'";
        ResultSet rs = statement.executeQuery(n);
        while (rs.next()) {

            String Name = rs.getString("Name");
            String District = rs.getString("District");
            String Upazila = rs.getString("Upazila");
            String Capacity = rs.getString("Capacity");
            String Vaccancy = rs.getString("Vaccancy");

            OldAgeHome_Houses olaAgeHome = new OldAgeHome_Houses(Name, District, Upazila, Vaccancy, Capacity);
            HomeList.add(olaAgeHome);
        }
        return HomeList;

    }

    void isertOldAgeHome(OldAgeHome_Houses oldAgeHome_Houses) throws SQLException {
        Connection conn = getConnection();
        Statement statement = (Statement) conn.createStatement();
        String n = "INSERT INTO `oldagehome`(Name, District, Upazila, Capacity, Vaccancy) VALUES ('" + oldAgeHome_Houses.getName() + "','" + oldAgeHome_Houses.getDistrict() + "','" + oldAgeHome_Houses.getUpazila() + "','" + oldAgeHome_Houses.getCapacity() + "','" + oldAgeHome_Houses.getVacancy() + "')";
        statement.execute(n);

    }

    void insertPerson(Oldagehome oldagehome) throws SQLException {
        Connection conn = getConnection();
        Statement statement = (Statement) conn.createStatement();
        String n = "INSERT INTO `oldagehomeinfo`(ID, Name, Age, BloodGroup, Gender, District, Upazila, Number) VALUES ('" + oldagehome.getId() + "','" + oldagehome.getName() + "','" + oldagehome.getAge() + "','" + oldagehome.getBlood_group() + "','" + oldagehome.getGender() + "','" + oldagehome.getDistrict() + "','" + oldagehome.getUpazila() + "','" + oldagehome.getPhoneNumber() + "')";
        statement.execute(n);
    }
// School 

    ObservableList<School> getAllSchool() throws SQLException {
        ObservableList<School> Schoollist = FXCollections.observableArrayList();
        Connection conn = getConnection();
        Statement statement = conn.createStatement();
        String query = "SELECT * FROM School";
        ResultSet rs = statement.executeQuery(query);

        while (rs.next()) {

            String Name = rs.getString("Name");
            String District = rs.getString("District");
            String Upazila = rs.getString("Upazila");
            String Capacity = rs.getString("Capacity");
            String Vaccancy = rs.getString("Vaccancy");

            School school = new School(Name, District, Upazila, Vaccancy, Capacity);
            Schoollist.add(school);
        }

        return Schoollist;

    }

    ObservableList<School> SearchSchool(String type, String value) throws SQLException {

        ObservableList<School> Schoollist = FXCollections.observableArrayList();
        Connection conn = getConnection();
        Statement statement = conn.createStatement();
        String query = "SELECT * FROM School WHERE " + type + "='" + value + "'";
        ResultSet rs = statement.executeQuery(query);

        while (rs.next()) {

            String Name = rs.getString("Name");
            String District = rs.getString("District");
            String Upazila = rs.getString("Upazila");
            String Capacity = rs.getString("Capacity");
            String Vaccancy = rs.getString("Vaccancy");

            School school = new School(Name, District, Upazila, Vaccancy, Capacity);
            Schoollist.add(school);
        }

        return Schoollist;

    }

    ObservableList<student> getAllStudent() throws SQLException {
        ObservableList<student> studentlist = FXCollections.observableArrayList();
        Connection conn = getConnection();
        Statement statement = conn.createStatement();
        String query = "SELECT * FROM studentlist";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            String ID = rs.getString("ID");
            String Name = rs.getString("Name");
            String Class = rs.getString("Class");
            String BloodGroup = rs.getString("BloodGroup");
            String District = rs.getString("District");
            String Upazila = rs.getString("Upazila");
            String Gender = rs.getString("Gender");
            String Number = rs.getString("Number");
            String DateofBirth = rs.getString("DateofBirth");

            student std = new student(ID, Name, BloodGroup, Class, District, Upazila, Gender, DateofBirth, Number);
            studentlist.add(std);

        }

        return studentlist;
    }

    ObservableList<student> SearchStudent(String type, String value) throws SQLException {
        ObservableList<student> studentlist = FXCollections.observableArrayList();
        Connection conn = getConnection();
        Statement statement = conn.createStatement();
        String query = "SELECT * FROM studentlist WHERE " + type + "='" + value + "'";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            String ID = rs.getString("ID");
            String Name = rs.getString("Name");
            String Class = rs.getString("Class");
            String BloodGroup = rs.getString("BloodGroup");
            String District = rs.getString("District");
            String Upazila = rs.getString("Upazila");
            String Gender = rs.getString("Gender");
            String Number = rs.getString("Number");
            String DateofBirth = rs.getString("DateofBirth");

            student std = new student(ID, Name, BloodGroup, Class, District, Upazila, Gender, DateofBirth, Number);
            studentlist.add(std);

        }

        return studentlist;
    }

    ObservableList<SchoolarShip_Student> getAllScholarship() throws SQLException {
        ObservableList<SchoolarShip_Student> scholarshiplist = FXCollections.observableArrayList();
        Connection conn = getConnection();
        Statement statement = conn.createStatement();
        String query = "SELECT * FROM sholarshipinfo ";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            String Name = rs.getString("Name");
            String ScholarshipType = rs.getString("ScholarshipType");
            String Class = rs.getString("Class");
            String Previous_Result = rs.getString("Previous_Result");
            String Email = rs.getString("Email");
            String Number = rs.getString("Number");
            SchoolarShip_Student std = new SchoolarShip_Student(Name, ScholarshipType, Class, Previous_Result, Email, Number);
            scholarshiplist.add(std);
        }

        return scholarshiplist;   

    }
    ObservableList<SchoolarShip_Student> getAllApplyScholarship() throws SQLException {
        ObservableList<SchoolarShip_Student> scholarshiplist = FXCollections.observableArrayList();
        Connection conn = getConnection();
        Statement statement = conn.createStatement();
        String query = "SELECT * FROM applyscholarship ";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            String Name = rs.getString("Name");
            String ScholarshipType = rs.getString("ScholarshipType");
            String Class = rs.getString("Class");
            String Previous_Result = rs.getString("Previous_Result");
            String Email = rs.getString("Email");
            String Number = rs.getString("Number");
            SchoolarShip_Student std = new SchoolarShip_Student(Name, ScholarshipType, Class, Previous_Result, Email, Number);
            scholarshiplist.add(std);
        }

        return scholarshiplist;   

    }
     ObservableList<SchoolarShip_Student> SearchScholarship(String type, String value) throws SQLException {
            ObservableList<SchoolarShip_Student> scholarshiplist = FXCollections.observableArrayList();
        Connection conn = getConnection();
        Statement statement = conn.createStatement();
        String query = "SELECT * FROM sholarshipinfo  WHERE " + type + "='" + value + "'";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            String Name = rs.getString("Name");
            String ScholarshipType = rs.getString("ScholarshipType");
            String Class = rs.getString("Class");
            String Previous_Result = rs.getString("Previous_Result");
            String Email = rs.getString("Email");
            String Number = rs.getString("Number");
            SchoolarShip_Student std = new SchoolarShip_Student(Name, ScholarshipType, Class, Previous_Result, Email, Number);
            scholarshiplist.add(std);
        }

        return scholarshiplist;
     
     }
    ObservableList<SchoolarShip_Student> SearchapplyScholarship(String type, String value) throws SQLException {
            ObservableList<SchoolarShip_Student> scholarshiplist = FXCollections.observableArrayList();
        Connection conn = getConnection();
        Statement statement = conn.createStatement();
        String query = "SELECT * FROM applyscholarship  WHERE " + type + "='" + value + "'";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            String Name = rs.getString("Name");
            String ScholarshipType = rs.getString("ScholarshipType");
            String Class = rs.getString("Class");
            String Previous_Result = rs.getString("Previous_Result");
            String Email = rs.getString("Email");
            String Number = rs.getString("Number");
            SchoolarShip_Student std = new SchoolarShip_Student(Name, ScholarshipType, Class, Previous_Result, Email, Number);
            scholarshiplist.add(std);
        }

        return scholarshiplist;
     
     }

    void insertSchool(School school) throws SQLException {
        Connection conn = getConnection();
        Statement statement = (Statement) conn.createStatement();
        String n = "INSERT INTO `school`(Name, District, Upazila, Capacity, Vaccancy) VALUES ('" + school.getName() + "','" + school.getDistrict() + "','" + school.getUpazila() + "','" + school.getCapacity() + "','" + school.getVacancy() + "')";
        statement.execute(n);

    }

    void insertScholarshipStudent(SchoolarShip_Student schoolarShip_Student) throws SQLException {
//INSERT INTO `sholarshipinfo`(Name, ScholarshipType, Class, Previous_Result(GPA), Email, Number) VALUES ('++','++','++','++','++','++')
        Connection conn = getConnection();
        Statement statement = (Statement) conn.createStatement();
        String n = "INSERT INTO `sholarshipinfo`(Name, ScholarshipType, Class, Previous_Result, Email, Number) VALUES ('" + schoolarShip_Student.getName() + "','" + schoolarShip_Student.getScholarShip_Type() + "','" + schoolarShip_Student.getStudentClass() + "','" + schoolarShip_Student.getGPA() + "','" + schoolarShip_Student.getEmail() + "','" + schoolarShip_Student.getPhoneNumber() + "')";
        statement.execute(n);

    }
    void insertApplyScholarshipStudent(SchoolarShip_Student schoolarShip_Student) throws SQLException {
//INSERT INTO `sholarshipinfo`(Name, ScholarshipType, Class, Previous_Result(GPA), Email, Number) VALUES ('++','++','++','++','++','++')
        Connection conn = getConnection();
        Statement statement = (Statement) conn.createStatement();
        String n = "INSERT INTO `applyscholarship`(Name, ScholarshipType, Class, Previous_Result, Email, Number) VALUES ('" + schoolarShip_Student.getName() + "','" + schoolarShip_Student.getScholarShip_Type() + "','" + schoolarShip_Student.getStudentClass() + "','" + schoolarShip_Student.getGPA() + "','" + schoolarShip_Student.getEmail() + "','" + schoolarShip_Student.getPhoneNumber() + "')";
        statement.execute(n);

    }

    void insertStudent(student Student) throws SQLException {
        Connection conn = getConnection();
        Statement statement = (Statement) conn.createStatement();
        //INSERT INTO `studentlist`(ID, Name, Class, BloodGroup, District, Upazila, Gender, Number, DateofBirth) VALUES ('"+ +"','"+ +"','"+ +"','"+ +"','"+ +"','"+ +"','"+ +"','"+ +"','"+ +"')
        String n = "INSERT INTO `studentlist`(ID, Name, Class, BloodGroup, District, Upazila, Gender, Number, DateofBirth) VALUES ('" + Student.getId() + "','" + Student.getName() + "','" + Student.getSclass() + "','" + Student.getBlood_group() + "','" + Student.getDistrict() + "','" + Student.getUpazila() + "','" + Student.getGender() + "','" + Student.getPhoneNumber() + "','" + Student.getDate_Of_Birth() + "')";
        statement.execute(n);

    }

    void deleteScholarship(ObservableList<SchoolarShip_Student> selectedStudent) throws SQLException {
        Connection conn = getConnection();
        Statement statement = conn.createStatement();
        for (SchoolarShip_Student std : selectedStudent) {
            String query = "DELETE FROM sholarshipinfo WHERE Name='" + std.getName() + "'";
            statement.executeUpdate(query);
        }

    }
    void deleteApplyScholarship(ObservableList<SchoolarShip_Student> selectedStudent) throws SQLException {
        Connection conn = getConnection();
        Statement statement = conn.createStatement();
        for (SchoolarShip_Student std : selectedStudent) {
            String query = "DELETE FROM applyscholarship WHERE Name='" + std.getName() + "'";
            statement.executeUpdate(query);
        }

    }

    void deleteStudent(ObservableList<student> selectedStudent) throws SQLException {
        Connection conn = getConnection();
        Statement statement = conn.createStatement();
        for (student std : selectedStudent) {
            String query = "DELETE FROM studentlist WHERE Name='" + std.getName() + "'";
            statement.executeUpdate(query);
        }

    }

     void insertOnlineConsult(OnlineConsult oc) throws SQLException {

        Connection conn = getConnection();
        Statement statement = (Statement) conn.createStatement();
        String n =   "INSERT INTO problemlist (Name,UserName,Age,Problem) VALUES ('"+oc.getName()+"','"+oc.getUsername()+"' ,'"+oc.getAge()+"','"+oc.getProblem()+"')";               
        statement.execute(n);

    }
       
           ObservableList<OnlineConsult> getAllConsultLsit() throws SQLException {
        ObservableList<OnlineConsult> consultList = FXCollections.observableArrayList();
        Connection conn = getConnection();
        Statement statement = conn.createStatement();
        String query = "SELECT * FROM problemlist";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
      
            String Name = rs.getString("Name");
            String userName=rs.getString("UserName");
            String Age =rs.getString("Age");
            String prob=rs.getString("Problem");
            
            
            OnlineConsult oc= new OnlineConsult(Name,userName,Age,prob);   
            consultList.add(oc);

        }

        return consultList;
    
    }
     
     ObservableList<OnlineConsult> SearchPatient(String type, String value) throws SQLException {
        ObservableList<OnlineConsult> patientList = FXCollections.observableArrayList();
        Connection conn = getConnection();
        Statement statement = conn.createStatement();
        String query = "SELECT * FROM problemlist WHERE " + type + "='" + value + "'";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
             String Name = rs.getString("Name");
            String userName=rs.getString("UserName");
            String Age =rs.getString("Age");
            String prob=rs.getString("Problem");
              OnlineConsult oc= new OnlineConsult(Name,userName,Age,prob);
            patientList.add(oc);
        }

        return patientList;
    }
           
   void insertPrescription(prescribe p) throws SQLException {
        Connection conn = getConnection();
        Statement statement = (Statement) conn.createStatement();
        String n = "INSERT INTO prescriptionlist(UserName, Problem, Solution) VALUES ('" +p.getUsername()+ "','" + p.getProblem() + "','" +p.getSolution()+ "')";
        statement.execute(n);

    }        
    ObservableList<AccountInformation> getAllAccountinformation() throws SQLException {
    ObservableList<AccountInformation> accountList = FXCollections.observableArrayList();
        Connection conn = getConnection();
        Statement statement = conn.createStatement();
        String query = "SELECT * FROM accountinformation";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
    String Name = rs.getString("Name");
    String Username=rs.getString("Username");
 
    String Date_of_Birth=rs.getString("DateofBirth");
    String district=rs.getString("District");
    String Upazila=rs.getString("Upazila");
    String PhoneNumber=rs.getString("PhoneNumber");
    String DonationTimes=rs.getString("DonationTimes");
    String BloodGroup=rs.getString("BloodGroup");
    String Password=rs.getString("Password");
    String Sequirity_ques1=rs.getString("SecuirityQues1");
    String Sequirity_ques2=rs.getString("SecuirityQues2");
    String Sequirity_ques3=rs.getString("SecuirityQues3");
    String accountType=rs.getString("AccountType");         
    AccountInformation oc= new AccountInformation(Name,Username,Date_of_Birth,district,Upazila,PhoneNumber,DonationTimes,BloodGroup,Password,Sequirity_ques1,Sequirity_ques2,Sequirity_ques3,accountType);
            accountList.add(oc);
        
        }
    
    
        return accountList;
    }
   void updatePass(String pass,String username) throws SQLException{
        Connection conn = getConnection();
        Statement statement = conn.createStatement();
         String query ="UPDATE `accountinformation` SET `Password`= '"+pass+"' WHERE `Username`='"+username+"'";
         statement.execute(query);
         
    
    
    }
   void Passloginifo(String pass,String username) throws SQLException{
        Connection conn = getConnection();
        Statement statement = conn.createStatement();
         String query ="UPDATE `logininfo` SET `Password`= '"+pass+"' WHERE `Username`='"+username+"'";
         statement.execute(query);
         
    
    
    }
   ObservableList<Notification>   GetAllNotification() throws SQLException{
        ObservableList<Notification> notificationlist = FXCollections.observableArrayList();
        Connection conn = getConnection();
        Statement statement = conn.createStatement();
        String query = "SELECT * FROM notification";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            
    String Username=rs.getString("Username");
        String notification = rs.getString("Notification");
        
        Notification noti =new Notification(Username,notification);
        notificationlist.add(noti);
      
   }
   return notificationlist; 
   }
   void insertNotification(Notification no) throws SQLException{
Connection conn = getConnection();
        Statement statement = (Statement) conn.createStatement();
        String n = "INSERT INTO `notification`(`username`, `Notification`) VALUES ('"+no.getUsername()+"','"+no.getNotifcation()+"')";
        statement.execute(n);

}
    void insertEvent(Event ev) throws SQLException{
Connection conn = getConnection();
        Statement statement = (Statement) conn.createStatement();
        String n = "INSERT INTO `event`(`SlNo`, `Name`, `date`, `time`, `place`, `discription`) VALUES ('"+ev.getSl_No()+"','"+ev.getEvent_name()+"','"+ev.getEvent_Date()+"','"+ev.getEvent_Time()+"','"+ev.getEvent_Place()+"','"+ev.getEvent_discription()+"')";
        statement.execute(n);

}
 ObservableList<Event> getAllEvent() throws SQLException {
        ObservableList<Event> eventlist = FXCollections.observableArrayList();
        Connection conn = getConnection();

        Statement statement = conn.createStatement();
        String query = "SELECT * FROM event";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            String SlNo = rs.getString("SlNo");
            String Name = rs.getString("Name");
            String date = rs.getString("date");
            String time = rs.getString("time");
            String place = rs.getString("place");
            String discription = rs.getString("discription");
          
            Event ev = new Event(SlNo, Name, date, time, place, discription);
            eventlist.add(ev);

        }

        return eventlist; 

    }
 void insertdonation(Donation ev) throws SQLException{
Connection conn = getConnection();
        Statement statement = (Statement) conn.createStatement();
        String n = "INSERT INTO `moneydonationlist`(`username`, `bkashno`, `Ammount`, `TransectionID`,`Month`) VALUES ('"+ev.getUsername()+"','"+ev.getBkashno()+"','"+ev.getAmmount()+"','"+ev.getTransectionID()+"','"+ev.getMonth()+"')";
        statement.execute(n);

}
ObservableList<Donation> getAllDonatoion() throws SQLException {
        ObservableList<Donation> eventlist = FXCollections.observableArrayList();
        Connection conn = getConnection();

        Statement statement = conn.createStatement();
        String query = "SELECT * FROM moneydonationlist";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            String user = rs.getString("username");
            String bkash = rs.getString("bkashno");
            String ammount = rs.getString("Ammount");
            String trans = rs.getString("TransectionID");
            String mont=rs.getString("Month");
          
            Donation ev = new Donation(user, bkash, ammount, trans,mont);
            eventlist.add(ev);

        }
        return eventlist;

 

    }
ObservableList<Expenditure>   GetAllexpenditure() throws SQLException{
        ObservableList<Expenditure> expenditurelist = FXCollections.observableArrayList();
        Connection conn = getConnection();
        Statement statement = conn.createStatement();
        String query = "SELECT * FROM expenditure";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            
              String ammount=rs.getString("Ammount");
        String month = rs.getString("Month");
        
        Expenditure expenditure=  new Expenditure(ammount,month);
        
        expenditurelist.add(expenditure);
      
   }
   return expenditurelist; 
   }
String countDonor() throws SQLException{
    String count = null;  
    Connection conn = getConnection();

        Statement statement = conn.createStatement();
        String query = "SELECT Count(Name) FROM Donor";
        ResultSet rs = statement.executeQuery(query);
        if(rs.next()){
        
         count=rs.getString("Count(Name)");
        
        }
    
    

        return count;
}
String countDoctor() throws SQLException{
    String count = null;  
    Connection conn = getConnection();

        Statement statement = conn.createStatement();
        String query = "SELECT Count(Name) FROM accountinformation where AccountType='Doctor'";
        ResultSet rs = statement.executeQuery(query);
        if(rs.next()){
        
         count=rs.getString("Count(Name)");
        
        }
    
    

        return count;
} 

String  Patientcount() throws SQLException{
    String count = null;  
    Connection conn = getConnection();

        Statement statement = conn.createStatement();
        String query = "SELECT Count(Name) FROM problemlist";
        ResultSet rs = statement.executeQuery(query);
        if(rs.next()){
        
         count=rs.getString("Count(Name)");
        
        }
    
    

        return count;
}
String CountmoneyDonnar() throws SQLException{
String count = null;  
    Connection conn = getConnection();

        Statement statement = conn.createStatement();
        String query = "SELECT Count(username) FROM moneydonationlist";
        ResultSet rs = statement.executeQuery(query);
        if(rs.next()){
        
         count=rs.getString("Count(username)");
        
        }
    
    

        return count;



}
String  orphancount() throws SQLException{
    String count = null;  
    Connection conn = getConnection();

        Statement statement = conn.createStatement();
        String query = "SELECT Count(Name) FROM orphanage"; 
        ResultSet rs = statement.executeQuery(query);
        if(rs.next()){
        
         count=rs.getString("Count(Name)");
        
        }
    
    

        return count;
}
String  orphanagecount() throws SQLException{
    String count = null;  
    Connection conn = getConnection();

        Statement statement = conn.createStatement();
        String query = "SELECT Count(Name) FROM orphanageinfo"; 
        ResultSet rs = statement.executeQuery(query);
        if(rs.next()){
        
         count=rs.getString("Count(Name)");
        
        }
    
    

        return count;
}
String  OldPeoplecount() throws SQLException{
    String count = null;  
    Connection conn = getConnection();

        Statement statement = conn.createStatement();
        String query = "SELECT Count(Name) FROM oldagehomeinfo"; 
        ResultSet rs = statement.executeQuery(query);
        if(rs.next()){
        
         count=rs.getString("Count(Name)");
        
        }
    
    

        return count;
}
String  oldagehomecount() throws SQLException{
    String count = null;  
    Connection conn = getConnection();

        Statement statement = conn.createStatement();
        String query = "SELECT Count(Name) FROM oldagehome"; 
        ResultSet rs = statement.executeQuery(query);
        if(rs.next()){
        
         count=rs.getString("Count(Name)");
        
        }
    
    

        return count;
}

String StudentCount() throws SQLException{

String count = null;  
    Connection conn = getConnection();

        Statement statement = conn.createStatement();
        String query = "SELECT Count(Name) FROM studentlist"; 
        ResultSet rs = statement.executeQuery(query);
        if(rs.next()){
        
         count=rs.getString("Count(Name)");
        
        }
    
    

        return count;


}
String ScholarshipCount() throws SQLException{
String count = null;  
    Connection conn = getConnection();

        Statement statement = conn.createStatement();
        String query = "SELECT Count(Name) FROM sholarshipinfo"; 
        ResultSet rs = statement.executeQuery(query);
        if(rs.next()){
        
         count=rs.getString("Count(Name)");
        
        }
    
    

        return count;


}
String SchoolCount() throws SQLException{
String count = null;  
    Connection conn = getConnection();

        Statement statement = conn.createStatement();
        String query = "SELECT Count(Name) FROM school"; 
        ResultSet rs = statement.executeQuery(query);
        if(rs.next()){
        
         count=rs.getString("Count(Name)");
        
        }
    
    

        return count;


}
String moneylistSum(String mn) throws SQLException{
String sum = null;  
    Connection conn = getConnection();

        Statement statement = conn.createStatement();

String query="SELECT SUM(Ammount) FROM moneydonationlist WHERE Month='"+mn+"'";
 ResultSet rs = statement.executeQuery(query);
  if(rs.next()){
        
         sum=rs.getString("SUM(Ammount)");
        
        }
        return sum;

}
//SELECT SUM(Ammount) FROM expenditurelist WHERE Month='January'
String ExpenditurelistSum(String mn) throws SQLException{
String sum = null;  
    Connection conn = getConnection();

        Statement statement = conn.createStatement();

String query="SELECT SUM(Ammount) FROM expenditurelist WHERE Month='"+mn+"'";
 ResultSet rs = statement.executeQuery(query);
  if(rs.next()){
        
         sum=rs.getString("SUM(Ammount)");
        
        }
        return sum;

}

}
