import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server {
    public static void main(String[] args) throws IOException{
        ServerSocket server = null;

        server = new ServerSocket(6503);
        System.out.println("Server inizializzato");
        System.out.println("In attesa di connessioni...");
        Socket client = server.accept();
        System.out.println(client.getLocalAddress() + " si è connesso");
        BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
        String msg = reader.readLine();
        while(null != msg){
            System.out.println(msg);
            msg = reader.readLine();
        }
    }
}