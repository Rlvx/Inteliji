import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Serveur {
    private ArrayList<Porte> list_portes_server ;
    private ArrayList<Equipement> list_equipements_server ;
    Serveur(){
        this.list_equipements_server = new ArrayList<>();
        this.list_portes_server = new ArrayList<>();
    }
    void connexion(){
        try {
            while (true){
                //Creation d'un socket serveur
                ServerSocket serverSocket = new ServerSocket(27050);
                //wait une connexion sur le port 27020
                Socket client = serverSocket.accept();

                System.out.println("Connection reçu de : "+client.getInetAddress());
                //ouverture d'un flux sortant qui envoie des datas
                BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
                ObjectInputStream in = new ObjectInputStream(client.getInputStream());
                ObjectOutputStream out_data = new ObjectOutputStream(client.getOutputStream());

                //recuperation de la requête
                String line = reader.readLine() ;
                System.out.println("Requête : "+line);
                switch (line){
                    case "tryConnexion" :{
                        System.out.println("Le client souhaite avoir un ack");
                        out_data.writeBoolean(true);
                        out_data.flush();
                        break;
                    }
                    case "addEquipement" :{
                        System.out.println("Le client souhaite ajouter un equipement");
                        out_data.writeBoolean(true);
                        out_data.flush();
                        list_equipements_server.add((Equipement)in.readObject());
                        break;
                    }
                    case "addPorte" :{
                        System.out.println("Le client souhaite ajouter une porte");
                        out_data.writeBoolean(true);
                        out_data.flush();
                        list_portes_server.add((Porte)in.readObject());
                        break;
                    }
                    case "getListEquipement" :{
                        System.out.println("Le client souhaite recuperer l'arraylist d'équipement");
                        out_data.writeBoolean(true);
                        out_data.flush();
                        for (Equipement ekip : list_equipements_server) {
                            out_data.writeObject(ekip);
                        }
                        out_data.writeObject(null);
                        break;
                    }
                    case "getListPorte" :{
                        System.out.println("Le client souhaite recuperer l'arraylist de porte");
                        out_data.writeBoolean(true);
                        out_data.flush();
                        for (Porte porte : list_portes_server) {
                            out_data.writeObject(porte);
                        }
                        out_data.writeObject(null);
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
        Serveur test = new Serveur();
        test.connexion();
    }
}
