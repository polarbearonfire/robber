package NonMoving;

import Interface.DrawableObject;

import java.awt.*;

/**
 * Created by danecarlson on 10/4/2015.
 */
public class Scenery extends DrawableObject {
    public Scenery(int x, int y, int width, int height, Image img){

        _xCoord = x;
        _yCoord = y;
        _width = width;
        _height = height;
        _image = img;
    }
}
