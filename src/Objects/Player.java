package Objects;

import Abstract.Human;
import Abstract.Moving;
import enums.Paths;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.LinkedList;

import java.util.Vector;


public class Player
        extends Human {
    public Player(int width, int height, Image img) {
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


    protected long lastTimeUsedGun = 0;
    protected long lastTimeUsedPaint = 0;

    public Moving useItem() {
        if (isShooting() && System.currentTimeMillis() - lastTimeUsedGun > USE_GUN_LIMIT) {
            Bullet bullet = (Bullet) useGun();
            setShooting(false);
            lastTimeUsedGun = System.currentTimeMillis();
            return bullet;

        } else if (isPainting() && isMoving() && System.currentTimeMillis() - lastTimeUsedPaint > USE_PAINT_LIMIT) {
            Footprint f = (Footprint) usePaint();
            lastTimeUsedPaint = System.currentTimeMillis();
            return f;
        }
        return null;
    }

    public Moving useGun() {
        int x = (int) (getX() + getWidth() / 2);
        int y = (int) (getY() + getHeight() / 2);

        Moving toReturn = _item.use(x, y);
        toReturn.belongsToMainCharacter(true);
        return toReturn;
    }

    public Moving usePaint() {

        int x = (int) getX();
        x += getWidth() / 2;
        int y = (int) getY();
        y += getHeight() / 2;
        Moving toReturn = _item.use(x, y);
        toReturn.belongsToMainCharacter(false);

        return toReturn;
    }


    //do not change this unless you have good reason to.  colliding needs to override because
    //_xOffsets are temporary usually when checking if player is colliding with others
    public boolean colliding(Vector<Human> bounds) {
        if (bounds == null) {
            return false;
        }
        Rectangle pRect = new Rectangle((int) getX(), (int) getY(), getWidth(), getHeight());
        for (Moving mo : bounds) {
            Rectangle bound = new Rectangle((int) (mo.getX()), (int) (mo.getY()), mo.getWidth(), mo.getHeight());
            if (pRect.getBounds().intersects(bound)) {
                return true;
            }
        }
        return false;
    }


}
