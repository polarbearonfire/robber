package state;

import Interface.GuardState;
import Moving.Guard;
import NonMoving.Emotion;
import Moving.Player;

/**
 * Created by danecarlson on 9/21/2015.
 */


public class GuardFrenziedState extends GuardState {
    final int FRENZIED_TIME_SECONDS = 15000;
    final double DESIRED_SPEED = 1.5;
    final double DESIRED_ROTATION_SPEED = 2;
    long _timer;

    public GuardFrenziedState(Guard g, Player p) {

        _g = g;
        _p = p;
        _g._speed = DESIRED_SPEED;
        _g._rotationSpeed = DESIRED_ROTATION_SPEED;
        //g.setEmotion((Emotion)
        _timer = System.currentTimeMillis();

    }

    @Override
    public void increment() {
/*
        if (_g.isRight()) {
            _g._xCoord += _g._speed;
            if (_g.colliding(thingsToWatchFor)) {
                _g.setRight(false);
                _g._xCoord -= _g._speed;
            }
        } else if (_g.isLeft()) {
            _g._xCoord -= _g._speed;
            if (_g.colliding(thingsToWatchFor)) {
                _g.setLeft(false);
                _g._xCoord += _g._speed;
            }
        }
        if (_g.isUp()) {
            _g._yCoord -= _g._speed;
            if (_g.colliding(thingsToWatchFor)) {
                _g.setUp(false);
                _g._yCoord += _g._speed;
            }
        } else if (_g.isDown()) {
            _g._yCoord += _g._speed;
            if (_g.colliding(thingsToWatchFor)) {
                _g.setDown(false);
                _g._yCoord -= _g._speed;
            }
        }

        double rotation = MyMath.findAngleOfTwoPoints(new Coord((int) _g.getXCoord(), (int) _g.getYCoord()), new Coord((int) _p.getXCoord(), (int) _p.getYCoord()));
        _g.setRotation(rotation);

        if (Math.abs(_g._rotation - _g._degreeGoal) > _g._rotationSpeed) {
            if (_g._patrolClockwise) {
                _g.setRotateC(true);

            } else {
                _g.setRotateCC(true);
            }
        } else {
            _g.setRotateC(false);
            _g.setRotateCC(false);
        }

        _g._item.setXCoord(_g.getXCoord() + _g.getWidth() / 2);
        _g._item.setYCoord(_g.getYCoord());
        _g._item.setRotation(_g.getRotation());



        determineDirections();

        if (_g._touchingMe != null) {
            if (_g._touchingMe instanceof Player) {
                _timer = System.currentTimeMillis();
            }
            _g._touchingMe = null;
        }
        if (System.currentTimeMillis() - _timer > FRENZIED_TIME_SECONDS) {
            _g._state = new GuardCalmState(_g, _p);
        }
    */
    }

    public void determineDirections() {/*
        double xDifference = _g.getXCoord() - _p.getXCoord();
        double yDifference = _g.getYCoord() - _p.getYCoord();
        if (xDifference < _p.getWidth()) {
            _g.setRight(true);
        } else if (xDifference > _p.getWidth()) {
            _g.setLeft(true);
        }
        if (yDifference < _p.getHeight()) {
            _g.setDown(true);
        } else if (yDifference > _p.getHeight()) {
            _g.setUp(true);

        }
*/
    }


}
