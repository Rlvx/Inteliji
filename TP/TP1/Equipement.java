import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.URL;
import java.net.URLConnection;

public class Equipement implements Serializable {
    //Données Membres
    private String adrIP;
    private String adrMac;
    private String nom_const;
    private Boolean mis_baie;
    private double dim_baie[]  ; //tableau 3 cases (longeur, largeur,hauteur)
    private Boolean etat ;
    //Contructeur
    public Equipement(String adrIP, String adrMac, Boolean etat, Boolean mis_baie, double dim_baie[]) {
        this.adrIP = adrIP;
        this.adrMac = adrMac;
        this.mis_baie = mis_baie;
        this.dim_baie = dim_baie;
        this.etat = etat;
        nom_const=recup_nomconst();
    }
    public Equipement(String adrIP, String adrMac, Boolean etat,Boolean mis_baie) {
        this.adrIP = adrIP;
        this.adrMac = adrMac;
        this.mis_baie = mis_baie;
        this.dim_baie = null;
        this.etat = etat;
        nom_const=recup_nomconst();
    }
    //Methods
    public String toString(){
        if(getDim_baie()==null){
            return ("Adesse IP : "+getAdrIP()+"\n" +
                    "Adresse Mac : "+getAdrMac()+"\n" +
                    "Nom du contructeur : "+getNom_const()+"\n" +
                    "Peut etre mise en Baie : "+getMis_baie()+"\n" +
                    "Dimension de baie : aucune \n" +
                    "Etat : "+getEtat());
        }else{
            return ("Adesse IP : "+getAdrIP()+"\n" +
                    "Adresse Mac : "+getAdrMac()+"\n" +
                    "Nom du contructeur : "+getNom_const()+"\n" +
                    "Peut etre mise en Baie : "+getMis_baie()+"\n" +
                    "Dimension de baie : "+getDim_baie()[0]+" / "+getDim_baie()[1]+" / "+getDim_baie()[2]+"\n" +
                    "Etat : "+getEtat());
        }
    }
    public String recup_nomconst(){
        String page = "http://api.macvendors.com/"+getAdrMac();
        try {
            URL u = new URL(page);
            URLConnection c = u.openConnection();
            BufferedReader din = new BufferedReader(new InputStreamReader(c.getInputStream()));
            String s = din.readLine();
            din.close();
            return s;
        }catch (FileNotFoundException e){
            JOptionPane.showMessageDialog(new JFrame(),"L'adresse Mac n'est pas connu dans le registre !!");
            return "null";
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }
    }
    public boolean compare_adrMAC(String adrMac){
        if(adrMac.equals(getAdrMac())){
            return true ;
        }
        return false ;
    }
    public boolean compare_adrIP(String adrIP){
        if(adrIP.equals(getAdrIP())){
            return true ;
        }
        return false ;
    }
    public void demarrer_Equipement(){
        etat = true;
    }
    public void eteindre_Equipement(){
        etat = false;
    }
    //Getter
    public String getAdrIP() {
        return adrIP;
    }
    public String getAdrMac() {
        return adrMac;
    }
    public String getNom_const() {
        return nom_const;
    }
    public Boolean getMis_baie() {
        return mis_baie;
    }
    public double[] getDim_baie() {
        return dim_baie;
    }
    public Boolean getEtat() {
        return etat;
    }
    //Setter
    public void setAdrIP(String adrIP) {
        this.adrIP = adrIP;
    }
    public void setAdrMac(String adrMac) {
        this.adrMac = adrMac;
    }
    public void setNom_const(String nom_const) {
        this.nom_const = nom_const;
    }
    public void setMis_baie(Boolean mis_baie) {
        this.mis_baie = mis_baie;
    }
    public void setDim_baie(double[] dim_baie) {
        this.dim_baie = dim_baie;
    }
    public void setEtat(Boolean etat) {
        this.etat = etat;
    }
}
