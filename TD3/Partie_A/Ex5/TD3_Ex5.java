import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class TD3_Ex5 extends JFrame implements ActionListener {
    JLabel label ;
    JTextArea texte ;
    JButton button ;
    String path = "C:\\Users\\Rom\\Documents\\Inteliji\\TD3\\Partie_A\\Ex5\\texte";
    BufferedWriter writer;
    class enregistrement extends KeyAdapter{
        public void keyPressed(KeyEvent e) {
            try {
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                    writer.newLine();
                }else{
                    writer.write(e.getKeyChar());
                }
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
    public void actionPerformed(ActionEvent e) {
        if(button.getText()=="Terminer"){
            JOptionPane.showMessageDialog(this,"Vous avez fini d'enregistrer !");
            button.setText("Démarrer");
            try {
                writer.close();
                texte.setEnabled(false);
                texte.setText("");
            } catch (IOException ioException) {
                JOptionPane.showMessageDialog(this,"Une erreur est survenu !");
            }
        }else{
            JOptionPane.showMessageDialog(this,"Vous commencez a enregistrer !");
            button.setText("Terminer");
            try{
                writer = new BufferedWriter(new FileWriter(path));
                texte.setEnabled(true);
            }catch (IOException ioException) {
                JOptionPane.showMessageDialog(this,"Pas de fichier trouvé !");

            }
        }
    }
    TD3_Ex5(){
        setBounds(50,50,450,250);
        setTitle("Copieur");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        label = new JLabel("Entrez du texte :");
        texte = new JTextArea();
        button = new JButton("Démarrer");
        texte.setEnabled(false);
        add(label, BorderLayout.NORTH);
        add(texte,BorderLayout.CENTER);
        add(button,BorderLayout.SOUTH);
        button.addActionListener(this);
        texte.addKeyListener(new enregistrement());
        setVisible(true);

    }
    public static void main(String[] args) {
        TD3_Ex5 fen = new TD3_Ex5();
    }
}