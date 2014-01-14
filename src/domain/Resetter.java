package domain;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Resetter {
    
    private JFrame frame;
    private JPanel playground;
    private JPanel[] perimeter;
    private JLabel pointDisplay;
    private int points;
    
    void reset() {
        // Az �rt�kek kezdeti helyzetbe �ll�t�sa
        //init();

        // A p�lya lepucol�sa
        playground.removeAll();
        //scrollpane.removeAll();

        // Ha az el�z� j�t�kban meghalt a k�gy�, akkor a j�t�k v�ge kijelz�
        // t�rl�se az ablakb�l
/*        if (gameover == true) {
            frame.remove(top);
        }*/

        // A keret hozz�ad�sa a p�ly�hoz
        playground.add(perimeter[0]);
        playground.add(perimeter[1]);
        playground.add(perimeter[2]);
        playground.add(perimeter[3]);

        // Az els� k�gy� l�trehoz�sa, kirajzol�sa
        //elsoSnake();

        // A p�lya hozz�ad�sa az ablakhoz, annak �jrarajzol�sa �s a pontsz�m
        // ki�r�sa
        frame.add(playground, BorderLayout.CENTER);
        frame.repaint();
        frame.setVisible(true);
        pointDisplay.setText("Pontsz�m: " + points);

        // A mozgat�s elind�t�sa
        //start();
    }

}
