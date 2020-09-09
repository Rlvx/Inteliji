import java.io.*;
import java.util.Scanner;

public class TD3_Ex4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner( System.in );
        try {
            String chemin = "C:\\Users\\Rom\\Documents\\Inteliji\\TD3\\Ex4\\numbers";
            PrintWriter fichier = new PrintWriter(new FileWriter(chemin));
                while (true){
                    System.out.println("Saisir un nombre :");
                    int number = scan.nextInt();
                    if(number==0){
                        fichier.close();
                        System.exit(1);
                    }
                    String a_ecrire = number + " a comme carré " + Math.round(Math.pow(number,2));
                    System.out.println(a_ecrire);
                    fichier.println(a_ecrire);
                }
        }catch (FileNotFoundException e){
            System.out.println("Pas de fichier avec ce nom");
        }catch (IOException e){
            System.out.println("Erreur lors de la lecture");
        }
    }
}