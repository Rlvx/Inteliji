import java.io.Serializable;
import java.util.ArrayList;

public class Porte implements Serializable {
    private Boolean etat_porte;
    private String sens;
    private ArrayList<Equipement> liste_equipement_porte;
    public Porte(Boolean etat_porte, String sens) {
        this.etat_porte = etat_porte;
        this.sens = sens;
        this.liste_equipement_porte = new ArrayList<>();
    }
    public void ajouterEquipement(Equipement e){
        liste_equipement_porte.add(e);
    }

    public String toString(){
        String affichage = "-------Infos Porte---------\n" +
                "Etat porte : "+getEtat_porte()+"\n" +
                "Sens porte : "+getSens()+"\n" +
                "Liste d'équipement : \n";
        for (Equipement e : getListe_equipement_porte()) {
            affichage = affichage + e.toString() +"\n\n";
        }
        return affichage;
    }

    public Boolean getEtat_porte() {
        return etat_porte;
    }

    public String getSens() {
        return sens;
    }

    public ArrayList<Equipement> getListe_equipement_porte() {
        return liste_equipement_porte;
    }
}
