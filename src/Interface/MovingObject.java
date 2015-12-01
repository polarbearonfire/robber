package Interface;

import enums.Direction;

import java.awt.*;
import java.util.Queue;
import java.util.Vector;

/**
 * Created by danecarlson on 10/15/2015.
 */
public abstract class MovingObject extends DrawableObject {
    public double _speed;
    Direction _xDir, _yDir;
    public double _rotationSpeed;
    protected Queue<String> _walkingImagePaths;

    public void increment() {

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
        }
        if (_yDir == Direction.DOWN) {
            _yCoord += _speed;
        }

    }


    public void nextImage() {
        if (this._walkingImagePaths != null) {
            String next = this._walkingImagePaths.remove();
            this._image = initImage(next);
            this._walkingImagePaths.add(next);
        }
    }

    public void nextWalkingImage() {
        if (isMoving()) {
            nextImage();
        }
    }

    public boolean isMoving() {
        if (_yDir != Direction.NONE || _xDir != Direction.NONE) {
            return true;
        }
        return false;
    }



    public boolean colliding(Vector<Human> bounds) {
        Rectangle pRect = new Rectangle((int) getXCoord(), (int) getYCoord(), getWidth(), getHeight());
        for (DrawableObject mo : bounds) {
            Rectangle bound = new Rectangle((int) mo.getXCoord(), (int) mo.getYCoord(), mo.getWidth(), mo.getHeight());
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


    //getters


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
