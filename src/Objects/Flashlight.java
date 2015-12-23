
package Objects;


import java.awt.*;

import Abstract.*;


public class Flashlight extends Item {

    public Flashlight(double x, double y, Image image) {
        _xCoord = x;
        _yCoord = y;
        _width = 200;
        _height = 20;
        _image = image;

    }

    @Override
    public void increment() {

    }


    public Human use(int centerOfManX, int centerOfManY) {
        return null;
    }

    public boolean colliding(Player p) {

/*
        double x = getX();
        x -= getWidth();
        double width = getWidth() * 2;
        double y = getY() - getWidth() + getHeight() / 2;
        double height = width;
        Rectangle frect = new Rectangle((int) x, (int) y, (int) width, (int) height);
        Rectangle prect = new Rectangle((int) p.getX(), (int) p.getY(), p.getWidth(), p.getHeight());


        //this is our 0,0
        double origX = getX();
        double origY = getY() + getHeight() / 2;
        double hyp = Math.sqrt(Math.pow(getWidth(), 2) + Math.pow(getHeight() / 2, 2));
        height = hyp * Math.sin(Math.toRadians(getRotation()));
        width = Math.sqrt(Math.pow(hyp, 2) - Math.pow(height, 2));
        if (getRotation() > 90 && getRotation() < 270) {
            width = -width;
        }

        double fx = origX + width;
        double fy = origY - height;
        fx -= origX;
        fy -= origY;

        Triangle fTri = new Triangle(fx, fy, width, height, hyp);
        fTri.normalize();
        double px = p.getX() - origX;
        double py = origY - p.getY();
        hyp = Math.sqrt(Math.pow(px, 2) + Math.pow(py, 2));
        Triangle pTri = new Triangle(px, py, px, py, hyp);
        pTri.normalize();


        double x1 = fTri.getWidth();

        double x2 = pTri.getWidth();
        double y1 = fTri.getHeight();
        double y2 = pTri.getHeight();

        double dotProduct = (x1 * x2) + (y1 * y2);


        return frect.getBounds().intersects(prect) && dotProduct > .98;*/
        return false;

    }


    public String getName() {
        return "Flashlight";
    }
}
