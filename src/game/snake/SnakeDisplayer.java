package game.snake;

import game.coordinate.Point;
import game.food.Food;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;

public class SnakeDisplayer {

    private static final int UNITSIZE = 10;
    private Snake snakeClass;
    List<Point> snake;
    private List<JButton> field = new ArrayList<>();
    private JPanel playground;
    private Food food;

    public SnakeDisplayer(JPanel playground, Snake snakeClass, Food food) {
        super();
        this.playground = playground;
        this.snakeClass = snakeClass;
        this.food = food;
    }

    public void elsoSnake() {
        snake = snakeClass.getSnake();
        resetAll();
        displayFood();
        for (int i = 0; i < snake.size(); i++) {
            JButton current = new JButton();
            field.add(current);
            current.setEnabled(false);
            Point point = snake.get(i);
            current.setBounds(point.getX() * UNITSIZE, point.getY() * UNITSIZE, UNITSIZE, UNITSIZE);
            current.setBackground(Color.BLACK);
            
            playground.add(current);

        }
    }
    
    public void displayFood() {
        Point foodLocation = food.getFood();
        JButton current = new JButton();
        field.add(current);
        current.setEnabled(false);
        current.setBounds(foodLocation.getX() * UNITSIZE, foodLocation.getY() * UNITSIZE, UNITSIZE, UNITSIZE);
        current.setBackground(Color.RED);
        playground.add(current);
    }
    
    public void resetAll() {
        for (JButton button : field) {
            playground.remove(button);
        }
        field.clear();
    }

}
