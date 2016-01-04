package jFrame;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Vector;
import javax.swing.JPanel;

import Abstract.Moving;
import Objects.Player;
import startup.GameController;


public class MainPanel
        extends JPanel {
    private static final long serialVersionUID = 7380123579708902387L;
    GameController _controller;
    Image _cursorImage;
    static int centerScreenX = 0;
    static int centerScreenY = 0;
    static Player _player;

    public MainPanel(GameController gc, Image cursor) {
        _controller = gc;
        _cursorImage = cursor;
    }



    public static int getCenterScreenX() {
        return centerScreenX;
    }

    public static int getCenterScreenY() {
        return centerScreenY;
    }

    public static double getOffsetX(){
        return centerScreenX - _player.getCenterX();
    }
    public static double getOffsetY(){
        return centerScreenY - _player.getCenterY();
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (GameController.getPlayer() != null) {
            centerScreenX = getWidth() / 2;
            centerScreenY = getHeight() / 2;

            _player = GameController.getPlayer();
            double offsetX = centerScreenX - _player.getCenterX();
            double offsetY = centerScreenY - _player.getCenterY();



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


            //draw cursor
            g.drawImage(
                    _cursorImage,
                    GameController.getMouseX() - _cursorImage.getWidth(null) / 2,
                    GameController.getMouseY() - _cursorImage.getHeight(null) / 2,
                    _cursorImage.getWidth(null),
                    _cursorImage.getHeight(null),
                    null);

        }

    }

}
