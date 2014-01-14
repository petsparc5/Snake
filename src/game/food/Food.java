package game.food;

import game.coordinate.Point;
import game.snake.Snake;

import java.util.List;
import java.util.Random;

public class Food {

    Point food;
    Random random = new Random();
    Snake snakeClass;
    int counter = 0;

    public Food(Snake snake) {
        super();
        this.snakeClass = snake;
        this.generateFoodAtRandomPlaceForTheFirstTime();
    }

    private void generateFoodAtRandomPlaceForTheFirstTime() {
        food = new Point(2 + random.nextInt(46), 2 + random.nextInt(26));
    }

    public void generateFoodAtRandomPlace() {
        counter++;
        int x = 2 + random.nextInt(46);
        int y = 2 + random.nextInt(26);
        food = new Point(x, y);
        if (isOnTheSnake()) {
            counter--;
            generateFoodAtRandomPlace();
        }
    }

    private boolean isOnTheSnake() {
        List<Point> snake = snakeClass.getSnake();
        boolean answer = false;
        for (Point point : snake) {
            answer |= food.equals(point);
        }
        return answer;
    }

    public Point getFood() {
        return food;
    }
    
    public int getCounter() {
        return counter;
    }

}
