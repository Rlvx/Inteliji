import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ex5 extends JFrame{
    JButton button1,button2 ;
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
    class evenement_Clic implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==button1){
                JOptionPane.showMessageDialog(new JFrame(),"Bouton 1");
            }else{
                JOptionPane.showMessageDialog(new JFrame(),"Bouton 2");
            }
        }
    }
    Ex5(){
        Fenetres ma_fenetre = new Fenetres("Test");
        ma_fenetre.fen.setLayout(new FlowLayout(FlowLayout.CENTER,50,50));
        button1 = new JButton("Bouton 1");
        button2 = new JButton("Bouton 2");
        button1.addActionListener(new evenement_Clic());
        button2.addActionListener(new evenement_Clic());
        ma_fenetre.fen.add(button1);
        ma_fenetre.fen.add(button2);
        pack();
    }
    public static void main(String[] args) {
        Ex5 fen = new Ex5();
    }
}
