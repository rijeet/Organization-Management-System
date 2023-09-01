/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpd;

public class Notification {
  String Username;
  String Notifcation;

    public Notification() {
    }

    public Notification(String Username, String Notifcation) {
        this.Username = Username;
        this.Notifcation = Notifcation;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getNotifcation() {
        return Notifcation;
    }

    public void setNotifcation(String Notifcation) {
        this.Notifcation = Notifcation;
    }
  
}
