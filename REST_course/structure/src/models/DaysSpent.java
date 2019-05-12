package models;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlElementRef;

@XmlRootElement //(name="Pepepeperson")
public class DaysSpent implements Serializable{
    private long days;
    public DaysSpent(long days){
        this.days = days;
    }
    public DaysSpent(){

    }
    @XmlElement(name = "days")
    public long getDays(){
        return days;
    }
    public void setDays(long days){
        this.days = days;
    }
}