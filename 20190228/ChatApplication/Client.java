import java.util.*;
import java.io.*;
import java.net.*;

class Client
{
    public static void main(String[] args)
        throws Exception
    {
        int port = 12345;
        String computer = "localhost";

        try (
            Socket s = new Socket(computer, port);

            Scanner sc = new Scanner(s.getInputStream());
            PrintWriter pw = new PrintWriter(s.getOutputStream());
        ) {
            pw.println(args[0]);
            pw.flush();
            int init = sc.nextInt();
            System.out.println("Init="+init);
            if(init == 1){
                System.out.println("CONNECTED!");
                while(true){
                    System.out.println("Your msgs: ");
                    Scanner commandLine = new Scanner(System.in);
                    String  msgs = commandLine.nextLine();
                    String receivedMsg = sc.nextLine();
                    pw.println(msgs);
                    pw.flush();
                    System.out.println("Received Msg: " + receivedMsg);

                }
            }
        }

    }
}
