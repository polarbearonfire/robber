package Objects;

import Abstract.Item;
import Abstract.Moving;
import enums.Paths;

import java.awt.Image;

public class Paint extends Item {

    public Paint(Image image) {
        _width = 30;
        _height = 30;
        _image = image;
    }

    public Moving use(int x, int y) {
        return new Footprint(x, y, getRotation(), initImage(Paths.FOOTPRINT.toString()));
    }


    public String getName() {
        return "Paint";
    }

    public void load(int centerOfMaxX, int centerOfManY) {
    }
}
