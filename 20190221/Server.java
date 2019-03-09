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

          String text = sc.nextLine();

          pw.println(text.length());
          pw.flush();

        }

    }
}
