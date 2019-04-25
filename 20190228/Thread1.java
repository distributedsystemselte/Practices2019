import Mythread.MyThread;
public class Thread1{
    public static void main(String[] args){
	Object obj = new Object();
	MyThread thread1 = new MyThread("hello",obj);
	MyThread thread2 = new MyThread("world",obj);
	thread1.start();
	thread2.start();
	
    }
}
