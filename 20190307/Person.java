import java.io.*;
public class Person implements Serializable{
 public String firstName;
 public String familyName;
 public String message;
 
 public Person(String firstName,String familyName,String message)
 {
 	this.firstName = firstName;
 	this.familyName = familyName;
 	this.message = message;
 }


}
