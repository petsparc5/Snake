package domain;

import exception.IllegalStepException;
import game.Progression;
import game.food.Food;
import game.snake.SnakeDisplayer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import score.FinishedGameHandler;

public class Runner implements Runnable {
    
    int unit = 10;
    int fieldWidth = 50 * unit;
    int fieldHeight = 30 * unit;

    int score;
    private int displayDelay = 70;
    private Progression progression;
    private FinishedGameHandler finishedGameHandler;

    public Runner(Progression progression, FinishedGameHandler finishedGameHandler) {
        super();
        this.progression = progression;
        this.finishedGameHandler = finishedGameHandler;
    }

    private boolean hasGameEnded = false;
    private SnakeDisplayer displayer;
    private JPanel playground;
    private JLabel pointDisplay;
    public void setPointDisplay(JLabel pointDisplay) {
        this.pointDisplay = pointDisplay;
    }

    private JFrame frame;

    @Override
    public void run() {
        hasGameEnded = false;
        Food food = progression.getFood();
        if(displayer != null) {
        displayer.resetAll();
        }
        displayer = new SnakeDisplayer(playground, progression.getSnake(), food);
        while (!hasGameEnded) {
            score = food.getCounter() * 5;
            pointDisplay.setText("Pontszám: " + score);
            try {
                displayer.elsoSnake();
                frame.repaint();
                frame.setVisible(true);
                progression.step();
                Thread.sleep(displayDelay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (IllegalStepException e) {
                hasGameEnded = true;
                playground.removeAll();
                finishedGameHandler.setUp();
                finishedGameHandler.setScore(score);
                finishedGameHandler.toplistabatesz();

            }
        }
    }
    
    public void reset() {
        
        JPanel[] perimeter = new JPanel[4];
        
        perimeter[0] = new JPanel();
        perimeter[0].setBounds(0, 0, fieldWidth, unit);
        perimeter[1] = new JPanel();
        perimeter[1].setBounds(0, 0, unit, fieldHeight);
        perimeter[2] = new JPanel();
        perimeter[2].setBounds(0, fieldHeight - unit, fieldWidth, unit);
        perimeter[3] = new JPanel();
        perimeter[3].setBounds(fieldWidth - unit, 0, unit, fieldHeight);
        
        score = 0;
        playground.removeAll();
        
        playground.add(perimeter[0]);
        playground.add(perimeter[1]);
        playground.add(perimeter[2]);
        playground.add(perimeter[3]);
        
    }

    public void setDisplayDelay(int displayDelay) {
        this.displayDelay = displayDelay;
    }

    public void setPlayground(JPanel playground) {
        this.playground = playground;
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public int getScore() {
        return score;
    }
}
