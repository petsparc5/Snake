package listerner;

import game.Progression;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import score.FileReader;
import score.ScoreDisplayer;
import score.Winner;

public class MainListener implements ActionListener {

    private Progression progression;
    private JPanel playground;

    public MainListener(Progression progression, JPanel playground) {
        super();
        this.progression = progression;
        this.playground = playground;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        if (actionCommand.equals("New Game (F2)")) {
            progression.newGame();
        }
        if (actionCommand.equals("Highscores")) {
            FileReader fileReader = new FileReader();
            ArrayList<Winner> listOfWinners = fileReader.getListOfWinners();
            ScoreDisplayer displayer = new ScoreDisplayer(listOfWinners);
            displayer.toplistafrissites();
            JOptionPane.showMessageDialog(playground, displayer.getScrollPane());
        }
        if (actionCommand.equals("Exit (ALT+F4)")) {
            System.exit(0);
        }
    }

}
