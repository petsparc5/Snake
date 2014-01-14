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
            JOptionPane.showMessageDialog(playground, "K�sz�t�: K�rlek Refaktor�lj\n" + "Programn�v: Snake\n" + "Verzi�sz�m: v0.7");
        }
        if (actionCommand.equals("Creator")) {
            JOptionPane.showMessageDialog(playground, "Ir�ny�t�s a kurzor seg�ts�g�vel:\n" + "-Fel ny�l: a k�gy� felfele mozog\n"
                    + "-Le ny�l: a k�gy� lefele mozog\n" + "-Jobbra ny�l: a k�gy� jobbra mozog\n" + "-Balra ny�l: a k�gy� balra mozog\n");
        }

    }
    
    

}
