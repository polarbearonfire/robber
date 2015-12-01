package Moving;

import java.awt.Image;
import Interface.MovingObject;

public class Bullet
        extends MovingObject {
    double _rise;
    double _run;


    public Bullet(int x, int y, double rise, double run, int width, int height, Image img) {
        _xCoord = x;
        _yCoord = y;
        _width = width;
        _height = height;
        _image = img;
        _rise = rise;
        _run = run;
    }


    @Override
    public void increment() {
        _xCoord += _run;
        _yCoord += _rise;
    }
}


/* Location:              /Users/danecarlson/Desktop/futurejava/!/items/Bullet.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */