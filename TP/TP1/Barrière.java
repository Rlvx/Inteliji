public class Barrière extends Equipement {
    private double longueurBarriere;
    private boolean etatBarriere;

    public Barrière(String adrIP, String adrMac,Boolean etat, Boolean mis_baie, double[] dim_baie, double longueurBarriere, boolean etatBarriere) {
        super(adrIP, adrMac, mis_baie,etat, dim_baie);
        this.longueurBarriere = longueurBarriere;
        this.etatBarriere = etatBarriere;
    }
    public Barrière(String adrIP, String adrMac,Boolean etat, Boolean mis_baie, double longueurBarriere, boolean etatBarriere) {
        super(adrIP, adrMac,etat, mis_baie);
        this.longueurBarriere = longueurBarriere;
        this.etatBarriere = etatBarriere;
    }
    public String toString(){
        if(getDim_baie()==null){
            return ("-------Infos Barrière---------\n" +
                    "Adesse IP : "+getAdrIP()+"\n" +
                    "Adresse Mac : "+getAdrMac()+"\n" +
                    "Nom du contructeur : "+getNom_const()+"\n" +
                    "Peut etre mise en Baie : "+getMis_baie()+"\n" +
                    "Dimension de baie : aucune \n" +
                    "Etat : "+getEtat()+"\n" +
                    "Longueur barrière : "+getLongueurBarriere()+"\n" +
                    "Ouvert ? : "+isEtatBarriere());
        }else{
            return ("-------Infos Barrière---------\n" +
                    "Adesse IP : "+getAdrIP()+"\n" +
                    "Adresse Mac : "+getAdrMac()+"\n" +
                    "Nom du contructeur : "+getNom_const()+"\n" +
                    "Peut etre mise en Baie : "+getMis_baie()+"\n" +
                    "Dimension de baie : "+getDim_baie()[0]+" / "+getDim_baie()[1]+" / "+getDim_baie()[2]+"\n" +
                    "Etat : "+getEtat()+"\n"+
                    "Longueur barrière : "+getLongueurBarriere()+"\n" +
                    "Ouvert ? : "+isEtatBarriere());
        }
    }

    public double getLongueurBarriere() {
        return longueurBarriere;
    }

    public boolean isEtatBarriere() {
        return etatBarriere;
    }
}
