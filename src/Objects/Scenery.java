package Objects;

import Abstract.Moving;

import java.awt.*;

/**
 * Created by danecarlson on 10/4/2015.
 */
public class Scenery extends Moving {
    public Scenery(int x, int y, int width, int height, Image img){

        _x = x;
        _y = y;
        _width = width;
        _height = height;
        _image = img;
    }

    @Override
    public void increment(){

    }
}
