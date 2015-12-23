package NonMoving;

import java.awt.Image;

import Interface.IDrawableObject;

public class Footprint extends IDrawableObject {

    public Footprint(int x, int y, int width, int height, double rotation, Image image) {
        _xCoord = x;
        _yCoord = y;
        _width = width;
        _height = height;
        _image = image;
        _rotation = rotation;
    }



    public void setOffsets(double xOff, double yOff) {
    }




}

