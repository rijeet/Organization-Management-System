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
public class Event {
    String Sl_No;
    String Event_name;
    String Event_Date;
    String Event_Time;
    String Event_Place;
    String Event_discription;

    public Event() {
    }

    public Event(String Sl_No, String Event_name, String Event_Date, String Event_Time, String Event_Place, String Event_discription) {
        this.Sl_No = Sl_No;
        this.Event_name = Event_name;
        this.Event_Date = Event_Date;
        this.Event_Time = Event_Time;
        this.Event_Place = Event_Place;
        this.Event_discription = Event_discription;
    }

    public String getSl_No() {
        return Sl_No;
    }

    public void setSl_No(String Sl_No) {
        this.Sl_No = Sl_No;
    }

    public String getEvent_name() {
        return Event_name;
    }

    public void setEvent_name(String Event_name) {
        this.Event_name = Event_name;
    }

    public String getEvent_Date() {
        return Event_Date;
    }

    public void setEvent_Date(String Event_Date) {
        this.Event_Date = Event_Date;
    }

    public String getEvent_Time() {
        return Event_Time;
    }

    public void setEvent_Time(String Event_Time) {
        this.Event_Time = Event_Time;
    }

    public String getEvent_Place() {
        return Event_Place;
    }

    public void setEvent_Place(String Event_Place) {
        this.Event_Place = Event_Place;
    }

    public String getEvent_discription() {
        return Event_discription;
    }

    public void setEvent_discription(String Event_discription) {
        this.Event_discription = Event_discription;
    }
    
    
    
}
