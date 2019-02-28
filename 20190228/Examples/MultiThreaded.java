public class MultiThreaded{
	public static void main (String [] args) throws Exception{
		Object lock = new Object();
		
		Thread t1 = new TextPrintingThread("aaaaa",lock);
		Thread t2 = new TextPrintingThread("bbbbb",lock);
		
		t1.start();
		
		
		t2.start();
	}
	
	
}

class TextPrintingThread extends Thread{
	
	private String text;
	Object lock;
	
	public TextPrintingThread(String text, Object lock){
		this.text = text;
		this.lock = lock;
	}
	
	@Override
	public void run(){
		for(int i=0; i<=10; i++){
			
			myPrintLn();
		}
	}
	
	public void myPrintLn(){
		synchronized (lock){
			for(char c: text.toCharArray()){
				try{
					sleep(1);
				}catch(Exception e){}
				System.out.print(c);
			}
		}
		System.out.println();
	}
}