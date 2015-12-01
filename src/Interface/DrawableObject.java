package Interface;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by danecarlson on 10/1/2015.
 */
public abstract class DrawableObject {
    public double _xCoord;
    public double _yCoord;
    public double _rotation;
    public boolean _isRotatingCounterClockwise;
    public int _height;
    public int _width;
    protected boolean _belongsToMainCharacter;
    public java.awt.Image _image;

    public Image initImage(String path) {

        ImageIcon toReturn = new ImageIcon(this.getClass().getClassLoader().getResource(path.substring(1)));
        return toReturn.getImage();
    }
    public void belongsToMainCharacter(boolean whether) {
        _belongsToMainCharacter = whether;
    }

    public void setRotation(double what) {
        _rotation = what;
    }

    public void setXCoord(double x) {
        _xCoord = x;
    }

    public void setYCoord(double y) {
        _yCoord = y;
    }

    public int getHeight() {
        return _height;
    }


    public int getWidth() {
        return _width;
    }


    public double getXCoord() {
        return _xCoord;
    }


    public double getYCoord() {
        return _yCoord;

    }

    public java.awt.Image getImage() {
        return _image;

    }

    public boolean isFacingFirstQuad() {
        if ((getRotation() >= 0.0D) && (getRotation() < 90.0D)) {
            return true;
        }
        return false;

    }


    public boolean isFacingSecondQuad() {
        if ((getRotation() >= 90.0D) && (getRotation() < 180.0D)) {
            return true;
        }
        return false;
    }

    public boolean isFacingThirdQuad() {
        return (getRotation() >= 180.0D) && (getRotation() < 270.0D);
    }

    public boolean isFacingFourthQuad() {
        return (getRotation() >= 270.0D) && (getRotation() < 360.0D);
    }

    public int getRotatingPointX() {
        return (int) (getXCoord() + getWidth() / 2);
    }

    public int getRotatingPointY() {
        return (int) (getYCoord() + getHeight() / 2);
    }

    public double getRotation() {
        return _rotation;
    }


}
