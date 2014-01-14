package listerner;

import game.Progression;
import game.enums.Direction;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import domain.Runner;

public class MovementListener implements KeyListener {

    Progression progression;
    Runner runner;

    public MovementListener(Progression progression, Runner runner) {
        super();
        this.progression = progression;
        this.runner = runner;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 37) {
            progression.changeDirection(Direction.LEFT);
        }
        if (e.getKeyCode() == 38) {
            progression.changeDirection(Direction.UP);
        }
        if (e.getKeyCode() == 39) {
            progression.changeDirection(Direction.RIGHT);
        }
        if (e.getKeyCode() == 40) {
            progression.changeDirection(Direction.DOWN);
        }
        if (e.getKeyCode() == 113) {
            progression.newGame();
            runner.run();
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
