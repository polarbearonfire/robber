package jFrame;

import java.awt.*;
import java.util.Vector;
import javax.swing.JPanel;

import Abstract.Moving;
import Objects.Player;
import startup.GameController;


public class MainPanel
        extends JPanel {
    private static final long serialVersionUID = 7380123579708902387L;
    GameController _controller;
    String _notification;
    public static int centerScreenX = 0;
    public static int centerScreenY = 0;

    public MainPanel(GameController gc) {
        _notification = "";
        _controller = gc;
    }

    public void setNotification(String toSet) {
        _notification = toSet;
    }

    public static int getCenterScreenX(){
        return centerScreenX;
    }

    public static int getCenterScreenY(){
        return centerScreenY;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (GameController.getPlayer() != null) {
            centerScreenX = getWidth() / 2;
            centerScreenY = getHeight() / 2;

            Player p = GameController.getPlayer();
            double offsetX = centerScreenX - p.getCenterX();
            double offsetY = centerScreenY - p.getCenterY();


            Vector<Moving> allMoving = _controller.getAllMovingObjects();
            for (int i = 0; i < allMoving.size(); i++) {
                Moving mo = allMoving.elementAt(i);
                if (mo != null) {
                    Graphics2D g2d = (Graphics2D) g.create();

                    double rotation = mo.getRotation();
                    g2d.rotate(-Math.toRadians(rotation), mo.getRotatingPointX() + offsetX, mo.getRotatingPointY() + offsetY);

                    g2d.drawImage(mo.getImage(),
                            (int) (mo.getX() + offsetX),
                            (int) (mo.getY() + offsetY),
                            mo.getWidth(),
                            mo.getHeight(),
                            null);
                }
            }

            g.drawString(this._notification, 10, 20);
        }

    }

}
