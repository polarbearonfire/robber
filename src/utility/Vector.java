package utility;

import java.awt.*;

public class Vector {
    double _x, _y, _magnitude;

    public Vector(double startX, double startY, double endX, double endY) {
        _x = endX - startX;
        _y = startY - endY;
        _magnitude = Math.sqrt(Math.pow(_x, 2) + Math.pow(_y, 2));

        _x /= _magnitude;
        _y /= _magnitude;
        _magnitude = 1;

    }

    public Vector(double angle, double length) {
        _magnitude = length;
        _x = _magnitude * Math.cos(Math.toRadians(angle));
        _y = _magnitude * Math.sin(Math.toRadians(angle));


        _x /= _magnitude;
        _y /= _magnitude;
        _magnitude = 1;
    }


    public double dotProduct(Vector other) {
        double x = _x * other.getX();
        double y = _y * other.getY();
        return Math.toDegrees(Math.acos(x + y));
    }

    public double getX() {
        return _x;
    }

    public double getY() {
        return _y;
    }

}
