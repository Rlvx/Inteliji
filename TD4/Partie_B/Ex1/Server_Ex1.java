import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutionException;

public class Server_Ex1 {
    public static void main(String[] args) {
        try {
            int port = 27015;
            ServerSocket ss = new ServerSocket(port,5);
            System.out.println("Le serveur reçoit sur le Port : " + ss.getLocalPort());
            System.out.println("Prêt !");
            Socket client = ss.accept();  //wait connexion
            System.out.println("Connexion reçue de : "+client.getInetAddress());
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter out = new PrintWriter(client.getOutputStream());
            out.println("Allo ????");
            out.flush();
            String line = in.readLine();
            System.out.println("> Reçu : "+line);
            out.println("Echo : "+line);
            out.println(".......Oui.......");
            out.println(".......Yes.......");
            out.close();
            client.close();
            ss.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
