package menu;

import game.Progression;

import javax.swing.JMenuBar;
import javax.swing.JPanel;

import domain.Runner;

public class MenuBarCreator {

    private JMenuBar bar = new JMenuBar();
    private Progression progression;
    private JPanel playground;
    private Runner runner;

    public MenuBarCreator(Progression progression, JPanel playground, Runner runner) {
        super();
        this.progression = progression;
        this.playground = playground;
        this.runner = runner;
    }

    public JMenuBar createMenuBar() {

        MainMenu mainMenu = new MainMenu(progression, playground);
        SettingsMenu settingsMenu = new SettingsMenu(runner);
        HelpMenu helpMenu = new HelpMenu(playground);

        bar.add(mainMenu.createMenu());
        bar.add(settingsMenu.createMenu());
        bar.add(helpMenu.createMenu());

        return bar;
    }

}
