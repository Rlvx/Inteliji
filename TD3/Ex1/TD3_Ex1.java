import java.io.*;
import java.util.Scanner;

public class TD3_Ex1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner( System.in );
        String ligne ;
        try {
            System.out.println("Saisir le nom du fichier  :");
            String chemin = "C:\\Users\\Rom\\Documents\\Inteliji\\TD3\\Ex1\\"+scan.nextLine();
            BufferedReader fichier = new BufferedReader(new FileReader(chemin));
            while ((ligne = fichier.readLine())!= null){
                System.out.println(ligne);
            }

        }catch (FileNotFoundException e){
            System.out.println("Pas de fichier avec ce nom");
        }catch (IOException e){
            System.out.println("Erreur lors de la lecture");
        }
    }
}
