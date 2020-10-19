public class Radar extends Equipement {
    private double frequence;
    private double longueurOnde;
    private double porteeMaximale;

    public Radar(String adrIP, String adrMac,Boolean etat, Boolean mis_baie, double[] dim_baie, double frequence, double longueurOnde, double porteeMaximale) {
        super(adrIP, adrMac, mis_baie,etat, dim_baie);
        this.frequence = frequence;
        this.longueurOnde = longueurOnde;
        this.porteeMaximale = porteeMaximale;
    }
    public Radar(String adrIP, String adrMac,Boolean etat, Boolean mis_baie, double frequence, double longueurOnde, double porteeMaximale) {
        super(adrIP, adrMac,etat, mis_baie);
        this.frequence = frequence;
        this.longueurOnde = longueurOnde;
        this.porteeMaximale = porteeMaximale;
    }
    public String toString(){
        if(getDim_baie()==null){
            return ("-------Infos Radar---------\n" +
                    "Adesse IP : "+getAdrIP()+"\n" +
                    "Adresse Mac : "+getAdrMac()+"\n" +
                    "Nom du contructeur : "+getNom_const()+"\n" +
                    "Peut etre mise en Baie : "+getMis_baie()+"\n" +
                    "Dimension de baie : aucune \n" +
                    "Etat : "+getEtat()+"\n" +
                    "Frequence : "+getFrequence()+"\n" +
                    "Longueur d'onde : "+getLongueurOnde()+"\n" +
                    "Portée max : "+getPorteeMaximale());
        }else{
            return ("-------Infos Radar---------\n" +
                    "Adesse IP : "+getAdrIP()+"\n" +
                    "Adresse Mac : "+getAdrMac()+"\n" +
                    "Nom du contructeur : "+getNom_const()+"\n" +
                    "Peut etre mise en Baie : "+getMis_baie()+"\n" +
                    "Dimension de baie : "+getDim_baie()[0]+" / "+getDim_baie()[1]+" / "+getDim_baie()[2]+"\n" +
                    "Etat : "+getEtat()+"\n"+
                    "Frequence : "+getFrequence()+"\n" +
                    "Longueur d'onde : "+getLongueurOnde()+"\n" +
                    "Portée max : "+getPorteeMaximale());
        }
    }

    public double getFrequence() {
        return frequence;
    }

    public double getLongueurOnde() {
        return longueurOnde;
    }

    public double getPorteeMaximale() {
        return porteeMaximale;
    }
}
