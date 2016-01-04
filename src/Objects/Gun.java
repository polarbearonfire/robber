
package Objects;

import Abstract.Human;
import Abstract.Item;
import Abstract.Moving;
import enums.Paths;
import jFrame.MainPanel;
import startup.GameController;
import utility.MyMath;


public class Gun extends Item {
    protected double _widthOf0DegreeTriangle;
    protected double _heightOf0DegreeTriangle;
    protected double _hypotenuseOf0DegreeTriangle;
    protected double _angleFromCenter;


    public Gun(int width, int height, int centerOfManY, java.awt.Image image) {
        _width = width;
        _height = height;
        _image = image;


    }

    public Bullet use(int centerOfManX, int centerOfManY) {

        _widthOf0DegreeTriangle = getWidth();
        _heightOf0DegreeTriangle = Math.abs(centerOfManY - getY() - getHeight() / 2);

        _hypotenuseOf0DegreeTriangle = Math.sqrt(Math.pow(_widthOf0DegreeTriangle, 2) +
                Math.pow(_heightOf0DegreeTriangle, 2));

        _angleFromCenter = Math.toDegrees(Math.asin(Math.sin(Math.toRadians(90)) / _hypotenuseOf0DegreeTriangle * _heightOf0DegreeTriangle));


        double remainingAngle = 180.0D - _angleFromCenter - getRotation();

        double newHeight = _hypotenuseOf0DegreeTriangle * Math.sin(Math.toRadians(remainingAngle)) / Math.sin(Math.toRadians(90.0D));
        double newWidth = Math.sqrt(Math.pow(_hypotenuseOf0DegreeTriangle, 2.0D) - Math.pow(newHeight, 2.0D));

        double x = 0;
        double y = 0;
        newWidth = Math.abs(newWidth);
        newHeight = Math.abs(newHeight);
        if (remainingAngle < 90.0D) {
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
            if (remainingAngle < 0.0D) {
                y = centerOfManY + newHeight;
            }
        } else if (isFacingThirdQuad()) {

            x = centerOfManX - newWidth;
            y = centerOfManY + newHeight;
            if (Math.abs(remainingAngle) > 90.0D) {
                x = centerOfManX + newWidth;
            }

        } else if (isFacingFourthQuad()) {


            x = centerOfManX + newWidth;
            y = centerOfManY + newHeight;
            if (Math.abs(remainingAngle) > 180.0D) {
                y = centerOfManY - newHeight;
            }
        }

        double angle = MyMath.findAngleOfTwoPoints(
                x,
                y,
                GameController.getMouseX() - (MainPanel.getCenterScreenX() - _owner.getCenterX()),
                GameController.getMouseY() - (MainPanel.getCenterScreenY() - _owner.getCenterY()));
        double radians = Math.toRadians(angle);
        double rise = Math.sin(radians) * 10.0D;
        double run = Math.cos(radians) * 10.0D;

        if (isFacingFirstQuad()) {
            rise = -Math.abs(rise);
            run = Math.abs(run);
        } else if (isFacingSecondQuad()) {
            rise = -Math.abs(rise);
            run = -Math.abs(run);
        } else if (isFacingThirdQuad()) {
            rise = Math.abs(rise);
            run = -Math.abs(run);
        } else if (isFacingFourthQuad()) {
            rise = Math.abs(rise);
            run = Math.abs(run);
        }

        Bullet newBullet = new Bullet((int) x, (int) y, rise, run, 5, 5, initImage(Paths.BASIC_BULLET.toString()));
        return newBullet;
    }


    public String getName() {
        return "Gun";
    }

}
