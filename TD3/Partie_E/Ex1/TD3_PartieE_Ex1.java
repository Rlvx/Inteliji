import javax.management.ObjectName;
import java.io.*;

class UserTD implements Serializable {
    String nom;
    String prenom;
    String numero;
    String email;
    String profession;
    String date;
    public UserTD(String nom, String prenom, String numero, String email, String profession, String date) {
        this.nom = nom;
        this.prenom = prenom;
        this.numero = numero;
        this.email = email;
        this.profession = profession;
        this.date = date;
    }
}
public class TD3_PartieE_Ex1 {
    public static void main(String[] args) {
        UserTD test = new UserTD("test","test","test","test","test","test");
        String chemin = "C:\\Users\\Rom\\Documents\\Inteliji\\TD3\\Partie_E\\Ex1\\fichier";
        UserTD buffer ;
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(chemin));
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(chemin));
            out.writeObject(test);
            out.flush();
            buffer =(UserTD) in.readObject();
            System.out.println(buffer.prenom);
            in.close();
            out.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
