package game.enums;

public enum Direction {
    
    UP,DOWN,LEFT,RIGHT;
    
    public static Direction getOppositeDirection(Direction direction) {
        switch(direction) {
        case UP:
            return DOWN;
        case DOWN:
            return UP;
        case LEFT:
            return RIGHT;
        case RIGHT:
            return LEFT;
        }
        return getDefaultDirection();
    }

    public static Direction getDefaultDirection() {
        return RIGHT;
    }

}
