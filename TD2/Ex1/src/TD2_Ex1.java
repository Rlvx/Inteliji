import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class TD2_Ex1 extends JFrame implements ActionListener{
    JButton button_copy ;
    JTextField champ ;
    JLabel result ;
    public void actionPerformed(ActionEvent e) {
        result.setText(champ.getText());
    }
    TD2_Ex1(){
        setTitle("Yes");
        setBounds(400,200,502,250);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        button_copy = new JButton("Copier");
        champ = new JTextField();
        result = new JLabel("rien");
        button_copy.addActionListener(this);
        add(button_copy,BorderLayout.NORTH);
        add(champ,BorderLayout.CENTER);
        add(result,BorderLayout.SOUTH);

        pack();
    }
    public static void main(String[] args) {
        TD2_Ex1 fen = new TD2_Ex1();
    }
}
