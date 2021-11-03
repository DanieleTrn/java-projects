import java.net.*;
import java.io.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client {
    public static void main(String[] args) throws IOException{
        Socket client = null;
        String msg = "";
        Scanner scan = new Scanner(System.in);
        client = new Socket("127.0.0.1", 6503);
        PrintStream os = new PrintStream(client.getOutputStream());
        while(true){
            msg = scan.nextLine();
            os.println(msg);
            if(msg.equals("QUIT")){
                break;
            }
        }
        os.close();
    }
}