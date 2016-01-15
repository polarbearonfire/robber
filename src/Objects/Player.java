package Objects;

import Abstract.Drawable;
import Abstract.Human;
import enums.Paths;

import java.awt.Image;
import java.util.LinkedList;


public class Player
        extends Human {

    public Player(int x, int y, int width, int height, Image img) {
        _x = x;
        _y = y;
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


    public void spotted() {

        //_speed = 0;
    }

    protected long lastTimeUsedItem = 0;

    public Drawable useItem() {
        if (System.currentTimeMillis() - lastTimeUsedItem > USE_ITEM_LIMIT) {
            lastTimeUsedItem = System.currentTimeMillis();

            int x = (int) getX();
            x += getWidth() / 2;
            int y = (int) getY();
            y += getHeight() / 2;
            Drawable toReturn = _item.use(x, y);
            return toReturn;
        }
        return null;
    }
}
