package NonMoving;

import Interface.IDrawableObject;

import java.awt.*;

/**
 * Created by danecarlson on 10/4/2015.
 */
public class Scenery extends IDrawableObject {
    public Scenery(int x, int y, int width, int height, Image img){

        _xCoord = x;
        _yCoord = y;
        _width = width;
        _height = height;
        _image = img;
    }
}
