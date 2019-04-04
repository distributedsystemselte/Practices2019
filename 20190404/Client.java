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
            ObjectInputStream inputStream = new ObjectInputStream(s.getInputStream());
            pw.println("ready");
            pw.flush();
            ConnectionToRMI connection = (ConnectionToRMI)inputStream.readObject();
            System.out.println(connection.getServiceName() + " " + connection.getPort() + " " + connection.getUrl());
            pw.close();
        }

    }
}
