package NonMoving;

import Interface.IDrawableObject;
import Interface.IItem;
import enums.Paths;

import java.awt.Image;

public class Paint extends IItem {

    public Paint(int x, int y, int width, int height, Image image) {
        _xCoord = x;
        _yCoord = y;
        _width = width;
        _height = height;
        _image = image;
    }

    public IDrawableObject use(int x, int y) {
        return new Footprint(x,y,10,10, getRotation(), initImage(Paths.FOOTPRINT.toString()));
    }


    public String getName() {
        return "Paint";
    }

    public void load(int centerOfMaxX, int centerOfManY) {
    }
}
