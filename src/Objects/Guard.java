
package Objects;


import java.awt.*;
import java.util.LinkedList;
import java.util.Vector;

import Abstract.Human;
import Abstract.Moving;
import enums.Direction;
import enums.Paths;
import utility.Coord;
import utility.MyMath;
import utility.Route;


public class Guard extends Human {
    protected Route _route;
    protected Moving _touchingMe;
    protected Coord _currentDestination;
    protected boolean _patrolClockwise;
    protected double _degreeDestination;


    public Guard(int x, int y, int width, int height, Image img, Moving patrolObject) {
        _xCoord = x;
        _yCoord = y;
        _width = width;
        _height = height;
        _image = img;
        _patrolClockwise = false;
        _speed = .8;
        _rotationSpeed = .8;
        _walkingImagePaths = new LinkedList<>();
        _walkingImagePaths.add(Paths.ROBBER.toString());
        _walkingImagePaths.add(Paths.ROBBER_LEFT.toString());
        _walkingImagePaths.add(Paths.ROBBER_RIGHT.toString());

        this.getRouteFromObject(patrolObject);
    }

    public Moving useItem() {
        return null;
    }




    @Override
    public boolean colliding(Vector<Human> bounds) {
        Rectangle pRect = new Rectangle((int) getX(), (int) getY(), getWidth(), getHeight());
        for (Moving b : bounds) {

            Rectangle bound = new Rectangle((int) b.getX(), (int) b.getY(), b.getWidth(), b.getHeight());


            if (pRect.getBounds().intersects(bound)) {

                _touchingMe = b;
                return true;
            }
        }
        return false;
    }

    @Override
    public void increment() {
        determineDirections();
        super.increment();

        if (hasReachedDestination()) {
            incrementDestination();
            determineDirections();
        }

        if (hasReachedDegreeDestination()) {
            setRotateCC(false);
            setRotateC(false);
        }

    }

    public boolean hasReachedDegreeDestination() {
        if (Math.abs(_rotation - _degreeDestination) <= _rotationSpeed) {
            return true;
        }
        return false;
    }

    public void incrementDestination() {

        if (_patrolClockwise) {
            if (_currentDestination.equals(_route.getCoord1())) {
                _currentDestination = _route.getCoord2();
            } else if (_currentDestination.equals(_route.getCoord2())) {
                _currentDestination = _route.getCoord3();
            } else if (_currentDestination.equals(_route.getCoord3())) {
                _currentDestination = _route.getCoord4();
            } else if (_currentDestination.equals(_route.getCoord4())) {
                _currentDestination = _route.getCoord1();
            }
        } else {
            if (_currentDestination.equals(_route.getCoord1())) {
                _currentDestination = _route.getCoord4();
            } else if (_currentDestination.equals(_route.getCoord2())) {
                _currentDestination = _route.getCoord1();
            } else if (_currentDestination.equals(_route.getCoord3())) {
                _currentDestination = _route.getCoord2();
            } else if (_currentDestination.equals(_route.getCoord4())) {
                _currentDestination = _route.getCoord3();
            }
        }
    }

    private boolean hasReachedDestination() {
        if (Math.abs(_xCoord - _currentDestination.getX()) < 1.0) {
            if (Math.abs(_yCoord - _currentDestination.getY()) < 1.0) {
                return true;
            }
        }
        return false;
    }

    public void determineDirections() {

        double xDifference = getX() - _currentDestination.getX();
        double yDifference = getY() - _currentDestination.getY();
        if (xDifference < -1.0D) {
            setXDir(Direction.RIGHT);
            setYDir(Direction.NONE);
        } else if (xDifference > 1.0D) {
            setXDir(Direction.LEFT);
            setYDir(Direction.NONE);
        }
        if (yDifference < -1.0D) {
            setYDir(Direction.DOWN);
            setXDir(Direction.NONE);
        } else if (yDifference > 1.0D) {
            setYDir(Direction.UP);
            setXDir(Direction.NONE);
        }


        //now determine degreeGoal.  the reason this is done over and over
        //is in case the target is moving
        //find new destination angle

        double angle = MyMath.findAngleOfTwoPoints(new Coord((int) _xCoord, (int) _yCoord),
                new Coord(_currentDestination.getX(), _currentDestination.getY()));
        //new Coord((int) GameController.getPlayer().getX(), (int) GameController.getPlayer().getY()));


        if (Math.abs(_rotation - angle) > _rotationSpeed) {
            _degreeDestination = angle;

            if (_rotation < _degreeDestination) {
                if (_degreeDestination - _rotation < _rotation + 360 - _degreeDestination) {
                    setRotateCC(true);
                } else {
                    setRotateC(true);
                }
            } else {
                if (_rotation - _degreeDestination < 360 - _rotation + _degreeDestination) {
                    setRotateC(true);
                } else {
                    setRotateCC(true);
                }
            }
        }
    }


    public void getRouteFromObject(Moving mo) {
        double x1 = mo.getX() - getWidth();
        double y1 = mo.getY() - getHeight();
        double x2 = mo.getX() + mo.getWidth() + getWidth();
        double y2 = y1;
        double x3 = x2;
        double y3 = mo.getY() + mo.getHeight() + getHeight() * 2;
        double x4 = x1;
        double y4 = y3;
        _route = new Route((int) x1, (int) y1, (int) x2, (int) y2, (int) x3, (int) y3, (int) x4, (int) y4);

        if (_patrolClockwise) {
            _currentDestination = _route.getCoord2();
        } else {
            _currentDestination = _route.getCoord4();
        }
    }

}