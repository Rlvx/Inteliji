import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.BitSet;

public class ServerUser {
    ArrayList<User> admin ;
    ArrayList<User> visiteur ;

    public ServerUser() {
        admin = new ArrayList<>();
        visiteur =  new ArrayList<>();
    }

    void connexion(){
        try {
            while (true){
                //Creation d'un socket serveur
                ServerSocket serverSocket = new ServerSocket(27002);
                //wait une connexion sur le port 27020
                Socket client = serverSocket.accept();

                System.out.println("Connection reçu de : "+client.getInetAddress());
                //ouverture d'un flux sortant qui envoie des datas
                BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
                ObjectInputStream in = new ObjectInputStream(client.getInputStream());
                ObjectOutputStream out_data = new ObjectOutputStream(client.getOutputStream());
                String line = reader.readLine() ;
                System.out.println(line);
                switch (line){
                    case "addVisiteur" :{
                        System.out.println("Le client souhaite ajouter un admin");
                        out_data.writeBoolean(true);
                        out_data.flush();
                        admin.add((User)in.readObject());
                        break;
                    }
                    case "addAdmin" :{
                        System.out.println("Le client souhaite ajouter un visiteur");
                        out_data.writeBoolean(true);
                        out_data.flush();
                        visiteur.add((User)in.readObject());
                        break;
                    }
                    case "tryConnexion" :{
                        System.out.println("Le client souhaite avoir un ack");
                        out_data.writeBoolean(true);
                        out_data.flush();
                        break;
                    }
                    case "voirAdmin" :{
                        System.out.println("Le client souhaite avoir la liste des admins");
                        out_data.writeBoolean(true);
                        out_data.flush();
                        break;
                    }
                }
                //fermeture des flux, de la connexion client et du socket server
                reader.close();
                in.close();
                out_data.close();
                client.close();
                serverSocket.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        ServerUser server = new ServerUser();
        server.connexion();
    }
}
