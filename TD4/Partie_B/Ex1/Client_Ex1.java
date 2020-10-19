import javax.print.DocFlavor;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client_Ex1 {
    public static void main(String[] args) {
        int port = 27015;
        try {
            String host = InetAddress.getLocalHost().getHostName();
            Socket sc = new Socket(host,port);
            BufferedReader in = new BufferedReader(new InputStreamReader(sc.getInputStream()));
            PrintWriter out = new PrintWriter(sc.getOutputStream());
            out.println("Allo");
            out.flush();
            String line;
            while ((line = in.readLine()) != null){
                System.out.println(line);
            }
            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
