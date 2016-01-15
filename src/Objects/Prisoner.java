package Objects;

import Abstract.Human;
import Abstract.Moving;
import Resources.Script;
import enums.Direction;
import enums.Paths;
import startup.GameController;
import utility.Coord;
import utility.MyMath;
import utility.Route;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.nio.Buffer;
import java.util.LinkedList;
import java.util.Random;
import java.util.Vector;

public class Prisoner extends Human {
    protected Route _route;
    protected Coord _currentDestination;
    protected double _degreeDestination;
    Player _player;
    //Vector<String> _script;

    public Prisoner(int x, int y, int width, int height, Image img) {
        //_script = Script.getScript(id);
        _x = x;
        _y = y;
        _player = GameController.getPlayer();
        _width = width;
        _height = height;
        _image = img;
        _speed = 0.5;
        _rotationSpeed = .8;
        _currentDestination = new Coord(
                (int) _player.getX(),
                (int) _player.getY());
    }

    public String getNextMessage() {
        return "";//script[0];
    }


    public Moving useItem() {
        _flashlight.use(0,0);
        return null;
    }


    @Override
    public void increment() {
        super.increment();

        _currentDestination = new Coord(
                (int) _player.getX(),
                (int) _player.getY());
        determineDirections();

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


    public void determineDirections() {
        if (_currentDestination != null) {
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
    }

}