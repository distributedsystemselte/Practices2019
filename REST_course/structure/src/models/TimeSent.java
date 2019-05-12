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
public class TimeSent implements Serializable{
    private long utcDatetime;
    public TimeSent(long utcDatetime){
        this.utcDatetime = utcDatetime;
    }
    public TimeSent(){

    }
    @XmlElement(name = "utcDatetime")
    public long getUtcDatetime(){
        return utcDatetime;
    }
    public void setUtcDatetime(long utcDatetime){
        this.utcDatetime = utcDatetime;
    }
}