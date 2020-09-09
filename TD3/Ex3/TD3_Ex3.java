import java.io.*;
import java.util.Scanner;

public class TD3_Ex3 {
    public static void main(String[] args) {
        long tirage[] = new long[6];
        int case_actu = 0;
        boolean exite_déja ;
        try {
            String chemin = "C:\\Users\\Rom\\Documents\\Inteliji\\TD3\\Ex3\\loto";
            PrintWriter fichier = new PrintWriter(new FileWriter(chemin));
           while (case_actu!=6){
                exite_déja = false;
                long number = Math.round(1+(Math.random()*48)) ;
                for (int j = 0; j < tirage.length ; j++) {
                    if(tirage[j]==number){
                        exite_déja = true;
                    }
                }
                if(exite_déja == false){
                    tirage[case_actu]=number;
                    case_actu++;
                    fichier.print(number+" ");
                    System.out.println(number);
                }
           }
            fichier.close();


        }catch (FileNotFoundException e){
            System.out.println("Pas de fichier avec ce nom");
        }catch (IOException e){
            System.out.println("Erreur lors de la lecture");
        }
    }
}