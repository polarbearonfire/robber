
package Objects;


import java.awt.*;
import java.awt.image.BufferedImage;

import Abstract.*;
import utility.MyMath;
import utility.Vector;


public class FlashlightFortyFiveDegrees extends Item {


    Image _onImage, _offImage;
    double _halfAngle;
    public FlashlightFortyFiveDegrees(Image on, Image off) {
        _width = 200;
        _height = 100;
        _halfAngle = 20;
        _onImage = on;
        _offImage = off;
        _image = _onImage;
    }

    @Override
    public void increment() {

    }


    public boolean colliding(Moving other) {


        //if the flashlight is a  reasonable distance from the object
        if (MyMath.getDistanceBetweenTwoPoints(
                _owner.getCenterX(),
                _owner.getCenterY(),
                other.getCenterX(),
                other.getCenterY()) < this.getWidth()) {


            Vector vFlash = new Vector(
                    this.getRotation(),
                    this.getWidth());


            double centerOfManX = _owner.getCenterX();
            double centerOfManY = _owner.getCenterY();
            double _widthOf0DegreeTriangle = 0;
            double _heightOf0DegreeTriangle = Math.abs(centerOfManY - getY() - getHeight() / 2);
            double _hypotenuseOf0DegreeTriangle = Math.sqrt(Math.pow(_widthOf0DegreeTriangle, 2) +
                    Math.pow(_heightOf0DegreeTriangle, 2));

            double _angleFromCenter = Math.toDegrees(Math.asin(Math.sin(Math.toRadians(90)) / _hypotenuseOf0DegreeTriangle * _heightOf0DegreeTriangle));
            double remainingAngle = 180 - _angleFromCenter - getRotation();
            double newHeight = _hypotenuseOf0DegreeTriangle * Math.sin(Math.toRadians(remainingAngle)) / Math.sin(Math.toRadians(90.0D));
            double newWidth = Math.sqrt(Math.pow(_hypotenuseOf0DegreeTriangle, 2) - Math.pow(newHeight, 2));

            double x = 0;
            double y = 0;
            newWidth = Math.abs(newWidth);
            newHeight = Math.abs(newHeight);
            if (remainingAngle < 90.0) {
                x = centerOfManX - newWidth;
            } else {
                x = centerOfManX + newWidth;
            }
            y = centerOfManY - newHeight;
            if (isFacingFirstQuad()) {
                y = centerOfManY - newHeight;
                x = centerOfManX + newWidth;
                if (remainingAngle < 90.0D) {
                    x = centerOfManX - newWidth;
                }
            } else if (isFacingSecondQuad()) {
                x = centerOfManX - newWidth;
                y = centerOfManY - newHeight;
                if (remainingAngle < 0.0) {
                    y = centerOfManY + newHeight;
                }
            } else if (isFacingThirdQuad()) {
                x = centerOfManX - newWidth;
                y = centerOfManY + newHeight;
                if (Math.abs(remainingAngle) > 90.0) {
                    x = centerOfManX + newWidth;
                }

            } else if (isFacingFourthQuad()) {
                x = centerOfManX + newWidth;
                y = centerOfManY + newHeight;
                if (Math.abs(remainingAngle) > 180.0) {
                    y = centerOfManY - newHeight;
                }
            }

            Vector vOther = new Vector(
                    x,
                    y,
                    other.getCenterX(),
                    other.getCenterY());

            if (vFlash.dotProduct(vOther) < _halfAngle) {
                this._owner.objectSeen(other);
                return true;
            }
        }
        return false;
    }

    @Override
    public Drawable use(double x, double y) {
        if (_image == _onImage) {
            _image = _offImage;
        } else {
            _image = _onImage;
        }
        return null;
    }


    public String getName() {
        return "Flashlight (45 Degrees)";
    }
}
