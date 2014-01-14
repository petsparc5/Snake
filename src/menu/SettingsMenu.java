package menu;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import listerner.LevelListener;
import domain.Runner;

public class SettingsMenu {

    private JMenu jMenu = new JMenu("Settings");
    private Runner runner;

    public SettingsMenu(Runner runner) {
        super();
        this.runner = runner;
    }

    public JMenu createMenu() {
        addLevel("Hard");
        jMenu.addSeparator();
        addLevel("Medium");
        jMenu.addSeparator();
        addLevel("Easy");
        return jMenu;
    }

    private void addLevel(String difficulty) {
        JMenuItem item = new JMenuItem(difficulty);
        item.addActionListener(new LevelListener(runner));
        item.setActionCommand(difficulty);
        jMenu.add(item);
    }
    
    

}
