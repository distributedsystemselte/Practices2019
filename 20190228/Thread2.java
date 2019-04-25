import Mythread.Goat;
public class Thread2 {
	public static void main(String[] args){
		Object obj = new Object();
		double length = Integer.parseInt(args[0])/2;
		Goat goat1 = new Goat(length,obj,"goat1");
		Goat goat2 = new Goat(length,obj,"goat2");
		try{
			goat1.start();
			goat2.start();
			while(true){
				if(!goat1.isFallen()){
					goat2.push(goat1);
				}
				if(!goat2.isFallen()) {
					goat1.push(goat2);
				}
				if(goat1.isFallen())
				{
					break;
				}
				if(goat2.isFallen()){
					break;
				}
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}