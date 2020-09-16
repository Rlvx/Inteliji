import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class TD3_Ex2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner( System.in );
        String ligne ;
        double somme_buffer = 0;
        try {
            System.out.println("Saisir le nom du fichier  :");
            String chemin = "C:\\Users\\Rom\\Documents\\Inteliji\\TD3\\Partie_A\\Ex2\\"+scan.nextLine();
            BufferedReader fichier = new BufferedReader(new FileReader(chemin));
            while ((ligne = fichier.readLine())!= null){
                StringTokenizer chaine_découpé = new StringTokenizer(ligne);
                while (chaine_découpé.hasMoreTokens()){
                    somme_buffer+=Double.parseDouble(chaine_découpé.nextToken());
                }
            }
            System.out.println("La somme est : "+somme_buffer);
        }catch (FileNotFoundException e){
            System.out.println("Pas de fichier avec ce nom");
        }catch (IOException e){
            System.out.println("Erreur lors de la lecture");
        }
    }
}