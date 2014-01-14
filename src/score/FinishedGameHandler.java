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
        // A p�lya t�rl�se a k�perny�r�l.
        //frame.remove(playground);

        ArrayList<Winner> lista2 = listOfGameWinners;
        Winner toplist = lista2.get(9);
        if (score > toplist.getScore()) {
            handleNewScore();
            // Ha az eredm�ny nincs bent a legjobb 10-be
        } else {
            handleNoVictory();
        }
        // Szerializ�l�s
        writer.write();
    }

    private void handleNoVictory() {
        frame.setVisible(true);
        frame.repaint();
        JLabel nemnyert1 = new JLabel("A j�t�knak v�ge!");
        JLabel nemnyert2 = new JLabel("Sajnos nem ker�lt be az eredm�nyed a legjobb 10-be. Pr�b�lkozz �jra (F2).");
        nemnyert1.setForeground(Color.BLACK);
        nemnyert2.setForeground(Color.BLACK);
        top.removeAll();
        top.add(nemnyert1);
        top.add(nemnyert2);

        // A toplista friss�t�se �s a top panel hozz�ad�sa az ablakhoz
        scoreDisplayer.toplistafrissites();
        frame.add(top, BorderLayout.CENTER);
        frame.repaint();
        frame.setVisible(true);
    }

    private void handleNewScore() {
        // Egy ArrayList l�trehoz�sa, mely a megadott nevet t�rolja
        final ArrayList<String> holder = new ArrayList<String>();

        // A ki�r�sok �s a sz�vegmez� l�trehoz�sa
        JLabel nyert1 = new JLabel("A j�t�knak v�ge!");
        JLabel nyert2 = new JLabel("Gratul�lok! Felker�lt�l a toplist�ra. K�rlek add meg a neved (max 10 bet�):");
        final JTextField newWinner = new JTextField(10);

        // Ezek hozz�ad�sa a top panelhez
        top.removeAll();
        top.add(nyert1);
        top.add(nyert2);
        top.add(newWinner);

        // A sz�vegmez� tartalm�nak hozz�sad�sa a holderhez
        ScoreUpdateListener scoreUpdateListener = new ScoreUpdateListener(newWinner, frame);
        scoreUpdateListener.setHolder(holder);
        newWinner.addActionListener(scoreUpdateListener);

        // A top panel hozz�ad�sa az ablakhoz, �s az ablak �jrarajzol�sa
        frame.add(top, BorderLayout.CENTER);
        frame.repaint();
        frame.setVisible(true);
        

        // V�rakoz�s a sz�vegez� kit�lt�s�ig
        synchronized (holder) {
            while (holder.isEmpty())
                try {
                    holder.wait();
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
        }

        // A lista utols� elem�nek kicser�l�se az �j listaelemmel �s a lista
        // sorbarendez�se
        listOfGameWinners.remove(9);
        listOfGameWinners.add(new Winner(holder.remove(0), score));
        Collections.sort(listOfGameWinners);

        // A toplista friss�t�se, �s kirajzol�sa az ablakra
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
