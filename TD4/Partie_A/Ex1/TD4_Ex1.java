import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class TD4_Ex1 {
    TD4_Ex1(String nomPage){
        try {
            String page = "http://www."+nomPage;
            URL u = new URL(page);
            URLConnection c = u.openConnection();

            String chemin = "C:\\Users\\Rom\\Documents\\Inteliji\\TD4\\Partie_A\\Ex1\\resultat.html" ;
            System.out.println("Je charge "+nomPage);
            BufferedReader din = new BufferedReader(new InputStreamReader(c.getInputStream()));
            PrintStream pout = new PrintStream(new FileOutputStream(chemin));

            String s ="nonnulle";
            while (s != null){
                s = din.readLine();
                System.out.print(".");
                pout.println(s);
            }
            pout.close();
            din.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Scanner saisie = new Scanner(System.in);
        System.out.println("Saisissez un nom de page :");
        TD4_Ex1 test = new TD4_Ex1(saisie.nextLine());
    }
}
