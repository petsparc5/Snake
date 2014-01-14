package score;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import listerner.ScoreUpdateListener;

public class FinishedGameHandler {

    private ArrayList<Winner> listOfGameWinners;
    private  JPanel top;
    private JFrame frame;
    private int score;
    private FileReader data = new FileReader();
    private FileWriter writer;
    private ScoreDisplayer scoreDisplayer;

    public FinishedGameHandler(JPanel top, JFrame frame) {
        super();
        this.top = top;
        this.frame = frame;
    }
    
    public void setUp() {
        listOfGameWinners = data.getListOfWinners();
        writer = new FileWriter(listOfGameWinners);
        scoreDisplayer = new ScoreDisplayer(listOfGameWinners);
    }

    public boolean checkIfThereIsANewWinner() {
        Winner tenthWinner = listOfGameWinners.get(9);
        return score > tenthWinner.getScore();
    }

    public void toplistabatesz() {
        // A pálya törlése a képernyõrõl.
        //frame.remove(playground);

        ArrayList<Winner> lista2 = listOfGameWinners;
        Winner toplist = lista2.get(9);
        if (score > toplist.getScore()) {
            handleNewScore();
            // Ha az eredmény nincs bent a legjobb 10-be
        } else {
            handleNoVictory();
        }
        // Szerializálás
        writer.write();
    }

    private void handleNoVictory() {
        frame.setVisible(true);
        frame.repaint();
        JLabel nemnyert1 = new JLabel("A játéknak vége!");
        JLabel nemnyert2 = new JLabel("Sajnos nem került be az eredményed a legjobb 10-be. Próbálkozz újra (F2).");
        nemnyert1.setForeground(Color.BLACK);
        nemnyert2.setForeground(Color.BLACK);
        top.removeAll();
        top.add(nemnyert1);
        top.add(nemnyert2);

        // A toplista frissítése és a top panel hozzáadása az ablakhoz
        scoreDisplayer.toplistafrissites();
        frame.add(top, BorderLayout.CENTER);
        frame.repaint();
        frame.setVisible(true);
    }

    private void handleNewScore() {
        // Egy ArrayList létrehozása, mely a megadott nevet tárolja
        final ArrayList<String> holder = new ArrayList<String>();

        // A kiírások és a szövegmezõ létrehozása
        JLabel nyert1 = new JLabel("A játéknak vége!");
        JLabel nyert2 = new JLabel("Gratulálok! Felkerültél a toplistára. Kérlek add meg a neved (max 10 betû):");
        final JTextField newWinner = new JTextField(10);

        // Ezek hozzáadása a top panelhez
        top.removeAll();
        top.add(nyert1);
        top.add(nyert2);
        top.add(newWinner);

        // A szövegmezõ tartalmának hozzásadása a holderhez
        ScoreUpdateListener scoreUpdateListener = new ScoreUpdateListener(newWinner, frame);
        scoreUpdateListener.setHolder(holder);
        newWinner.addActionListener(scoreUpdateListener);

        // A top panel hozzáadása az ablakhoz, és az ablak újrarajzolása
        frame.add(top, BorderLayout.CENTER);
        frame.repaint();
        frame.setVisible(true);
        

        // Várakozás a szövegezõ kitöltéséig
        synchronized (holder) {
            while (holder.isEmpty())
                try {
                    holder.wait();
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
        }

        // A lista utolsó elemének kicserélése az új listaelemmel és a lista
        // sorbarendezése
        listOfGameWinners.remove(9);
        listOfGameWinners.add(new Winner(holder.remove(0), score));
        Collections.sort(listOfGameWinners);

        // A toplista frissítése, és kirajzolása az ablakra
        scoreDisplayer.toplistafrissites();
        top.removeAll();
        top.add(scoreDisplayer.getScrollPane());
        top.repaint();
        frame.repaint();
        frame.setVisible(true);
        frame.repaint();
    }

    public void setScore(int score) {
        this.score = score;
    }

}
