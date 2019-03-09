package Mythread;
import java.util.Random;
public class Goat extends Thread{
	private double length;
	private Object obj;
	private double power;
	private String name;
	private boolean fall=false;
	public Goat(double length,Object obj,String name){
		this.length = length;
		this.obj = obj;
		this.name = name;
	}
	public void receivePush(double pushLength) throws InterruptedException{

		System.out.println(this.name+" is being pushed with = " + pushLength);
		length-=pushLength;
		System.out.println("current Length : " + this.length);
		if(length < 0){
			System.out.println(this.name + " has been fallen over the edge --");
			fall = true;
		}
		else{
			System.out.println(this.name + " hasn't been fallen over the edge --");
			fall = false;
		}
	}
	public double getLength(){
		return length;
	}
	public double getPower(){
		return power;
	}
	public void push(Goat goat2)  throws InterruptedException{
		Random rand = new Random();
		double max = 2;
		double min = 0;
		double waitTime = min + rand.nextDouble() * (max-min);
		long w = Math.round(waitTime * 1000);
		System.out.println("Gathering power "+w);
		Thread.sleep(w);
		if (length > 0) {
			power = rand.nextDouble();
			goat2.receivePush(power);
		}
	}
	public boolean isFallen(){
		return fall;
	}
	@Override
    public void run(){
		synchronized(obj){}
	}
}