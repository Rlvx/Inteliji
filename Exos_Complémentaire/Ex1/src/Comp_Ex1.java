import javax.swing.*;
import java.awt.event.*;
public class Comp_Ex1 extends JFrame implements MouseListener{
    Comp_Ex1(){
        setTitle("Yes");
        setBounds(400,200,502,250);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        addMouseListener(this);
    }
    public static void main(String[] args) {
        Comp_Ex1 fen = new Comp_Ex1();
    }
    public void mousePressed(MouseEvent e) {
        System.out.println("---mousePressed--- \nX : "+e.getX()+"\n"+"Y : "+e.getY());
    }
    public void mouseReleased(MouseEvent e) {
        System.out.println("---mouseReleased--- \nX : "+e.getX()+"\n"+"Y : "+e.getY());
    }
    public void mouseEntered(MouseEvent e) {

    }
    public void mouseExited(MouseEvent e) {

    }
    public void mouseClicked(MouseEvent e) {

    }
}
