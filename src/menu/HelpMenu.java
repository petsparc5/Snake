package menu;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import listerner.HelpListener;

public class HelpMenu {

    private JMenu jMenu = new JMenu("Help");
    private JPanel playground;

    public HelpMenu(JPanel playground) {
        super();
        this.playground = playground;
    }

    public JMenu createMenu() {
        addLevel("Navigation");
        jMenu.addSeparator();
        addLevel("Creator");
        return jMenu;
    }

    private void addLevel(String difficulty) {
        JMenuItem item = new JMenuItem(difficulty);
        item.addActionListener(new HelpListener(playground));
        item.setActionCommand(difficulty);
        jMenu.add(item);
    }

}
