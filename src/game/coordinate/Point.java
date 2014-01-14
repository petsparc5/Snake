package game.coordinate;

import game.enums.Direction;

public class Point {

    int x;
    int y;

    public Point(int x, int y) {
        super();
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + x;
        result = prime * result + y;
        return result;
    }

    public Point getNeighbour(Direction direction) {
        switch (direction) {
        case UP:
            return new Point(x, y - 1);
        case DOWN:
            return new Point(x, y + 1);
        case LEFT:
            return new Point(x - 1, y);
        case RIGHT:
            return new Point(x + 1, y);
        }
        return new Point(x, y);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Point other = (Point) obj;
        if (x != other.x)
            return false;
        if (y != other.y)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Point x=" + x + ", y=" + y;
    }
    
    

}
