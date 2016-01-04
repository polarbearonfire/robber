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

    Gun _gun;
    Paint _paint;

    public Player(int x, int y, int width, int height, Gun gun, Paint paint, Flashlight flashlight, Image img) {
        _x = x;
        _y = y;
        _width = width;
        _height = height;
        _gun = gun;
        _paint = paint;
        _flashlight = flashlight;
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


    public void spotted(){
        _speed = 0;
    }

    protected long lastTimeUsedGun = 0;
    protected long lastTimeUsedPaint = 0;


    public Moving useItem() {
        if (_item instanceof Gun && System.currentTimeMillis() - lastTimeUsedGun > USE_GUN_LIMIT) {
            Bullet bullet = (Bullet) useGun();
            lastTimeUsedGun = System.currentTimeMillis();
            return bullet;

        } else if (_item instanceof Paint && System.currentTimeMillis() - lastTimeUsedPaint > USE_PAINT_LIMIT) {
            Footprint f = (Footprint) usePaint();
            lastTimeUsedPaint = System.currentTimeMillis();
            return f;
        } else {
            useFlashlight();
        }
        return null;
    }

    public void useFlashlight() {
        _flashlight.use();
    }

    public Moving useGun() {
        int x = (int) (getX() + getWidth() / 2);
        int y = (int) (getY() + getHeight() / 2);

        Moving toReturn = _gun.use(x, y);
        toReturn.belongsToMainCharacter(true);
        return toReturn;
    }

    public Moving usePaint() {

        int x = (int) getX();
        x += getWidth() / 2;
        int y = (int) getY();
        y += getHeight() / 2;
        Moving toReturn = _paint.use(x, y);
        toReturn.belongsToMainCharacter(false);

        return toReturn;
    }





}
