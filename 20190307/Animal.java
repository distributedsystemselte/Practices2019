import java.io.*;
public class Animal implements Serializable{
   String name;	
   public Animal(String name){
    this.name = name;
   }
   public String getName(){
      return name;
   }
}
