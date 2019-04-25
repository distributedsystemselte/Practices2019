import java.io.*;
public class Animal implements Serializable{
	public String name;
	
	public Animal(String name){
		this.name = name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
	
}
