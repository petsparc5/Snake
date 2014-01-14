package listerner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HelpListener implements ActionListener {
    
    private JPanel playground;

    public HelpListener(JPanel playground) {
        super();
        this.playground = playground;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        if (actionCommand.equals("Navigation")) {
            JOptionPane.showMessageDialog(playground, "Készítõ: Kérlek Refaktorálj\n" + "Programnév: Snake\n" + "Verziószám: v0.7");
        }
        if (actionCommand.equals("Creator")) {
            JOptionPane.showMessageDialog(playground, "Irányítás a kurzor segítségével:\n" + "-Fel nyíl: a kígyó felfele mozog\n"
                    + "-Le nyíl: a kígyó lefele mozog\n" + "-Jobbra nyíl: a kígyó jobbra mozog\n" + "-Balra nyíl: a kígyó balra mozog\n");
        }

    }
    
    

}
