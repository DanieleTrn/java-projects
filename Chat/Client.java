import java.net.*;
import java.io.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client {
    public static void main(String[] args) throws IOException{
        Socket client = null;
        client = new Socket("127.0.0.1", 6503);
        BufferedWriter os = new BufferedWriter(new PrintWriter(client.getOutputStream(), true));
        //TODO ADD WHILE LOOP
        String msg = "Ciao";
        os.write(msg);
        os.close();
    }
}