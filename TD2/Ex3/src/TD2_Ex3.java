import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
//-----------------Déclaration d'une classe stockant le prix des plats et permetant d'instancier un JCheckBoxMenuItem et un JLabel avec comme nom le nom du plat---------------//
class CheckBoxMenuItem{
    JCheckBoxMenuItem item;
    JLabel label ;
    int value;
    CheckBoxMenuItem(String name,int value){
        item = new JCheckBoxMenuItem(name);
        label = new JLabel("> "+name);
        this.value = value;
    }
}
public class TD2_Ex3 extends JFrame implements ActionListener {
    JMenuBar bar_de_menu;
    JMenu menu1,menu2,menu3 ;
    JButton adition ;
    JFrame fen_Adition ;
    JLabel label,label2;
    JTextField note;
    JPanel haut,bas;
    ButtonGroup groupepaie,lieuconso;
    ArrayList<CheckBoxMenuItem> liste_plats;
    ArrayList<JRadioButtonMenuItem> liste_paiement;
    ArrayList<JRadioButtonMenuItem> liste_lieu;
    int amount ;
    TD2_Ex3(){
        //-----------------Param fenetre principale---------------//
        setTitle("Yes");
        setBounds(400,200,502,250);
        bar_de_menu=new JMenuBar();
        setJMenuBar(bar_de_menu);
        //setLayout(new BorderLayout());

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //-----------------Instanciation elements graphiques---------------//
        adition = new JButton("Adition");
        menu1 = new JMenu("Plats");
        menu2 = new JMenu("Paiement");
        menu3 = new JMenu("Lieu");
        //-----------------Affectation des menus à la barre de menu---------------//
        bar_de_menu.add(menu1);
        bar_de_menu.add(menu2);
        bar_de_menu.add(menu3);
        //-----------------Instanciation des Arraylistes d'items de menu---------------//
        liste_plats = new ArrayList<>();
        liste_paiement = new ArrayList<>();
        liste_lieu = new ArrayList<>();
        //-----------------Affectation des items de menu à leur Arrayliste respective---------------//
        liste_plats.add(new CheckBoxMenuItem("apéritif",5));
        liste_plats.add(new CheckBoxMenuItem("entrée",20));
        liste_plats.add(new CheckBoxMenuItem("plat",30));
        liste_plats.add(new CheckBoxMenuItem("dessert",10));
        liste_plats.add(new CheckBoxMenuItem("café",3));
        liste_plats.add(new CheckBoxMenuItem("digestif",3));
        liste_paiement.add(new JRadioButtonMenuItem("espèce"));
        liste_paiement.add(new JRadioButtonMenuItem("chèque"));
        liste_paiement.add(new JRadioButtonMenuItem("carte bleue"));
        liste_lieu.add(new JRadioButtonMenuItem("sur place"));
        liste_lieu.add(new JRadioButtonMenuItem("à emporter"));
        groupepaie=new ButtonGroup();
        lieuconso=new ButtonGroup();
        //-----------------Affectation des items de menu à leur menu respectif---------------//
        for(CheckBoxMenuItem items : liste_plats){
            menu1.add(items.item);
        }
        for(JRadioButtonMenuItem items : liste_paiement){
            menu2.add(items);
            groupepaie.add(items);
        }
        for(JRadioButtonMenuItem items : liste_lieu){
            menu3.add(items);
            lieuconso.add(items);
        }
        //-----------------Ajout d'un ecouteur d'evenement a l'élément graphique de type bouton---------------//
        adition.addActionListener(this);
        //-----------------Ajout d'un element graphique de type bouton au layout---------------//
        add(adition,BorderLayout.CENTER);
        setVisible(true);
    }
    public static void main(String[] args) {
        TD2_Ex3 fen = new TD2_Ex3();
    }

    public void actionPerformed(ActionEvent e) {
        //-----------------Instaciation et Paramétrage fenetre Adition---------------//
        fen_Adition = new JFrame();
        fen_Adition.setTitle("Adition");
        fen_Adition.setBounds(400,200,300,450);
        fen_Adition.setLayout(new BorderLayout());

        //-----------------Instanciation elements graphiques---------------//
        haut = new JPanel();
        bas = new JPanel();
        label = new JLabel("Vous avez commandé :");
        label2 = new JLabel("La note est de :");
        note = new JTextField();
        //-----------------Affectation d'un layout manager au deux panel composant la fenetre adition---------------//
        haut.setLayout(new GridLayout(7,1));
        bas.setLayout(new GridLayout(2,1));
        fen_Adition.add(haut,BorderLayout.CENTER);
        fen_Adition.add(bas,BorderLayout.SOUTH);
        //-----------------Mise en readonly du textarea où est inscrit le montant de la note---------------//
        note.setEnabled(false);
        //-----------------ajout d'un label dans le panel du "haut"---------------//
        haut.add(label);
        //-----------------Boucle renvoyant tous les plats coché et calcul le montant de la note---------------//
        amount = 0 ;
        for(CheckBoxMenuItem items : liste_plats){
            if(items.item.isSelected()){
                haut.add(items.label);
                amount+=items.value;
            }
        }
        //-----------------ajout des derniers éléments graphiques---------------//
        bas.add(label2);
        note.setText(amount+" €");
        note.setDisabledTextColor(Color.black);
        bas.add(note);
        fen_Adition.setVisible(true);
    }
}