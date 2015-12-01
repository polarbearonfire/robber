
package jFrame;


import java.awt.*;
import java.util.Iterator;
import javax.swing.JPanel;

import Interface.DrawableObject;
import startup.GameController;


public class MainPanel
        extends JPanel {
    private static final long serialVersionUID = 7380123579708902387L;
    GameController _controller;
    String _notification;

    public MainPanel(GameController gc) {
        _notification = "";
        _controller = gc;
    }

    public void setNotification(String toSet) {
        _notification = toSet;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (GameController.getPlayer() != null) {
            Iterator<DrawableObject> itr = _controller.getAllDrawableObjects().iterator();
            int centerScreenX = getWidth() / 2;
            int centerScreenY = getHeight() / 2;

            double offsetX = centerScreenX - GameController.getPlayer().getXCoord();
            double offsetY = centerScreenY - GameController.getPlayer().getYCoord();
            while (itr.hasNext()) {
                DrawableObject mo = itr.next();
                if (mo != null) {
                    Graphics2D g2d = (Graphics2D) g.create();

                    double rotation = mo.getRotation();
                    g2d.rotate(-Math.toRadians(rotation), mo.getRotatingPointX() + offsetX, mo.getRotatingPointY() + offsetY);

                    g2d.drawImage(mo.getImage(),
                            (int) (mo.getXCoord() + offsetX),
                            (int) (mo.getYCoord() + offsetY),
                            mo.getWidth(),
                            mo.getHeight(),
                            null);
                }

            }

            g.drawString(this._notification, 10, 20);
        }

    }

}
