package Objects;

import Abstract.Drawable;
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

    @Override
    public Drawable use(double x, double y){
        return new Footprint((int)x, (int)y, getRotation(), initImage(Paths.FOOTPRINT.toString()));
    }


    public String getName() {
        return "Paint";
    }

    public void load(int centerOfMaxX, int centerOfManY) {
    }
}
