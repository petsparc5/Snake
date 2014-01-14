package listerner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import domain.Runner;

public class LevelListener implements ActionListener {

    private Runner runner;

    public LevelListener(Runner runner) {
        super();
        this.runner = runner;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        if (actionCommand.equals("Hard")){
            runner.setDisplayDelay(50);
        }
        if (actionCommand.equals("Medium")){
            runner.setDisplayDelay(70);
        }
        if (actionCommand.equals("Easy")){
            runner.setDisplayDelay(90);
        }

    }

}
