package Input;

import startup.GameController;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class MyMouseClickListener implements MouseListener {
    GameController _gameController;

    public MyMouseClickListener(GameController gc) {
        this._gameController = gc;
    }


    @Override
    public void mousePressed(MouseEvent e) {
        _gameController.mouseClicked(e.getX(), e.getY());
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
}

