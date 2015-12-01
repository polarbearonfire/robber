package utility;

/**
 * Created by danecarlson on 9/23/2015.
 */
public class Triangle {
    double _x, _y, _width, _height, _hypotenuse;

    public Triangle(double x, double y, double width, double height, double hypotenuse) {
        _x = x;
        _y = y;
        _width = width;
        _height = height;
        _hypotenuse = hypotenuse;
    }

    public double getWidth() {
        return _width;
    }

    public double getHeight() {
        return _height;
    }

    public double getHypotenuse() {
        return _hypotenuse;
    }

    public void normalize() {
        if (_width != 0) {
            _width /= _hypotenuse;
        }
        if (_height != 0) {
            _height /= _hypotenuse;
        }
        _hypotenuse = 1;
    }
}
