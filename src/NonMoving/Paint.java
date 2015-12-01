package NonMoving;

import Interface.DrawableObject;
import Interface.Item;
import enums.Paths;

import java.awt.Image;

public class Paint extends Item {

    public Paint(int x, int y, int width, int height, Image image) {
        _xCoord = x;
        _yCoord = y;
        _width = width;
        _height = height;
        _image = image;
    }

    public DrawableObject use(int x, int y) {
        return new Footprint(x,y,10,10, getRotation(), initImage(Paths.FOOTPRINT.toString()));
    }


    public String getName() {
        return "Paint";
    }

    public void load(int centerOfMaxX, int centerOfManY) {
    }
}
