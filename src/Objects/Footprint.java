package Objects;

import java.awt.Image;

import Abstract.Item;
import Abstract.Moving;

public class Footprint extends Item {

    public Footprint(int x, int y, double rotation, Image image) {
        _x = x;
        _y = y;
        _width = 20;
        _height = 20;
        _image = image;
        _rotation = rotation;
    }

    @Override
    public boolean colliding(Moving other){
        return false;
    }

}

