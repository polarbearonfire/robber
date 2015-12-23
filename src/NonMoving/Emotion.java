package NonMoving;

import Interface.IDrawableObject;

import java.awt.*;

/**
 * Created by danecarlson on 9/21/2015.
 */
public class Emotion extends IDrawableObject {

    public Emotion(double x, double y, int width, int height, Image img){
        _xCoord = x;
        _yCoord = y;
        _width = width;
        _height = height;
        _image = img;
    }

    @Override
    public double getRotation(){
        return 0;
    }
}
