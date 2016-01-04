package Objects;

import java.awt.Image;

import Abstract.Moving;

public class Bullet
        extends Moving {
    double _rise;
    double _run;
    boolean _hasHitObject;


    public Bullet(int x, int y, double rise, double run, int width, int height, Image img) {
        _x = x;
        _y = y;
        _width = width;
        _height = height;
        _image = img;
        _rise = rise;
        _run = run;
    }

    public boolean hasHitObject() {
        return _hasHitObject;
    }


    @Override
    public void increment() {
        if (System.currentTimeMillis() - _lastTimeMoved > INCREMENT_LIMIT) {
            _x += _run;
            _y += _rise;
            _lastTimeMoved = System.currentTimeMillis();
        }
    }

    @Override
    public boolean colliding(Moving other) {
        if (super.colliding(other)) {
            _hasHitObject = true;
            other.hitByBullet();
            return true;
        }
        return false;
    }
}
