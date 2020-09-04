import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class TD2_Ex3 extends JFrame {
    JMenu menu1,menu2,menu3 ;
    JMenuBar bar_de_menu ;
    JCheckBoxMenuItem apéritif,entrée,plat,dessert,café,digestif;
    JRadioButtonMenuItem espèce,chèque, carte_bleue, sur_place,emporter ;
    TD2_Ex3(){
        setTitle("Yes");
        setBounds(400,200,502,250);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        bar_de_menu = new JMenuBar();
        menu1 = new JMenu("Plats");
        menu2 = new JMenu("Paiement");
        menu3 = new JMenu("Lieu");
        apéritif = new JCheckBoxMenuItem("apéritif");
        entrée = new JCheckBoxMenuItem("entrée");
        plat = new JCheckBoxMenuItem("plat");
        dessert = new JCheckBoxMenuItem("dessert");
        café = new JCheckBoxMenuItem("café");
        digestif = new JCheckBoxMenuItem("digestif");
        espèce = new JRadioButtonMenuItem("espèce");
        chèque=new JRadioButtonMenuItem("chèque");
        carte_bleue = new JRadioButtonMenuItem("carte bleue");
        sur_place = new JRadioButtonMenuItem("sur place");
        emporter = new JRadioButtonMenuItem("a emporter");
        menu1.add(apéritif);
        menu1.add(entrée);
        menu1.add(plat);
        menu1.add(dessert);
        menu1.add(café);
        menu1.add(digestif);
        menu2.add(espèce);
        menu2.add(chèque);
        menu2.add(carte_bleue);
        menu3.add(sur_place);
        menu3.add(emporter);
        bar_de_menu.add(menu1);
        bar_de_menu.add(menu2);
        bar_de_menu.add(menu3);
        setJMenuBar(bar_de_menu);
    }
    public static void main(String[] args) {
        TD2_Ex3 fen = new TD2_Ex3();
    }
}
