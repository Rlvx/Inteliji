import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class TD4_Ex2 {
    TD4_Ex2(String maMac){
        try {
            String page = "http://api.macvendors.com/"+maMac;
            URL u = new URL(page);
            URLConnection c = u.openConnection();

            String chemin = "C:\\Users\\Rom\\Documents\\Inteliji\\TD4\\Partie_A\\Ex2\\CSV" ;
            System.out.println("Je charge "+maMac);
            BufferedReader din = new BufferedReader(new InputStreamReader(c.getInputStream()));
            PrintStream pout = new PrintStream(new FileOutputStream(chemin));

            String s = din.readLine();
            while (s != null){
                System.out.print(".");
                pout.append(maMac+","+s);
                s = din.readLine();
            }
            pout.close();
            din.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Scanner saisie = new Scanner(System.in);
        System.out.println("Saisissez une mac adresse :");
        TD4_Ex2 test = new TD4_Ex2(saisie.nextLine());
    }
}
