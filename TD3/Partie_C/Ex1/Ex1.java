import java.io.File;
import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        String nom_fichier ;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrer le nom du fichier :");
        nom_fichier = scanner.next();
        String chemin = "C:\\Users\\Rom\\Documents\\Inteliji\\TD3\\Partie_C\\Ex1\\"+nom_fichier;
        try{
            File file = new File(chemin);
            File liste[] = file.listFiles();

            for(File fichier : liste){
                if(fichier.isDirectory()){
                    System.out.println("Dossier : "+fichier.getName()+" \\ Poid : "+fichier.length());
                }else {
                    System.out.println("Fichier : "+fichier.getName()+" \\ Poid : "+fichier.length());
                }

            }
        }catch(Exception e){
            System.out.println("Erreur : " +e.toString());
        }
    }
}
