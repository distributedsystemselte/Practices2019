package Mythread;
public class MyThread extends Thread{
    private String word;
    private Object obj;
    public MyThread(String word,Object obj){
		this.word = word;
		this.obj = obj;
    }
    @Override
    public void run(){
	synchronized(obj){
	    for(int i=0;i<5000;i++){
			System.out.println(word);
	    	}
		}
    }
    
}
