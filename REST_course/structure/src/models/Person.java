package restcourse.models;


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
public class Person implements Serializable {
    private String lastname;
    private String firstname;
    private String username;
    private Date created;
    private String email;


    public Person(String lastname, String firstname, String username, String email){
      this.lastname = lastname;
      this.firstname = firstname;
      this.username = username;
      this.email = email;
      this.created = new Date();
    }

    public Person(){
      this.created = new Date();
    }

    // getters
    public String getLastname(){
        return lastname;
    }
    @XmlElement(name = "firstname")
    public String getName(){
        return firstname;
    }
    @XmlTransient
    public String getUsername(){
        return username;
    }
    public Date getCreated(){
        return this.created;
    }
    //@XmlTransient
    public String getEmail(){
        return email;
    }

    // setters
    public void setLastname(String lastname){
        this.lastname = lastname;
    }
    public void setName(String name){
        this.firstname = name;
    }
    public void setUsername(String username){
        this.username = username;
    }
    // public void setBirthdate(Date birthdate){
    //     this.birthdate = birthdate;
    // }
    public void setEmail(String email){
        this.email = email;
    }





}
