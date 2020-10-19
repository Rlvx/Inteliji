import jdk.jshell.spi.SPIResolutionException;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URLConnection;
import java.util.Scanner;
class User implements Serializable{
    String nom ;
    String prenom;
    String num;
    String email;
    String profession;
    public User(String nom, String prenom, String num, String email, String profession) {
        this.nom = nom;
        this.prenom = prenom;
        this.num = num;
        this.email = email;
        this.profession = profession;
    }
}
public class ClientUser {
    void envoieAdmin(User user){
        try {
            Socket sc = new Socket(InetAddress.getLocalHost().getHostName(),27002);

            //Infos flux entrant
            PrintWriter printer = new PrintWriter(sc.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(sc.getInputStream());
            ObjectOutputStream out = new ObjectOutputStream(sc.getOutputStream());

            //Si il y a réponse, on considère la connexion comme établie
            printer.println("addVisiteur");
            printer.flush();
            if(in.readBoolean()){
                System.out.println("Le serveur est ready !");
                out.writeObject(user);
                out.flush();
            }
            printer.close();
            out.close();
            sc.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    void envoieVisiteur(User user){
        try {
            Socket sc = new Socket(InetAddress.getLocalHost().getHostName(),27002);

            //Infos flux entrant
            PrintWriter printer = new PrintWriter(sc.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(sc.getInputStream());
            ObjectOutputStream out = new ObjectOutputStream(sc.getOutputStream());

            //Si il y a réponse, on considère la connexion comme établie
            printer.println("addAdmin");
            printer.flush();
            if(in.readBoolean()){
                System.out.println("Le serveur est ready !");
                out.writeObject(user);
                out.flush();
            }
            printer.close();
            out.close();
            sc.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    void getConnexion(){
        try {
            Socket sc = new Socket(InetAddress.getLocalHost().getHostName(),27002);

            //Infos flux entrant
            PrintWriter printer = new PrintWriter(sc.getOutputStream());
            ObjectOutputStream out = new ObjectOutputStream(sc.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(sc.getInputStream());

            //Si il y a réponse, on considère la connexion comme établie
            printer.println("tryConnexion");
            printer.flush();
            out.flush();
            if(in.readBoolean()){
                System.out.println("Connexion OK avec le server");
            }
            printer.close();
            out.close();
            sc.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    void getInfosAdmins(){
        try {
            Socket sc = new Socket(InetAddress.getLocalHost().getHostName(),27002);

            //Infos flux entrant
            PrintWriter printer = new PrintWriter(sc.getOutputStream());
            ObjectOutputStream out_obj = new ObjectOutputStream(sc.getOutputStream());
            ObjectInputStream in_obj = new ObjectInputStream(sc.getInputStream());

            //Si il y a réponse, on considère la connexion comme établie
            printer.println("voirAdmin");
            printer.flush();
            if(in_obj.readBoolean()){
                System.out.println("Le serveur est ready");
            }
            printer.close();
            out_obj.close();
            sc.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        ClientUser client = new ClientUser();
        User test = new User("test","test","test","test","test");
        User admin = new User("admin","admin","admin","admin","admin");
        Scanner choice = new Scanner(System.in);
        System.out.println("Faites votre choix : 1 - 2 - 3");
        int choix = choice.nextInt();
        switch (choix){
            case 1 :{
                client.envoieAdmin(admin);
                break;
            }
            case 2 :{
                client.envoieVisiteur(test);
                break;
            }
            case 3 :{
                client.getConnexion();
                break;
            }
            case 4 :{
                client.getInfosAdmins();
                break;
            }
        }

    }
}
