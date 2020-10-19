public class BornePaiement extends Equipement{
    private Boolean typeEcran;
    private String resolutionEcran;
    private double tempsDeReponse;

    public BornePaiement(String adrIP, String adrMac, Boolean etat, Boolean mis_baie, double[] dim_baie, Boolean typeEcran, String resolutionEcran, double tempsDeReponse) {
        super(adrIP, adrMac, mis_baie,etat,dim_baie);
        this.typeEcran = typeEcran;
        this.resolutionEcran = resolutionEcran;
        this.tempsDeReponse = tempsDeReponse;
    }
    public BornePaiement(String adrIP, String adrMac, Boolean etat,Boolean mis_baie, Boolean typeEcran, String resolutionEcran, double tempsDeReponse) {
        super(adrIP, adrMac, mis_baie,etat);
        this.typeEcran = typeEcran;
        this.resolutionEcran = resolutionEcran;
        this.tempsDeReponse = tempsDeReponse;
    }
    public String toString(){
        if(getDim_baie()==null){
            return ("-------Infos Borne de Paiement---------\n" +
                    "Adesse IP : "+getAdrIP()+"\n" +
                    "Adresse Mac : "+getAdrMac()+"\n" +
                    "Nom du contructeur : "+getNom_const()+"\n" +
                    "Peut etre mise en Baie : "+getMis_baie()+"\n" +
                    "Dimension de baie : aucune \n" +
                    "Etat : "+getEtat()+"\n" +
                    "Ecran : "+getTypeEcran()+"\n" +
                    "Resolution : "+getResolutionEcran()+"\n" +
                    "Temps de réponse : "+getTempsDeReponse());
        }else{
            return ("-------Infos Borne de Paiement---------\n" +
                    "Adesse IP : "+getAdrIP()+"\n" +
                    "Adresse Mac : "+getAdrMac()+"\n" +
                    "Nom du contructeur : "+getNom_const()+"\n" +
                    "Peut etre mise en Baie : "+getMis_baie()+"\n" +
                    "Dimension de baie : "+getDim_baie()[0]+" / "+getDim_baie()[1]+" / "+getDim_baie()[2]+"\n" +
                    "Etat : "+getEtat()+"\n"+
                    "Ecran : "+getTypeEcran()+"\n" +
                    "Resolution : "+getResolutionEcran()+"\n" +
                    "Temps de réponse : "+getTempsDeReponse());
        }
    }

    public Boolean getTypeEcran() {
        return typeEcran;
    }

    public String getResolutionEcran() {
        return resolutionEcran;
    }

    public double getTempsDeReponse() {
        return tempsDeReponse;
    }
}
