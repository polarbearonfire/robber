
package Objects;

import Abstract.Item;
import enums.Paths;


public class Gun extends Item {
    protected double _widthOf0DegreeTriangle;
    protected double _heightOf0DegreeTriangle;
    protected double _hypotenuseOf0DegreeTriangle;
    protected double _angleFromCenter;


    public Gun(int x, int y, int width, int height, int centerOfMaxX, int centerOfManY, java.awt.Image image) {
        _xCoord = x;
        _yCoord = y;
        _width = width;
        _height = height;
        _image = image;


        _widthOf0DegreeTriangle = getWidth();
        _heightOf0DegreeTriangle = Math.abs(centerOfManY - getY() - getHeight() / 2);

        _hypotenuseOf0DegreeTriangle = Math.sqrt(Math.pow(_widthOf0DegreeTriangle, 2) +
                Math.pow(_heightOf0DegreeTriangle, 2));

        _angleFromCenter = Math.toDegrees(Math.asin(Math.sin(Math.toRadians(90)) / _hypotenuseOf0DegreeTriangle * _heightOf0DegreeTriangle));

    }


    public Bullet use(int centerOfManX, int centerOfManY) {
        double radians = Math.toRadians(getRotation());
        double rise = Math.sin(radians) * 10.0D;
        double run = Math.cos(radians) * 10.0D;

        double remainingAngle = 180.0D - _angleFromCenter - getRotation();

        double newHeight = _hypotenuseOf0DegreeTriangle * Math.sin(Math.toRadians(remainingAngle)) / Math.sin(Math.toRadians(90.0D));
        double newWidth = Math.sqrt(Math.pow(_hypotenuseOf0DegreeTriangle, 2.0D) - Math.pow(newHeight, 2.0D));

        double x = 0.0D;
        double y = 0.0D;
        newWidth = Math.abs(newWidth);
        newHeight = Math.abs(newHeight);
        if (remainingAngle < 90.0D) {
            x = centerOfManX - newWidth;
        } else {
            x = centerOfManX + newWidth;
        }
        y = centerOfManY - newHeight;
        if (isFacingFirstQuad()) {
            rise = -Math.abs(rise);
            run = Math.abs(run);
            y = centerOfManY - newHeight;
            x = centerOfManX + newWidth;
            if (remainingAngle < 90.0D) {
                x = centerOfManX - newWidth;
            }
        } else if (isFacingSecondQuad()) {
            rise = -Math.abs(rise);
            run = -Math.abs(run);
            x = centerOfManX - newWidth;
            y = centerOfManY - newHeight;
            if (remainingAngle < 0.0D) {
                y = centerOfManY + newHeight;
            }
        } else if (isFacingThirdQuad()) {
            rise = Math.abs(rise);
            run = -Math.abs(run);
            x = centerOfManX - newWidth;
            y = centerOfManY + newHeight;
            if (Math.abs(remainingAngle) > 90.0D) {
                x = centerOfManX + newWidth;
            }

        }
/*  99 */
        else if (isFacingFourthQuad()) {
/* 100 */
            rise = Math.abs(rise);
/* 101 */
            run = Math.abs(run);

            x = centerOfManX + newWidth;
            y = centerOfManY + newHeight;
            if (Math.abs(remainingAngle) > 180.0D) {
                y = centerOfManY - newHeight;

            }
        }
        Bullet newBullet = new Bullet((int) x, (int) y, rise, run, 5, 5, initImage(Paths.BASIC_BULLET.toString()));
        return newBullet;

    }


    public String getName() {
/* 119 */
        return "Gun";

    }

}


/* Location:              /Users/danecarlson/Desktop/futurejava/!/items/Gun.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */