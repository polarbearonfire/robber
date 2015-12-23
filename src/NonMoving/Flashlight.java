
package NonMoving;


import java.awt.*;

import Moving.Guard;
import Interface.*;
import Moving.Player;
import startup.GameController;


public class Flashlight extends IItem {

    public Flashlight(double x, double y, int width, int height, Image image) {
        _xCoord = x;
        _yCoord = y;
        _width = width;
        _height = height;
        _image = image;

    }

    public void load(int centerOfMaxX, int centerOfManY) {
    }

    public IHuman use(int centerOfManX, int centerOfManY) {
        return null;
    }

    public boolean colliding(Player p) {

/*
        double x = getXCoord();
        x -= getWidth();
        double width = getWidth() * 2;
        double y = getYCoord() - getWidth() + getHeight() / 2;
        double height = width;
        Rectangle frect = new Rectangle((int) x, (int) y, (int) width, (int) height);
        Rectangle prect = new Rectangle((int) p.getXCoord(), (int) p.getYCoord(), p.getWidth(), p.getHeight());


        //this is our 0,0
        double origX = getXCoord();
        double origY = getYCoord() + getHeight() / 2;
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
        double px = p.getXCoord() - origX;
        double py = origY - p.getYCoord();
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


    public void checkForTrouble() {
        if (!_belongsToMainCharacter) {
            Player p = GameController.getPlayer();
            if (colliding(p)) {
                ((Guard) getOwner()).detectedTrouble(p);
            }
        }
    }


    public String getName() {
        return "Flashlight";
    }
}
