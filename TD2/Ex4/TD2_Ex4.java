import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class event_Window extends WindowAdapter{
    public void windowClosing(WindowEvent e) {
        System.out.println("Are you sure you wish to exit?");
        int rep = JOptionPane.showConfirmDialog(new JFrame(), "Tu es sur de toi ?", "Quitter ce jeu de ****", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (rep == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }
}
public class TD2_Ex4 extends JFrame implements ActionListener{
    JButton tirage ;
    JTextField case1,case2,case3,case_result ;
    JLabel result ;
    public void actionPerformed(ActionEvent e) {
        case1.setText(String.valueOf(Math.round(9*Math.random())));
        case2.setText(String.valueOf(Math.round(9*Math.random())));
        case3.setText(String.valueOf(Math.round(9*Math.random())));
        if((Integer.parseInt(case1.getText())+Integer.parseInt(case2.getText())+Integer.parseInt(case3.getText()))==16){
            case_result.setText("Gagné");
        }else{
            case_result.setText("Perdu");
        }
    }
    TD2_Ex4(){
        setTitle("JEU 3 nbs");
        setBounds(400,200,502,250);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.CENTER));
        tirage = new JButton("tirage");
        result = new JLabel("Résultat :");
        case1 = new JTextField(4);
        case2 = new JTextField(4);
        case3 = new JTextField(4);
        case_result = new JTextField(7);
        add(case1);
        add(case2);
        add(case3);
        add(tirage);
        add(result);
        add(case_result);
        tirage.addActionListener(this);
        addWindowListener(new event_Window());
        pack();
    }
    public static void main(String[] args) {
        TD2_Ex4 fen = new TD2_Ex4();
    }
}
