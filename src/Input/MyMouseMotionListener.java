package Input;

import startup.GameController;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;


public class MyMouseMotionListener implements MouseMotionListener {
    GameController _gameController;

    public MyMouseMotionListener(GameController gc) {
        this._gameController = gc;
    }


    public void mouseMoved(MouseEvent e) {
        _gameController.mouseMoved(e.getX(),e.getY());
    }

    public void mouseDragged(MouseEvent e) {
        _gameController.mouseMoved(e.getX(),e.getY());
    }

}

