import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Ex5 extends JFrame implements ActionListener{
    JButton button1,button2 ;
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Bouton 1")){
                JOptionPane.showMessageDialog(this,"Bouton 1");
        }else{
                JOptionPane.showMessageDialog(this,"Bouton 2");
        }
    }
    Ex5(){
        setTitle("Yes");
        setBounds(400,200,502,250);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.CENTER,50,50));
        button1 = new JButton("Bouton 1");
        button2 = new JButton("Bouton 2");
        button1.addActionListener(this);
        button2.addActionListener(this);
        add(button1);
        add(button2);
        pack();
    }
    public static void main(String[] args) {
        Ex5 fen = new Ex5();
    }
}
