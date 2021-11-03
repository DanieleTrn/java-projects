import java.net.*;
import java.io.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client {
    public static void main(String[] args) throws IOException{
        Socket client = null;
        String nickname = "";
        String msg = "";
        Scanner scan = new Scanner(System.in);
        
        //Scelgo un nickname
        System.out.println("Scegli un nickname: \n");
        nickname = scan.nextLine();
        
        //Tento la connessione
        client = new Socket("127.0.0.1", 6503);
        PrintStream os = new PrintStream(client.getOutputStream());
        while(true){
            msg = scan.nextLine();
            os.println(nickname + ": " + msg);
            if(msg.equals("QUIT")){
                break;
            }
        }
	os.println(nickname + " ha abbandonato la chat");
        os.close();
    }
}