import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Ex10 extends JFrame implements ActionListener{
    JButton button1,button2,button3,button4,button5;
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Bouton 1")){
            JOptionPane.showMessageDialog(this,"Bouton 1");
        }else if(e.getActionCommand().equals("Bouton 2")){
            JOptionPane.showMessageDialog(this,"Bouton 2");
        }else if(e.getActionCommand().equals("Bouton 3")){
            JOptionPane.showMessageDialog(this,"Bouton 3");
        }else if(e.getActionCommand().equals("Bouton 4")){
            JOptionPane.showMessageDialog(this,"Bouton 4");
        }else{
            JOptionPane.showMessageDialog(this,"Bouton 5");
        }

    }
    Ex10(){
        setTitle("Yes");
        setBounds(400,200,502,250);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        button1 = new JButton("Bouton 1");
        button2 = new JButton("Bouton 2");
        button3 = new JButton("Bouton 3");
        button4 = new JButton("Bouton 4");
        button5 = new JButton("Bouton 5");
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);
        button5.addActionListener(this);
        add(button1,BorderLayout.CENTER);
        add(button2,BorderLayout.NORTH);
        add(button3,BorderLayout.SOUTH);
        add(button4,BorderLayout.EAST);
        add(button5,BorderLayout.WEST);
        pack();
    }
    public static void main(String[] args) {
        Ex10 fen = new Ex10();
    }
}
