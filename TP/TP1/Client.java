import java.io.*;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;

public class Client {
    private boolean connexionOk;
    Client() {
        connexionOk = false;
    }

    //Fonction ouvre une connexion
    void connexion(){
        try {
            //Ouverture d'une connexion
            Socket sc = new Socket(InetAddress.getLocalHost().getHostName(),27050);

            //Ouverture des flux
            PrintWriter writer = new PrintWriter(sc.getOutputStream());
            ObjectOutputStream out = new ObjectOutputStream(sc.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(sc.getInputStream());

            //Si il y a réponse, on considère la connexion comme établie
            writer.println("tryConnexion");
            writer.flush();
            if(in.readBoolean()){
                System.out.println("Connexion OK avec le server");
                connexionOk = true;
            }
            writer.close();
            out.close();
            sc.close();
        }catch (ConnectException e) {
            System.out.println("La connexion au serveur a échoué");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Fonction ajouter
    void ajouterEquipement(Equipement eq){
        try {
            Socket sc = new Socket(InetAddress.getLocalHost().getHostName(),27050);

            //Ouverture des flux
            PrintWriter writer = new PrintWriter(sc.getOutputStream());
            ObjectOutputStream out = new ObjectOutputStream(sc.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(sc.getInputStream());

            //Si il y a réponse, on considère la connexion comme établie
            writer.println("addEquipement");
            writer.flush();
            if(in.readBoolean()){
                System.out.println("Le serveur est ready !");
                out.writeObject(eq);
                out.flush();
            }
            writer.close();
            out.close();
            sc.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    void ajouterPorte(Porte porte){
        try {
            Socket sc = new Socket(InetAddress.getLocalHost().getHostName(),27050);

            //Ouverture des flux
            PrintWriter writer = new PrintWriter(sc.getOutputStream());
            ObjectOutputStream out = new ObjectOutputStream(sc.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(sc.getInputStream());

            //Si il y a réponse, on considère la connexion comme établie
            writer.println("addPorte");
            writer.flush();
            if(in.readBoolean()){
                System.out.println("Le serveur est ready !");
                out.writeObject(porte);
                out.flush();
            }
            writer.close();
            out.close();
            sc.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //Fonction recuperation de liste
    ArrayList<Equipement> getListeEquipement(){
        ArrayList<Equipement> arrayList_buffer = new ArrayList<>();
        Object buffer ;
        try {
            Socket sc = new Socket(InetAddress.getLocalHost().getHostName(),27050);

            //Ouverture des flux
            PrintWriter writer = new PrintWriter(sc.getOutputStream());
            ObjectOutputStream out = new ObjectOutputStream(sc.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(sc.getInputStream());

            //Si il y a réponse, on considère la connexion comme établie
            writer.println("getListEquipement");
            writer.flush();
            if(in.readBoolean()){
                System.out.println("Le serveur est ready !");
                while ((buffer = in.readObject())!=null){
                    arrayList_buffer.add((Equipement)buffer);
                }
            }
            writer.close();
            out.close();
            sc.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return arrayList_buffer;
    }
    ArrayList<Porte> getListePorte(){
        ArrayList<Porte> arrayList_buffer = new ArrayList<>();
        Object buffer ;
        try {
            Socket sc = new Socket(InetAddress.getLocalHost().getHostName(),27050);

            //Ouverture des flux
            PrintWriter writer = new PrintWriter(sc.getOutputStream());
            ObjectOutputStream out = new ObjectOutputStream(sc.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(sc.getInputStream());

            //Si il y a réponse, on considère la connexion comme établie
            writer.println("getListPorte");
            writer.flush();
            if(in.readBoolean()){
                System.out.println("Le serveur est ready !");
                while ((buffer = in.readObject())!=null){
                    arrayList_buffer.add((Porte) buffer);
                }
            }
            writer.close();
            out.close();
            sc.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return arrayList_buffer;
    }

    //Fonction affichage arrayliste
    String voirEquipementsPeage(ArrayList<Equipement> a, ArrayList<Porte> b){
        String affichage="---------------Equipement dans le Peage---------------\n"; ;
        for (Equipement e : a) {
            affichage = affichage + e.toString() +"\n\n";
        }
        affichage += "---------------Portes dans le Peage---------------\n"; ;
        for (Porte e : b) {
            affichage = affichage + e.toString();
        }
        return affichage;
    }
    String voirEquipementsPorte(ArrayList<Equipement> a){
        String affichage="Porte :\n"; ;
        for (Equipement e : a) {
            affichage = affichage + e.toString() +"\n\n";
        }
        return affichage;
    }

    //Fonction Recherche
    String rechercherEquipement(String adr,Boolean est_ip,Boolean all){
        String retour = "Aucun équipement trouvé !";
        if(all){
            for (Porte porte : getListePorte()) {
                for (Equipement eq : porte.getListe_equipement_porte()) {
                    if(est_ip){
                        if(eq.compare_adrIP(adr)){
                            retour = eq.toString();
                        }
                    }else {
                        if(eq.compare_adrMAC(adr)){
                            retour = eq.toString();
                        }
                    }
                }
            }
        }
        for (Equipement eq : getListeEquipement()) {
            if(est_ip){
                if(eq.compare_adrIP(adr)){
                    retour = eq.toString();
                }
            }else {
                if(eq.compare_adrMAC(adr)){
                    retour = eq.toString();
                }
            }
        }

        return retour;
    }



    public static void main(String[] args) {
        interfaceGraphique test = new interfaceGraphique(new Client());
    }





    public boolean isConnexionOk() {
        return connexionOk;
    }
}
