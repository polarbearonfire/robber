package Objects;

import java.awt.Image;

import Abstract.Moving;

public class Bullet
        extends Moving {
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
        if (System.currentTimeMillis() - _lastTimeMoved > INCREMENT_LIMIT) {
            _xCoord += _run;
            _yCoord += _rise;
            _lastTimeMoved = System.currentTimeMillis();
        }
    }
}
