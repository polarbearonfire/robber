package Abstract;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by danecarlson on 10/1/2015.
 */
public abstract class Drawable {
    public double _x;
    public double _y;
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

    static public Image initImage(int w, int h){
        int[]x = new int[3];
        int[]y = new int[3];
        x[0] = 0;
        y[0] = h/2;
        x[1] = w/2;
        y[1] = 0;
        x[2] = w/2;
        y[2] = h;
        BufferedImage buffIm = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics = buffIm.createGraphics();
        graphics.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        graphics.setStroke(new BasicStroke(0.1f));
        graphics.setColor(new Color(1f,.941176f,.64709f,.5f));
        graphics.setStroke(new BasicStroke(.1f));

        graphics.drawLine(x[0],y[0],x[1], y[1]);//   / line
        graphics.drawLine(x[1], y[1], x[2], y[2]);//   \ line


        graphics.setColor(new Color(249,242,30, 155));
        Polygon p = new Polygon(x,y,3);
        graphics.fillPolygon(p);
        graphics.drawArc((w/2)-5,0,10,h,270,360);//                ) arc
        graphics.fillArc((w/2)-5,0,10,h,270,360);
        return buffIm;
    }
    public void objectSeen(Moving what){}


    public void setRotation(double what) {
        _rotation = what;
    }

    public void setX(double x) {
        _x = x;
    }

    public void setY(double y) {
        _y = y;
    }

    public int getHeight() {
        return _height;
    }


    public int getWidth() {
        return _width;
    }


    public double getX() {
        return _x;
    }

    public double getY() {
        return _y;

    }

    public double getCenterX(){
        return _x + _width/2;
    }

    public double getCenterY(){
        return _y + _height/2;
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
        return (int) (getX() + getWidth() / 2);
    }

    public int getRotatingPointY() {
        return (int) (getY() + getHeight() / 2);
    }

    public double getRotation() {
        return _rotation;
    }


}
