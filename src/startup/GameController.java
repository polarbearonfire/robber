package startup;

import Abstract.*;
import Input.MyMouseClickListener;
import Input.MyMouseMotionListener;
import Objects.*;
import Abstract.Human;
import Abstract.Moving;
import Input.KeyboardListener;
import Objects.Paint;
import enums.*;

import java.awt.*;
import java.awt.event.MouseMotionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;
import java.util.logging.Logger;
import javax.swing.*;

import jFrame.MainPanel;
import utility.FileHelper;
import utility.MyMath;


public class GameController implements Runnable {

    JFrame _frame;
    MainPanel _mainPanel;
    KeyboardListener _keyboardListener;
    MouseMotionListener _mouseMotionListener;
    MyMouseClickListener _mouseClickListener;
    Vector<Moving> _objects;
    static Player _player;
    FileHelper _fileHelper;
    boolean _switchItem;

    public GameController() {
        _objects = new Vector();
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
            Vector<Human> mos = new Vector<>();
            while (sc.hasNext()) {
                ArrayList<String> vals = (_fileHelper.getValues(sc));

                int x = Integer.parseInt(vals.get(0));
                int y = Integer.parseInt(vals.get(1));
                int width = Integer.parseInt(vals.get(2));
                int height = Integer.parseInt(vals.get(3));

                if (vals.get(4).equals("GUARD")) {
                    Scenery scenery = new Scenery(Integer.parseInt(vals.get(5)),
                            Integer.parseInt(vals.get(6)),
                            Integer.parseInt(vals.get(7)),
                            Integer.parseInt(vals.get(8)),
                            initImage(Paths.CUBICLE.toString()));
                    Guard g = new Guard(x, y, width, height, initImage(Paths.GUARD.toString()), scenery);
                    Flashlight f = new Flashlight(g.getX(), g.getY(), initImage(Paths.FLASHLIGHT.toString()));
                    _objects.add(f);
                    g.giveItem(f);
                    _objects.add(g);

                    _objects.add(scenery);
                }
            }

            sc.close();

        } catch (FileNotFoundException ex) {

            Logger.getLogger(GameController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);

        }

    }


    public void setNotification(String toSet) {

        toSet = "Current Item: " + toSet;

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

        _player = new Player(50, 50, initImage(Paths.ROBBER.toString()));
        _objects.add(_player);
        Item gun = new Gun(
                (int) _player.getX(),
                (int) _player.getY(),
                35,
                20,
                (int) _player.getX() + _player.getWidth() / 2,
                (int) _player.getY() + _player.getHeight() / 2,
                initImage(Paths.BASIC_GUN.toString()));
        gun.setOwner(_player);
        _player.giveItem(gun);
<<<<<<< 279acda1b00013e734ee52c60bb45b67bbe0c6c6
        _drawableObjects.add(gun);
        _player.loadItem();//commment
        IItem flashlight = new Flashlight(_player.getXCoord(), _player.getYCoord(), 100, 20, initImage(Paths.FLASHLIGHT.toString()));
=======
        _objects.add(gun);
        Item flashlight = new Flashlight(_player.getX(), _player.getY(), initImage(Paths.FLASHLIGHT.toString()));
>>>>>>> Structural changes
        _player.giveItem(flashlight);
        flashlight.setOwner(_player);
        Item paint = new Paint((int) _player.getX(), (int) _player.getY(), 40, 40, initImage(Paths.PAINT.toString()));
        paint.setOwner(_player);
        _player.giveItem(paint);
        setNotification(gun.getName());
    }


    private void setUpKeyboardListener() {

        _keyboardListener = new KeyboardListener(this);
        _mouseMotionListener = new MyMouseMotionListener(this);
        _mouseClickListener = new MyMouseClickListener(this);

        _mainPanel.addKeyListener(_keyboardListener);
        _mainPanel.addMouseMotionListener(_mouseMotionListener);
        _mainPanel.addMouseListener(_mouseClickListener);

        _mainPanel.setFocusable(true);
        _mainPanel.requestFocus();

    }

    public void mouseMoved(int x, int y){
        double angle = MyMath.findAngleOfTwoPoints(
                MainPanel.getCenterScreenX(),
                MainPanel.getCenterScreenY(),
                x,
                y);
        _player.setRotation(angle);

<<<<<<< 279acda1b00013e734ee52c60bb45b67bbe0c6c6
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
=======
    }

    public void wKeyPressed() {
>>>>>>> Structural changes
        _player.setYDir(Direction.UP);
    }
>>>>>>> Fixed KeyListener

    public void wKeyReleased() {
        _player.setYDir(Direction.NONE);
    }

    public void sKeyReleased() {
        _player.setYDir(Direction.NONE);
    }

    public void dKeyReleased() {
        _player.setXDir(Direction.NONE);
    }

    public void aKeyReleased() {
        _player.setXDir(Direction.NONE);
    }

    public void sKeyPressed() {
        _player.setYDir(Direction.DOWN);
    }

    public void aKeyPressed() {
        _player.setXDir(Direction.LEFT);
    }

    public void dKeyPressed() {
        _player.setXDir(Direction.RIGHT);
    }



    public void spaceKeyReleased() {
        if ((_player.getItem() instanceof Gun)) {
            _player.setShooting(true);
        } else if ((_player.getItem() instanceof Objects.Paint)) {
            _player.togglePainting();
        }
    }

    public void tKeyPressed() {
        _switchItem = true;
    }


    public void run() {

        while (true) {

            for (Moving m : _objects) {
                m.increment();
            }

            if (_switchItem) {
                _player.setPainting(false);
                _player.setShooting(false);

                _objects.remove(_player.getItem());
                _player.nextItem();
                _objects.add(_player.getItem());
                setNotification(_player.getItem().getName());
                _player.getItem().setBelongsToMainCharacter(true);

                _switchItem = false;
            }

            Moving productOfItem = _player.useItem();
            if (productOfItem != null) {
                if (productOfItem instanceof Bullet) {
                    _objects.add((Bullet) productOfItem);
                } else {
                    //if (_footprints.size() > 10) {
                    //  _footprints.remove(0);
                    //}
                    _objects.add((Footprint) productOfItem);
                }
            }
            for (Moving m : _objects) {
                m.increment();
            }
            _mainPanel.repaint();
        }
    }


    public Vector<Moving> getAllMovingObjects() {

        return _objects;

    }


    public Image initImage(String path) {

        ImageIcon toReturn = new ImageIcon(this.getClass().getClassLoader().getResource(path.substring(1)));
        return toReturn.getImage();
    }
}


 