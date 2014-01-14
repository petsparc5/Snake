package game;

import exception.IllegalStepException;
import game.coordinate.Point;
import game.enums.Direction;
import game.food.Food;
import game.snake.Snake;

public class Progression {

    public Food getFood() {
        return food;
    }

    Snake snake = new Snake();
    Food food = new Food(snake);
    Direction directionTheSnakeIsHeaded = Direction.getDefaultDirection();

    public void step() throws IllegalStepException {
        if (hitWall() || snake.hasOverlapped()) {
            throw new IllegalStepException();
        }
        move();
    }

    private boolean hitWall() {
        Point pointInFrontOfSnake = snake.getPositionInFront(directionTheSnakeIsHeaded);
        int x = pointInFrontOfSnake.getX();
        int y = pointInFrontOfSnake.getY();
        return x == 0 || x == 49 || y == 0 || y == 29;
    }

    private void move() {
        if (isAboutToEat()) {
            snake.eat(food.getFood());
            food.generateFoodAtRandomPlace();
        } else {
            snake.move(directionTheSnakeIsHeaded);
        }
    }

    public void changeDirection(Direction direction) {
        Direction directionSnakeCannotMove = Direction.getOppositeDirection(directionTheSnakeIsHeaded);
        if (!direction.equals(directionSnakeCannotMove)) {    
            directionTheSnakeIsHeaded = direction;
        }
    }

    private boolean isAboutToEat() {
        Point pointInFrontOfSnake = snake.getPositionInFront(directionTheSnakeIsHeaded);
        Point pointWhereFoodIs = food.getFood();
        return pointInFrontOfSnake.equals(pointWhereFoodIs);
    }

    public Snake getSnake() {
        return snake;
    }
    
    public void newGame() {
        snake = new Snake();
        food = new Food(snake);
        directionTheSnakeIsHeaded = Direction.getDefaultDirection();
    }

}
