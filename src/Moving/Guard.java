
package Moving;


import java.awt.*;
import java.util.LinkedList;
import java.util.Vector;

import Interface.DrawableObject;
import Interface.Human;
import enums.Paths;
import startup.GameController;
import Interface.GuardState;
import state.GuardCalmState;
import state.GuardFrenziedState;
import utility.Coord;
import NonMoving.Emotion;
import utility.Route;


public class Guard extends Human {
    public Route _route;
    public GuardState _state;
    public DrawableObject _touchingMe;
    public Coord _currentDestination;
    public double _degreeGoal;
    public boolean _patrolClockwise;
    public Emotion _emotion;


    public Guard(int x, int y, int width, int height, Image img) {
        _xCoord = x;
        _yCoord = y;
        _width = width;
        _height = height;
        _image = img;
        _patrolClockwise = true;
        _state = new GuardCalmState(this, GameController.getPlayer());

        _walkingImagePaths = new LinkedList<>();
        _walkingImagePaths.add(Paths.ROBBER.toString());
        _walkingImagePaths.add(Paths.ROBBER_LEFT.toString());
        _walkingImagePaths.add(Paths.ROBBER_RIGHT.toString());
    }

    public Emotion getEmotion() {
        return _emotion;
    }

    public void setEmotion(Emotion e) {
        _emotion = e;
    }

    public void detectedTrouble(Player p) {
        if (!(_state instanceof GuardFrenziedState)) {
            _state = new GuardFrenziedState(this, p);
        }
    }


    @Override
    public boolean colliding(Vector<Human> bounds) {
        Rectangle pRect = new Rectangle((int) getXCoord(), (int) getYCoord(), getWidth(), getHeight());
        for (DrawableObject b : bounds) {

            Rectangle bound = new Rectangle((int) b.getXCoord(), (int) b.getYCoord(), b.getWidth(), b.getHeight());


            if (pRect.getBounds().intersects(bound)) {

                _touchingMe = b;
                return true;
            }
        }
        return false;
    }

    @Override
    public void increment() {
        super.increment();
        _state.increment();
    }



    public void getRouteFromDrawableObject(DrawableObject mo) {
        double x1 = mo.getXCoord() - getWidth();
        double y1 = mo.getYCoord() - getHeight();
        double x2 = mo.getXCoord() + mo.getWidth() + getWidth();
        double y2 = y1;
        double x3 = x2;
        double y3 = mo.getYCoord() + mo.getHeight() + getHeight() * 2;
        double x4 = x1;
        double y4 = y3;
        _route = new Route((int) x1, (int) y1, (int) x2, (int) y2, (int) x3, (int) y3, (int) x4, (int) y4);
        _currentDestination = _route.getCoord1();

        _state.determineDirections();

    }

}


/* Location:              /Users/danecarlson/Desktop/futurejava/!/items/state.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */