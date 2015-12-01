package Moving;

import Interface.DrawableObject;
import Interface.Human;
import enums.Paths;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.LinkedList;

import java.util.Vector;


public class Player
        extends Human {
    public Player(int x, int y, int width, int height, Image img) {
        _xCoord = x;
        _yCoord = y;
        _width = width;
        _height = height;
        _image = img;
        _speed = 1;
        _rotationSpeed = 2;
        _image = img;
        _items = new LinkedList<>();
        _walkingImagePaths = new LinkedList<>();
        _walkingImagePaths.add(Paths.ROBBER.toString());
        _walkingImagePaths.add(Paths.ROBBER_LEFT.toString());
        _walkingImagePaths.add(Paths.ROBBER_RIGHT.toString());
    }

    public DrawableObject useGun() {
        int x = (int) (getXCoord() + getWidth() / 2);
        int y = (int) (getYCoord() + getHeight() / 2);

        DrawableObject toReturn = _item.use(x, y);
        toReturn.belongsToMainCharacter(true);
        return toReturn;
    }

    public DrawableObject usePaint() {

        int x = (int) getXCoord();
        x += getWidth() / 2;
        int y = (int) getYCoord();
        y += getHeight() / 2;
        DrawableObject toReturn = _item.use(x, y);
        toReturn.belongsToMainCharacter(false);

        return toReturn;
    }


    //do not change this unless you have good reason to.  colliding needs to override because
    //_xOffsets are temporary usually when checking if player is colliding with others
    public boolean colliding(Vector<Human> bounds) {
        if (bounds == null) {
            return false;
        }
        Rectangle pRect = new Rectangle((int) getXCoord(), (int) getYCoord(), getWidth(), getHeight());
        for (DrawableObject mo : bounds) {
            Rectangle bound = new Rectangle((int) (mo.getXCoord()), (int) (mo.getYCoord()), mo.getWidth(), mo.getHeight());
            if (pRect.getBounds().intersects(bound)) {
                return true;
            }
        }
        return false;
    }


}
