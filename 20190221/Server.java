import java.util.*;
import java.io.*;
import java.net.*;

class Server
{
    public static void main(String[] args)
        throws Exception
    {
        int port = 12345;

        try (
            ServerSocket ss = new ServerSocket(port);
            Socket s  = ss.accept();
            Scanner sc = new Scanner(s.getInputStream());
            PrintWriter pw = new PrintWriter(s.getOutputStream());
        ) {

          pw.println("You have connected to localhost:12345 :)");
          pw.flush();
          while(true){
              String text = sc.nextLine();
              System.out.println(text);
              pw.println("server is retransmitting: " + text);
              pw.flush();
          }
        }

    }
}
