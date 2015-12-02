package startup;

import Interface.IDrawableObject;
import Interface.IHuman;
import Interface.IMovingObject;
import Moving.Guard;
import Input.KeyboardListener;
import Interface.IItem;
import Moving.Bullet;
import NonMoving.*;
import Moving.Player;
import NonMoving.Paint;
import enums.*;

import java.awt.*;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;
import java.util.logging.Logger;
import javax.swing.*;

import jFrame.MainPanel;
import utility.FileHelper;


public class GameController implements Runnable {
    static final int LIMIT = 10;
    static final int REASONABLE_LIMIT = 250;
    JFrame _frame;
    MainPanel _mainPanel;
    KeyboardListener _listener;
    Vector<IDrawableObject> _drawableObjects;
    Vector<Guard> _guards;
    Vector<Bullet> _bullets;
    static Player _player;
    FileHelper _fileHelper;

    public GameController() {
        _bullets = new Vector<>();
        _guards = new Vector();
        _drawableObjects = new Vector();
        _fileHelper = new FileHelper(this);
    }

    static public Player getPlayer() {
        return _player;
    }

    public void setUp() {
        setUpFrame();
        setUpKeyboardListener();
        setUpPlayer();

        try {
            Scanner sc = new Scanner(new java.io.File("levelOneMap.txt"));
            Vector<IDrawableObject> dos = new Vector<IDrawableObject>();
            Vector<IHuman> mos = new Vector<>();
            while (sc.hasNext()) {
                String line = sc.nextLine();
                String[] vals = (_fileHelper.getValues(line));

                int x = Integer.parseInt(vals[0]);
                int y = Integer.parseInt(vals[1]);
                int width = Integer.parseInt(vals[2]);
                int height = Integer.parseInt(vals[3]);

                if (vals[4].equals("GUARD")) {
                    Guard g = new Guard(x, y, width, height, initImage(Paths.GUARD.toString()));
                    Flashlight f = new Flashlight(g.getXCoord(), g.getYCoord(), 100, 20, initImage(Paths.FLASHLIGHT.toString()));
                    _drawableObjects.add(f);
                    g.giveItem(f);
                    _guards.add(g);
                }
            }

            sc.close();

        } catch (FileNotFoundException ex) {

            Logger.getLogger(GameController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);

        }

    }


    public void setNotification(String toSet) {

        toSet = "Current IItem: " + toSet;

        _mainPanel.setNotification(toSet);

    }


    public void setUpFrame() {

        _frame = new JFrame();

        _frame.setSize(1500, 800);

        _frame.setDefaultCloseOperation(3);


        _mainPanel = new MainPanel(this);

        _mainPanel.setBackground(Color.darkGray);


        _frame.getContentPane().add(_mainPanel, "Center");

        _frame.setVisible(true);

    }


    private void setUpPlayer() {

        _player = new Player(100, 100, 50, 50, initImage(Paths.ROBBER.toString()));

        IItem gun = new Gun((int) _player.getXCoord(), (int) _player.getYCoord(), 35, 20, initImage(Paths.BASIC_GUN.toString()));
        gun.setOwner(_player);
        _player.giveItem(gun);
        _drawableObjects.add(gun);
        _player.loadItem();//commment
        IItem flashlight = new Flashlight(_player.getXCoord(), _player.getYCoord(), 100, 20, initImage(Paths.FLASHLIGHT.toString()));
        _player.giveItem(flashlight);
        flashlight.setOwner(_player);
        IItem paint = new Paint((int) _player.getXCoord(), (int) _player.getYCoord(), 40, 40, initImage(Paths.PAINT.toString()));
        paint.setOwner(_player);
        _player.giveItem(paint);
        setNotification(gun.getName());
    }


    private void setUpKeyboardListener() {

        _listener = new KeyboardListener(this);

        _mainPanel.addKeyListener(_listener);

        _mainPanel.setFocusable(true);
        _mainPanel.requestFocus();

    }


<<<<<<< 1839a85a2ee4849faef2ce5d05f68461e97e72f1
    public void buttonPressed(Commands pressed) {
        switch (pressed) {

            case GoUp:
                _player.setYDir(Direction.UP);
                break;

            case GoDown:
                _player.setYDir(Direction.DOWN);
                break;

            case GoRight:
                _player.setXDir(Direction.RIGHT);
                break;

            case GoLeft:
                _player.setXDir(Direction.LEFT);
                break;

            case StopUp:
                _player.setYDir(Direction.NONE);

                break;

            case StopDown:
                _player.setYDir(Direction.NONE);
                break;


            case StopRight:
                _player.setXDir(Direction.NONE);
                break;


            case StopLeft:
                _player.setXDir(Direction.NONE);

                break;


            case PullTrigger:
                if ((_player.getItem() instanceof Gun)) {

                    _player.setShooting(true);

                } else if ((_player.getItem() instanceof NonMoving.Paint)) {

                    _player.togglePainting();

                }

                break;

            case RotateCounterClockwise:

                _player.setRotateCC(true);

                _player.setRotateC(false);

                break;
=======
    public void upKeyPressed() {
        _player.setYDir(Direction.UP);
    }
>>>>>>> Fixed KeyListener

    public void upKeyReleased() {
        _player.setYDir(Direction.NONE);
    }

    public void downKeyReleased() {
        _player.setYDir(Direction.NONE);
    }

    public void leftKeyReleased() {
        _player.setXDir(Direction.NONE);
    }

    public void rightKeyReleased() {
        _player.setXDir(Direction.NONE);
    }

    public void downKeyPressed() {
        _player.setYDir(Direction.DOWN);
    }

    public void leftKeyPressed() {
        _player.setXDir(Direction.LEFT);
    }

    public void rightKeyPressed() {
        _player.setXDir(Direction.RIGHT);
    }

    public void aKeyPressed() {
        _player.setRotateCC(true);
        _player.setRotateC(false);
    }
    public void dKeyPressed() {
        _player.setRotateC(true);
        _player.setRotateCC(false);
    }
    public void aKeyReleased() {
        _player.setRotateCC(false);
    }

    public void dKeyReleased() {
        _player.setRotateC(false);
    }

    public void spaceKeyReleased() {
        if ((_player.getItem() instanceof Gun)) {

            _player.setShooting(true);

        } else if ((_player.getItem() instanceof NonMoving.Paint)) {

            _player.togglePainting();

        }
    }
    public void tKeyPressed(){
        _player.setPainting(false);
        _player.setShooting(false);
        _drawableObjects.remove(_player.getItem());
        _player.nextItem();
        _drawableObjects.add(_player.getItem());
        setNotification(_player.getItem().getName());
        _player.getItem().setBelongsToMainCharacter(true);
    }


    long _incrementalTimer = System.currentTimeMillis();
    long _reasonableTimer = System.currentTimeMillis();

    public void run() {

        while (true) {

            if (System.currentTimeMillis() - _incrementalTimer > LIMIT) {

                Vector<IMovingObject> thingsToMove = getAllMovingObjects();
                for (IMovingObject m : thingsToMove) {
                    m.increment();

                    if (System.currentTimeMillis() - _reasonableTimer > REASONABLE_LIMIT) {
                        m.nextWalkingImage();
                        useItem();
                        _reasonableTimer = System.currentTimeMillis();
                    }
                }


                _incrementalTimer = System.currentTimeMillis();
                _mainPanel.repaint();


            }
        }
    }


    public void useItem() {

        if (_player.isShooting()) {

            Bullet bullet = (Bullet) _player.useGun();
            _bullets.add(bullet);
            _player.setShooting(false);

        } else if (_player.isPainting() && _player.isMoving()) {
            Footprint f = (Footprint) _player.usePaint();
            _drawableObjects.add(f);

        }

    }


    public Vector<IMovingObject> getAllMovingObjects() {
        Vector<IMovingObject> toReturn = new Vector();

        toReturn.add(_player);
        toReturn.addAll(_guards);
        toReturn.addAll(_bullets);

        return toReturn;

    }

    public Vector<IDrawableObject> getAllDrawableObjects() {
        Vector<IDrawableObject> toReturn = new Vector();

        toReturn.addAll(_guards);
        toReturn.addAll(_bullets);
        toReturn.add(_player);
        toReturn.addAll(_drawableObjects);

        return toReturn;
    }

    public Image initImage(String path) {

        ImageIcon toReturn = new ImageIcon(this.getClass().getClassLoader().getResource(path.substring(1)));
        return toReturn.getImage();
    }
}


 