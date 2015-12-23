package Objects;

import java.awt.Image;

import Abstract.Moving;

public class Footprint extends Moving {

    public Footprint(int x, int y, double rotation, Image image) {
        _xCoord = x;
        _yCoord = y;
        _width = 20;
        _height = 20;
        _image = image;
        _rotation = rotation;
    }

}

