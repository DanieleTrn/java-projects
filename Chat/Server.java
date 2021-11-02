import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server {
    public static void main(String[] args) throws IOException{
        ServerSocket server = null;

        server = new ServerSocket(6503);
        while(true){
            Socket client = server.accept();
            System.out.println(client.getLocalAddress() + " si è connesso");
            BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            System.out.println(reader.readLine());
        }
    }
}
