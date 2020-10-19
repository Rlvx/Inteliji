public class Camera extends Equipement{
    private double nbImavgeSeconde;
    private String typeCamera;
    private double resolutionCamera;

    public Camera(String adrIP, String adrMac, Boolean etat,Boolean mis_baie, double[] dim_baie, double nbImavgeSeconde, String typeCamera, double resolutionCamera) {
        super(adrIP, adrMac, mis_baie, etat,dim_baie);
        this.nbImavgeSeconde = nbImavgeSeconde;
        this.typeCamera = typeCamera;
        this.resolutionCamera = resolutionCamera;
    }
    public Camera(String adrIP, String adrMac, Boolean etat,Boolean mis_baie, double nbImavgeSeconde, String typeCamera, double resolutionCamera) {
        super(adrIP, adrMac, mis_baie,etat);
        this.nbImavgeSeconde = nbImavgeSeconde;
        this.typeCamera = typeCamera;
        this.resolutionCamera = resolutionCamera;
    }
    public String toString(){
        if(getDim_baie()==null){
            return ("-------Infos Camera---------\n" +
                    "Adesse IP : "+getAdrIP()+"\n" +
                    "Adresse Mac : "+getAdrMac()+"\n" +
                    "Nom du contructeur : "+getNom_const()+"\n" +
                    "Peut etre mise en Baie : "+getMis_baie()+"\n" +
                    "Dimension de baie : aucune \n" +
                    "Etat : "+getEtat()+"\n" +
                    "IPS : "+getNbImavgeSeconde()+"\n" +
                    "Type : "+getTypeCamera()+"\n" +
                    "Resolution : "+getResolutionCamera());
        }else{
            return ("-------Infos Camera---------\n" +
                    "Adesse IP : "+getAdrIP()+"\n" +
                    "Adresse Mac : "+getAdrMac()+"\n" +
                    "Nom du contructeur : "+getNom_const()+"\n" +
                    "Peut etre mise en Baie : "+getMis_baie()+"\n" +
                    "Dimension de baie : "+getDim_baie()[0]+" / "+getDim_baie()[1]+" / "+getDim_baie()[2]+"\n" +
                    "Etat : "+getEtat()+"\n"+
                    "IPS : "+getNbImavgeSeconde()+"\n" +
                    "Type : "+getTypeCamera()+"\n" +
                    "Resolution : "+getResolutionCamera());
        }
    }

    public double getNbImavgeSeconde() {
        return nbImavgeSeconde;
    }
    public String getTypeCamera() {
        return typeCamera;
    }
    public double getResolutionCamera() {
        return resolutionCamera;
    }
}