package Input;

import startup.GameController;

import java.awt.event.KeyEvent;


public class KeyboardListener implements java.awt.event.KeyListener {
    GameController _gameController;

    public KeyboardListener(GameController gc) {
        this._gameController = gc;
    }

    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_S:
                this._gameController.sKeyPressed();
                break;

            case KeyEvent.VK_W:
                this._gameController.wKeyPressed();
                break;

            case KeyEvent.VK_D:
                this._gameController.dKeyPressed();
                break;

            case KeyEvent.VK_A:
                this._gameController.aKeyPressed();
                break;

            case KeyEvent.VK_T:
                this._gameController.tKeyPressed();
                break;
            case KeyEvent.VK_SHIFT:
                this._gameController.shiftKeyPressed();
                break;
            case KeyEvent.VK_SPACE:
                this._gameController.spaceKeyPressed();
                break;
        }

    }


    public void keyReleased(KeyEvent e) {

        switch (e.getKeyCode()) {
            case KeyEvent.VK_S:
                this._gameController.sKeyReleased();
                break;
            case KeyEvent.VK_W:
                this._gameController.wKeyReleased();
                break;
            case KeyEvent.VK_D:
                this._gameController.dKeyReleased();
                break;
            case KeyEvent.VK_A:
                this._gameController.aKeyReleased();
                break;
            case KeyEvent.VK_SPACE:
                this._gameController.spaceReleased();
                break;
            case KeyEvent.VK_SHIFT:
                this._gameController.shiftKeyReleased();
        }
    }

    public void keyTyped(KeyEvent e) {
    }
}


/* Location:              /Users/danecarlson/Desktop/futurejava/!/behindTheScenes/KeyboardListener.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */