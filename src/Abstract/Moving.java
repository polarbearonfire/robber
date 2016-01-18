package Abstract;

import enums.Direction;

import java.awt.*;
import java.util.Queue;

public abstract class Moving extends Drawable {
    public double _speed;
    protected Direction _xDir, _yDir;
    public double _rotationSpeed;
    protected Queue<String> _walkingImagePaths;
    protected int INCREMENT_LIMIT = 10;
    protected int MOVE_IMAGE_LIMIT = 500;
    protected long _lastTimeMoved = 0;
    protected long _lastTimeImageChanged = 0;

    public void increment() {
        if (System.currentTimeMillis() - _lastTimeMoved > INCREMENT_LIMIT) {

            //move
            if (_isRotatingCounterClockwise) {
                rotationIncrement();
            }
            if (_isRotatingClockwise) {
                rotationDecrement();
            }
            if (_xDir == Direction.RIGHT) {
                _x += _speed;
            } else if (_xDir == Direction.LEFT) {
                _x -= _speed;
            }
            if (_yDir == Direction.UP) {
                _y -= _speed;
            } else if (_yDir == Direction.DOWN) {
                _y += _speed;
            }

            //step
            if (isMoving() && System.currentTimeMillis() - _lastTimeImageChanged > MOVE_IMAGE_LIMIT) {
                nextImage();
                _lastTimeImageChanged = System.currentTimeMillis();
            }
            _lastTimeMoved = System.currentTimeMillis();
        }

    }


    public void nextImage() {
        if (this._walkingImagePaths != null) {
            String next = this._walkingImagePaths.remove();
            this._image = initImage(next);
            this._walkingImagePaths.add(next);
        }
    }


    public boolean isMoving() {
        if (_yDir != Direction.NONE || _xDir != Direction.NONE && _speed > 0) {
            return true;
        }
        return false;
    }


    public boolean colliding(Moving other) {
        Rectangle thisRect = new Rectangle(
                (int) getX(),
                (int) getY(),
                getWidth(),
                getHeight());
        Rectangle otherRect = new Rectangle(
                (int) other.getX(),
                (int) other.getY(),
                other.getWidth(),
                other.getHeight());
        if (thisRect.getBounds().intersects(otherRect)) {
            return true;
        }


        return false;
    }

    public void hitByBullet() {

    }

    public boolean _isRotatingClockwise;


    public void rotationDecrement() {
        _rotation -= _rotationSpeed;
        if (_rotation < 0.0)
            _rotation = 359.9;
    }


    public void rotationIncrement() {
        _rotation += _rotationSpeed;
        if (_rotation >= 360) {
            _rotation = 0;
        }
    }


    public double getSpeed() {
        return _speed;
    }

    public Direction getXDirection() {
        return _xDir;
    }

    public Direction getYDirection() {
        return _yDir;
    }


    //setters
    public void setRotateC(boolean whether) {
        _isRotatingClockwise = whether;
        if (whether) {
            _isRotatingCounterClockwise = false;
        }
    }


    public void setRotateCC(boolean whether) {
        _isRotatingCounterClockwise = whether;
        if (whether) {
            _isRotatingClockwise = false;
        }
    }


    public void setYDir(Direction which) {
        _yDir = which;
    }


    public void setXDir(Direction which) {
        _xDir = which;
    }


    public void setImage(java.awt.Image newImg) {
        _image = newImg;
    }

}
