import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
public class TD2_Ex5 extends JFrame{
    JPopupMenu couleur = new JPopupMenu();
    ArrayList<JMenuItem> list_items = new ArrayList<>();

    class event_Clic extends MouseAdapter{
        public void mousePressed(MouseEvent e) {
            if (e.isPopupTrigger()) {
                couleur.show(e.getComponent(), e.getX(), e.getY());
            }
        }
        public void mouseReleased(MouseEvent e) {
            if (e.isPopupTrigger()){
                couleur.show(e.getComponent(), e.getX(), e.getY());
            }
        }
    }

    TD2_Ex5() {
        setTitle("Menu surgissant");
        setBounds(400, 200, 502, 250);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        addMouseListener(new event_Clic());
        list_items.add(new JMenuItem("Vert"));
        list_items.add(new JMenuItem("Rouge"));
        for(JMenuItem item : list_items){
            couleur.add(item);
        }
    }

    public static void main(String[] args) {
        TD2_Ex5 fen = new TD2_Ex5();
    }
}
