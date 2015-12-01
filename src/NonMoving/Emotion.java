package NonMoving;

import Interface.DrawableObject;
import Interface.MovingObject;

import java.awt.*;

/**
 * Created by danecarlson on 9/21/2015.
 */
public class Emotion extends DrawableObject {

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
