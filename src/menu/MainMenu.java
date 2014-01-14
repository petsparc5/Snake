package menu;

import game.Progression;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import listerner.MainListener;

public class MainMenu {

    private JMenu jMenu = new JMenu("Main Menu");
    private Progression progression;
    private JPanel playground;

    public MainMenu(Progression progression, JPanel playground) {
        super();
        this.progression = progression;
        this.playground = playground;
    }

    public JMenu createMenu() {
        addLevel("New Game (F2)");
        jMenu.addSeparator();
        addLevel("Highscores");
        jMenu.addSeparator();
        addLevel("Exit (ALT+F4)");
        return jMenu;
    }

    private void addLevel(String difficulty) {
        JMenuItem item = new JMenuItem(difficulty);
        item.addActionListener(new MainListener(progression, playground));
        item.setActionCommand(difficulty);
        jMenu.add(item);
    }

}
