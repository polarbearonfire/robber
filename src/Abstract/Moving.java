package Abstract;

import enums.Direction;

import java.awt.*;
import java.util.Queue;
import java.util.Vector;

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
                _xCoord += _speed;
            } else if (_xDir == Direction.LEFT) {
                _xCoord -= _speed;
            }
            if (_yDir == Direction.UP) {
                _yCoord -= _speed;
            } else if (_yDir == Direction.DOWN) {
                _yCoord += _speed;
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
        if (_yDir != Direction.NONE || _xDir != Direction.NONE) {
            return true;
        }
        return false;
    }


    public boolean colliding(Vector<Human> bounds) {
        Rectangle pRect = new Rectangle((int) getX(), (int) getY(), getWidth(), getHeight());
        for (Drawable mo : bounds) {
            Rectangle bound = new Rectangle((int) mo.getX(), (int) mo.getY(), mo.getWidth(), mo.getHeight());
            if (pRect.getBounds().intersects(bound)) {
                return true;
            }
        }
        return false;
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


    public Direction getOppositeXDirection() {
        if (isLeft()) {
            return Direction.RIGHT;
        } else if (isRight()) {
            return Direction.LEFT;
        } else {
            return Direction.NONE;
        }
    }

    public Direction getOppositeYDirection() {
        if (isUp()) {
            return Direction.DOWN;
        } else if (isDown()) {
            return Direction.UP;
        } else {
            return Direction.NONE;
        }
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


    public boolean isRight() {
        return _xDir == Direction.RIGHT;
    }

    public boolean isLeft() {
        return _xDir == Direction.LEFT;
    }

    public boolean isDown() {
        return _yDir == Direction.DOWN;
    }

    public boolean isUp() {
        return _yDir == Direction.UP;
    }

}
