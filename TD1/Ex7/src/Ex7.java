import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Ex7 extends JFrame{
    JLabel nb_clic ;
    int number_clic = 0;
    static class Fenetres{
        JFrame fen ;
        Fenetres(String title){
            fen = new JFrame();
            fen.setTitle(title);
            fen.setBounds(400,200,502,250);
            fen.setVisible(true);
            fen.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        }
    }
    class evenement_Clic implements MouseListener{
        public void mouseClicked(MouseEvent e) {
            if(number_clic<5){
                number_clic++;
                nb_clic.setText("Nombre de clics = "+number_clic);
            }else{
                nb_clic.setText("Fin");
            }

        }
        public void mousePressed(MouseEvent e) {
        }
        public void mouseReleased(MouseEvent e) {
        }
        public void mouseEntered(MouseEvent e) {
        }
        public void mouseExited(MouseEvent e) {
        }
    }
    Ex7(){
        Fenetres ma_fenetre = new Fenetres("Test");
        ma_fenetre.fen.setLayout(new FlowLayout(FlowLayout.CENTER,50,50));
        ma_fenetre.fen.addMouseListener(new evenement_Clic());
        nb_clic = new JLabel("Nombre de clics = 0");
        ma_fenetre.fen.add(nb_clic);
        pack();
    }
    public static void main(String[] args) {
        Ex7 fen = new Ex7();
    }
}