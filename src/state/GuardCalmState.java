package state;

import Interface.GuardState;
import Moving.Guard;
import utility.Coord;
import NonMoving.Emotion;
import Moving.Player;

/**
 * Created by danecarlson on 9/21/2015.
 */
public class GuardCalmState extends GuardState {

    final double DESIRED_SPEED = .5;
    final double DESIRED_ROTATION_SPEED = 1;

    public GuardCalmState(Guard g, Player p) {
        _p = p;
        _g = g;
        //_g.setEmotion(new Emotion(_g.getXCoord(), _g.getYCoord(), 50,50,));
        if (_g._speed == 0) {
            _g._speed = DESIRED_SPEED;
            _g._rotationSpeed = DESIRED_ROTATION_SPEED;

        }
    }

    @Override
    public void increment() {
/*
        if (_g._speed >= DESIRED_SPEED) {
            _g._speed -= SPEED_INCREMENT;
        }
        if (_g._rotationSpeed >= DESIRED_ROTATION_SPEED) {
            _g._rotationSpeed -= SPEED_INCREMENT;
        }

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


        double rotation = MyMath.findAngleOfTwoPoints(new Coord((int) _g.getXCoord(), (int) _g.getYCoord()), _g._currentDestination);
        double diff1 = Math.abs(rotation - _g.getRotation());
        if (diff1 > 2.5) {
            if (_g._patrolClockwise) {
                _g.rotationDecrement();
            } else {
                _g.rotationIncrement();
            }
        }

        _g._item.setXCoord(_g.getXCoord() + _g.getWidth() / 2);
        _g._item.setYCoord(_g.getYCoord());
        _g._item.setRotation(_g.getRotation());

        determineDirections();

        if (_g._touchingMe != null) {
            if (_g._touchingMe instanceof Player) {
                _g._state = new GuardFrenziedState(_g, _p);
            }
            _g._touchingMe = null;
        }*/

    }

    public void determineDirections() {
/*
        double xDifference = _g.getXCoord() - _g._currentDestination.getX();
        double yDifference = _g.getYCoord() - _g._currentDestination.getY();
        if (xDifference < -1.0D) {
            _g.setRight(true);
            _g.setUp(false);
            _g.setDown(false);
        } else if (xDifference > 1.0D) {
            _g.setLeft(true);
            _g.setUp(false);
            _g.setDown(false);
        } else if (yDifference < -1.0D) {
            _g.setDown(true);
            _g.setRight(false);
            _g.setLeft(false);
        } else if (yDifference > 1.0D) {
            _g.setUp(true);
            _g.setRight(false);
            _g.setLeft(false);

        } else {
            changeDestination();

        }
        */
    }


    public void changeDestination() {
/* 133 */
        if (_g._patrolClockwise) {
/* 134 */
            if (_g._currentDestination.equals(_g._route.getCoord1())) {
/* 135 */
                _g._currentDestination = _g._route.getCoord2();
/* 136 */
                _g._degreeGoal = 0.0D;
/* 137 */
            } else if (_g._currentDestination.equals(_g._route.getCoord2())) {
/* 138 */
                _g._currentDestination = _g._route.getCoord3();
/* 139 */
                _g._degreeGoal = 270.0D;
/* 140 */
            } else if (_g._currentDestination.equals(_g._route.getCoord3())) {
/* 141 */
                _g._currentDestination = _g._route.getCoord4();
/* 142 */
                _g._degreeGoal = 180.0D;
/* 143 */
            } else if (_g._currentDestination.equals(_g._route.getCoord4())) {
/* 144 */
                _g._currentDestination = _g._route.getCoord1();
/* 145 */
                _g._degreeGoal = 90.0D;

            }


        } else if (_g._currentDestination.equals(_g._route.getCoord1())) {
            _g._currentDestination = _g._route.getCoord4();
            _g._degreeGoal = 270.0D;
        } else if (_g._currentDestination.equals(_g._route.getCoord2())) {
            _g._currentDestination = _g._route.getCoord1();
            _g._degreeGoal = 180.0D;

        } else if (_g._currentDestination.equals(_g._route.getCoord3())) {
            _g._currentDestination = _g._route.getCoord2();
            _g._degreeGoal = 90.0D;
        } else if (_g._currentDestination.equals(_g._route.getCoord4())) {
            _g._currentDestination = _g._route.getCoord3();
            _g._degreeGoal = 0.0D;

        }
    }

    public void changeDestinationManually(Coord newCoord) {
        _g._currentDestination = newCoord;
    }


}
