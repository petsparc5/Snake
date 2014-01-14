package game.snake;

import game.coordinate.Point;
import game.enums.Direction;

import java.util.ArrayList;
import java.util.List;

public class Snake {

    List<Point> snake = new ArrayList<>();

    public Snake() {
        super();
        generateFirstSnake();
    }

    private void generateFirstSnake() {
        snake.add(new Point(22, 14));
        snake.add(new Point(23, 14));
        snake.add(new Point(24, 14));
        snake.add(new Point(25, 14));
    }

    public void eat(Point point) {
        snake.add(point);
    }

    public void move(Direction directionTheSnakeIsHeaded) {
        Point nextPoint = getPositionInFront(directionTheSnakeIsHeaded);
        snake.add(nextPoint);
        snake.remove(0);
    }

    public boolean hasOverlapped() {
        boolean answer = false;
        int lastElementPosition = getLastElemetsPosition();
        Point lastPoint = snake.get(lastElementPosition);
        for (int i = 0; i < lastElementPosition; i++) {
            answer |= lastPoint.equals(snake.get(i));
        }
        return answer;
    }

    public Point getPositionInFront(Direction directionTheSnakeIsHeaded) {
        Point lastElement = snake.get(getLastElemetsPosition());
        return lastElement.getNeighbour(directionTheSnakeIsHeaded);
    }

    private int getLastElemetsPosition() {
        return snake.size() - 1;
    }

    public List<Point> getSnake() {
        return snake;
    }

}
