package Objects;

import java.awt.*;
import java.util.LinkedList;
import java.util.Random;
import java.util.Vector;

import Abstract.Human;
import Abstract.Moving;
import enums.Direction;
import enums.Paths;
import startup.GameController;
import utility.Coord;
import utility.MyMath;
import utility.Route;

public class Guard extends Human {
    protected Route _route;
    protected Coord _currentDestination;
    protected boolean _patrolClockwise;
    protected double _degreeDestination;
    Vector<Footprint> _footprintsAlreadySeen;
    boolean _pulverised;


    public Guard(int x, int y, Image img, Rectangle patrol) {
        _x = x;
        _y = y;
        _width = 50;
        _height = 50;
        _image = img;
        _patrolClockwise = new Random().nextBoolean();
        _walk = .8;
        _sprint = 1.5;
        _speed = _walk;
        _rotationSpeed = .8;
        _walkingImagePaths = new LinkedList<>();
        _walkingImagePaths.add(Paths.ROBBER.toString());
        _walkingImagePaths.add(Paths.ROBBER_LEFT.toString());
        _walkingImagePaths.add(Paths.ROBBER_RIGHT.toString());
        _footprintsAlreadySeen = new Vector();
        this.getRouteFromRectangle(patrol);
        determineDirections();
    }

    public void objectSeen(Moving what) {
        if(!_pulverised) {
            if (what instanceof Footprint && !_footprintsAlreadySeen.contains(what)) {
                _currentDestination = new Coord((int) what.getX(), (int) what.getY());
                _footprintsAlreadySeen.add((Footprint) what);
            }
            if (what instanceof Player) {
                _currentDestination = new Coord(
                        (int) GameController.getPlayer().getX(),
                        (int) GameController.getPlayer().getY());
                //((Player) what).spotted();
            }
        }
    }

    public void hitByBullet() {
        _pulverised = true;
        _speed = 0;
        _rotationSpeed = 0;
        _rotation = 270;
    }

    public Moving useItem() {
        _item.use(0,0);
        return null;
    }

    @Override
    public boolean colliding(Moving other) {

        if (_item.colliding(other)) {
        }
        return super.colliding(other);
    }

    @Override
    public void increment() {
        if (!_pulverised) {
            super.increment();
            determineDirections();

            if (hasReachedDestination()) {
                incrementDestination();
                determineDirections();
            }

            if (hasReachedDegreeDestination()) {
                setRotateCC(false);
                setRotateC(false);
            }
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
            } else {
                _currentDestination = _route.getCoord1();
            }
        } else {
            if (_currentDestination.equals(_route.getCoord1())) {
                _currentDestination = _route.getCoord4();
            } else if (_currentDestination.equals(_route.getCoord2())) {
                _currentDestination = _route.getCoord1();
            } else if (_currentDestination.equals(_route.getCoord3())) {
                _currentDestination = _route.getCoord2();
            } else {
                _currentDestination = _route.getCoord3();
            }
        }
    }

    private boolean hasReachedDestination() {
        if (Math.abs(_x - _currentDestination.getX()) < 2.0) {
            if (Math.abs(_y - _currentDestination.getY()) < 2.0) {
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
        } else if (xDifference > 1.0D) {
            setXDir(Direction.LEFT);
        } else {
            setXDir(Direction.NONE);
        }
        if (yDifference < -1.0D) {
            setYDir(Direction.DOWN);
        } else if (yDifference > 1.0D) {
            setYDir(Direction.UP);
        } else {
            setYDir(Direction.NONE);
        }


        //now determine degreeGoal.  the reason this is done over and over
        //is in case the target is moving
        //find new destination angle

        double angle = MyMath.findAngleOfTwoPoints(new Coord((int) _x, (int) _y),
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


    public void getRouteFromRectangle(Rectangle routeRect) {
        double x1 = routeRect.getX();
        double y1 = routeRect.getY();
        double x2 = routeRect.getX() + routeRect.getWidth();
        double y2 = y1;
        double x3 = x2;
        double y3 = routeRect.getY() + routeRect.getHeight();
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