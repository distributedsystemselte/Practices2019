import java.io.*; 
import java.util.*; 
import java.net.*; 
public class Server  
{ 
    static Vector<ChatClient> ar = new Vector<>(); 
    static int i = 0;  
    public static void main(String[] args) throws Exception  
    { 
        ServerSocket ss = new ServerSocket(1234);         
        Socket s; 
        while (true)  
        { 
            s = ss.accept();   
            Scanner dis = new Scanner(s.getInputStream()); 
            PrintWriter dos = new PrintWriter(s.getOutputStream());   
  		    ChatClient mtch = new ChatClient(s,"user_" + i, dis, dos); 
            Thread t = new Thread(mtch); 
            System.out.println("Adding this client to active client list"); 
            ar.add(mtch);
            t.start(); 
            i++; 
  
        } 
    } 
} 