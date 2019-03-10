import java.util.*;
import java.io.*;
import java.net.*;

class ChatClient implements Runnable  
{ 
    Scanner scn = new Scanner(System.in); 
    private String name; 
    final Scanner dis; 
    final PrintWriter dos; 
    Socket s; 
    boolean isloggedin; 
    public ChatClient(Socket s, String name, 
                            Scanner dis, PrintWriter dos) { 
        this.dis = dis; 
        this.dos = dos; 
        this.name = name; 
        this.s = s; 
        this.isloggedin=true; 
    } 
    @Override
    public void run() { 
        String received; 
        while (true)  
        { 
                received = dis.nextLine(); 
                System.out.println(received);                  
                StringTokenizer st = new StringTokenizer(received, "#"); 
                String MsgToSend = st.nextToken(); 
                String recipient = st.nextToken(); 
                for (ChatClient mc : Server.ar)  
                { 
                    System.out.println("name= "+ mc.name + ","+recipient);
                    System.out.println("Equals: "+mc.name.equals(recipient));
                    if (mc.name.equals(recipient) && mc.isloggedin)  
                    { 
                        System.out.println(this.name + " : " + MsgToSend);
                        mc.dos.println(this.name+" : "+MsgToSend); 
                        mc.dos.flush();
                        break; 
                    } 
                } 
        }         
    }

} 