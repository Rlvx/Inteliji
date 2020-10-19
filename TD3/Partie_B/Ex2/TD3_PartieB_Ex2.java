import java.io.*;

public class TD3_PartieB_Ex2 {
    public static void main(String[] args) {
        String chemin = "C:\\Users\\Rom\\Documents\\Inteliji\\TD3\\Partie_B\\Ex2\\fichier";
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(chemin)));
            OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(chemin));

            writer.write("test");
            writer.flush();
            System.out.println(reader.readLine());
            writer.close();
            reader.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
