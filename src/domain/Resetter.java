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
        // Az értékek kezdeti helyzetbe állítása
        //init();

        // A pálya lepucolása
        playground.removeAll();
        //scrollpane.removeAll();

        // Ha az elõzõ játékban meghalt a kígyó, akkor a játék vége kijelzõ
        // törlése az ablakból
/*        if (gameover == true) {
            frame.remove(top);
        }*/

        // A keret hozzáadása a pályához
        playground.add(perimeter[0]);
        playground.add(perimeter[1]);
        playground.add(perimeter[2]);
        playground.add(perimeter[3]);

        // Az elsõ kígyó létrehozása, kirajzolása
        //elsoSnake();

        // A pálya hozzáadása az ablakhoz, annak újrarajzolása és a pontszám
        // kiírása
        frame.add(playground, BorderLayout.CENTER);
        frame.repaint();
        frame.setVisible(true);
        pointDisplay.setText("Pontszám: " + points);

        // A mozgatás elindítása
        //start();
    }

}
