package utility;

public class Coord {
    int _x;
    int _y;

    public Coord(int x, int y) {
        this._x = x;
        this._y = y;
    }

    public int getY() {
        return this._y;
    }

    public int getX() {
        return this._x;
    }

    public boolean equals(Coord toCompare) {
        if ((toCompare.getX() == getX()) && (toCompare.getY() == getY())) {
            return true;
        }
        return false;
    }
}


/* Location:              /Users/danecarlson/Desktop/futurejava/!/items/Coord.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */