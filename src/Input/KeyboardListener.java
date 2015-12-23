package Input;

import enums.Commands;
import startup.GameController;

import java.awt.event.KeyEvent;


public class KeyboardListener implements java.awt.event.KeyListener {
    GameController _gameController;

    public KeyboardListener(GameController gc) {
        this._gameController = gc;
    }

    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_DOWN:
                this._gameController.downKeyPressed();
                break;

            case KeyEvent.VK_UP:
                this._gameController.upKeyPressed();
                break;

            case KeyEvent.VK_RIGHT:
                this._gameController.rightKeyPressed();
                break;

            case KeyEvent.VK_LEFT:
                this._gameController.leftKeyPressed();
                break;

            case KeyEvent.VK_SPACE:
                this._gameController.spaceKeyReleased();
                break;

            case KeyEvent.VK_A:
                this._gameController.aKeyPressed();
                break;

            case KeyEvent.VK_D:
                this._gameController.dKeyPressed();
                break;

            case KeyEvent.VK_T:
                this._gameController.tKeyPressed();
                break;
        }

    }


    public void keyReleased(KeyEvent e) {

        switch (e.getKeyCode()) {
            case KeyEvent.VK_DOWN:
                this._gameController.downKeyReleased();
                break;
            case KeyEvent.VK_UP:
                this._gameController.upKeyReleased();
                break;
            case KeyEvent.VK_RIGHT:
                this._gameController.rightKeyReleased();
                break;
            case KeyEvent.VK_LEFT:
                this._gameController.leftKeyReleased();
                break;

            case KeyEvent.VK_A:
                this._gameController.aKeyReleased();
                break;
            case KeyEvent.VK_D:
                this._gameController.dKeyReleased();
                break;
            case KeyEvent.VK_SPACE:
                this._gameController.spaceKeyReleased();
                break;
        }
    }

    public void keyTyped(KeyEvent e) {
    }
}


/* Location:              /Users/danecarlson/Desktop/futurejava/!/behindTheScenes/KeyboardListener.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */