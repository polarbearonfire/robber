package startup;

import Abstract.Drawable;
import Abstract.Human;
import Abstract.Item;
import Input.MyMouseClickListener;
import Input.MyMouseMotionListener;
import Objects.*;
import Abstract.Moving;
import Input.KeyboardListener;
import Objects.Paint;
import enums.*;

import java.awt.*;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;
import java.util.logging.Logger;
import javax.swing.*;

import jFrame.MainPanel;
import jFrame.StatusLabel;
import utility.FileHelper;
import utility.MyMath;


public class GameController implements Runnable {

    JFrame _frame;
    MainPanel _mainPanel;
    StatusLabel _statusLabel;
    KeyboardListener _keyboardListener;
    MouseMotionListener _mouseMotionListener;
    MyMouseClickListener _mouseClickListener;
    Vector<Bullet> _bullets;
    Vector<Item> _items;
    Vector<Moving> _footprints;
    Vector<Moving> _humans;
    Vector<Moving> _scenery;
    static Player _player;
    FileHelper _fileHelper;
    boolean _switchItem;
    boolean _useItem;
    boolean _pickUpItem;
    static int _currentMouseX;
    static int _currentMouseY;

    public GameController() {
        _bullets = new Vector();
        _items = new Vector();
        _footprints = new Vector();
        _humans = new Vector();
        _scenery = new Vector();
        _fileHelper = new FileHelper(this);
    }

    static public Player getPlayer() {
        return _player;
    }

    public static int getMouseX() {
        return _currentMouseX;
    }

    public static int getMouseY() {
        return _currentMouseY;
    }

    public void setUp() {
        setUpFrame();
        setUpPlayer();
        setUpListeners();


        try {
            Scanner sc = new Scanner(new java.io.File("levelOneMap.txt"));
            while (sc.hasNext()) {
                ArrayList<String> vals = (_fileHelper.getValues(sc));

                if (vals.get(0).equals("GUARD")) {
                    int x = Integer.parseInt(vals.get(1));
                    int y = Integer.parseInt(vals.get(2));
                    Rectangle routeRectangle = new Rectangle(
                            Integer.parseInt(vals.get(3)),
                            Integer.parseInt(vals.get(4)),
                            Integer.parseInt(vals.get(5)),
                            Integer.parseInt(vals.get(6)));
                    Flashlight f = new Flashlight(Drawable.initImage(50,50), initImage(Paths.FLASHLIGHT_OFF.toString()), 200, 100);
                    Guard g = new Guard(x, y, initImage(Paths.GUARD.toString()), routeRectangle);
                    g.setRotation(Integer.parseInt(vals.get(7)));
                    g.giveItem(f);

                    _items.add(f);
                    _humans.add(g);

                } else if (vals.get(0).equals("PRISONER")) {
                    int x = Integer.parseInt(vals.get(1));
                    int y = Integer.parseInt(vals.get(2));
                    int width = Integer.parseInt(vals.get(3));
                    int height = Integer.parseInt(vals.get(4));
                    Prisoner p = new Prisoner(x, y, width, height, initImage(Paths.PRISONER.toString()));

                    _humans.add(p);

                } else if (vals.get(0).equals("WALL")) {
                    Scenery scenery = new Scenery(
                            Integer.parseInt(vals.get(1)),
                            Integer.parseInt(vals.get(2)),
                            Integer.parseInt(vals.get(3)),
                            Integer.parseInt(vals.get(4)),
                            initImage(Paths.WALL.toString()));
                    _scenery.add(scenery);

                } else if (vals.get(0).equals("PRISONBARS")) {
                    Scenery scenery = new Scenery(
                            Integer.parseInt(vals.get(1)),
                            Integer.parseInt(vals.get(2)),
                            Integer.parseInt(vals.get(3)),
                            Integer.parseInt(vals.get(4)),
                            initImage(Paths.PRISON_BARS.toString()));
                    _scenery.add(scenery);
                }
                else if(vals.get(0).equals("FLASHLIGHT")){
                    Flashlight f = new Flashlight(Drawable.initImage(50,50), initImage(Paths.FLASHLIGHT_OFF.toString()),
                            Integer.parseInt(vals.get(3)), Integer.parseInt(vals.get(4)));
                    f.setX(Integer.parseInt(vals.get(1)));
                    f.setY(Integer.parseInt(vals.get(2)));
                    _items.add(f);
                }
                else if(vals.get(0).equals("PAINT")){
                    Paint p = new Paint((initImage(Paths.PAINT.toString())));
                    p.setX(Integer.parseInt(vals.get(1)));
                    p.setY(Integer.parseInt(vals.get(2)));
                    _items.add(p);
                }
                else{
                    Scenery scenery = new Scenery(
                            Integer.parseInt(vals.get(1)),
                            Integer.parseInt(vals.get(2)),
                            Integer.parseInt(vals.get(3)),
                            Integer.parseInt(vals.get(4)),
                            initImage(vals.get(0)));
                    _scenery.add(scenery);
                }
            }

            sc.close();

        } catch (FileNotFoundException ex) {

            Logger.getLogger(GameController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);

        }

    }


    public void setNotification(String toSet) {

        toSet = "Current Item: " + toSet;

        _statusLabel.setNotification(toSet);

    }


    public void setUpFrame() {

        _frame = new JFrame();

        _frame.setSize(1500, 1000);

        _frame.setDefaultCloseOperation(3);
        _mainPanel = new MainPanel(this, initImage(Paths.CURSOR.toString()));
        _mainPanel.setLayout(new BorderLayout());

        BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
        Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(
                cursorImg, new Point(0, 0), "blank cursor");
        _frame.getContentPane().setCursor(blankCursor);

        _mainPanel.setBackground(Color.decode("#423A31"));
        _frame.getContentPane().add(_mainPanel, BorderLayout.CENTER);


        _statusLabel = new StatusLabel(this);
        _statusLabel.setPreferredSize(new Dimension(_frame.getWidth(), 150));
        _statusLabel.setVisible(true);

        _mainPanel.add(_statusLabel, BorderLayout.PAGE_END);
        _frame.setVisible(true);
    }


    private void setUpPlayer() {
        Gun gun = new Gun(
                35,
                20,
                MainPanel.getCenterScreenY(),
                initImage(Paths.BASIC_GUN.toString()));

        _player = new Player(
                0,
                0,
                50,
                50,
                initImage(Paths.ROBBER.toString()));
        _player.giveItem(gun);
        _items.add(gun);
        _humans.add(_player);

        setNotification(_player.getItem().getName());
    }


    private void setUpListeners() {

        _keyboardListener = new KeyboardListener(this);
        _mouseMotionListener = new MyMouseMotionListener(this);
        _mouseClickListener = new MyMouseClickListener(this);

        _mainPanel.addKeyListener(_keyboardListener);
        _mainPanel.addMouseMotionListener(_mouseMotionListener);
        _mainPanel.addMouseListener(_mouseClickListener);

        _mainPanel.setFocusable(true);
        _mainPanel.requestFocus();

    }

    public void mouseMoved(int x, int y) {
        double angle = MyMath.findAngleOfTwoPoints(
                MainPanel.getCenterScreenX(),
                MainPanel.getCenterScreenY(),
                x,
                y);

        _player.setRotation(angle);
        _currentMouseX = x;
        _currentMouseY = y;

    }

    public void wKeyPressed() {
        _player.setYDir(Direction.UP);
    }

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

    public void mouseClicked(int mouseX, int mouseY) {
        mouseX -= MainPanel.getOffsetX();
        mouseY -= MainPanel.getOffsetY();
        _useItem = true;
        for (Moving mo : getAllMovingObjects()) {
            if (mo instanceof Prisoner) {
                Rectangle rect = new Rectangle((int) mo.getX(), (int) mo.getY(), mo.getWidth(), mo.getHeight());
                if (rect.intersects(mouseX, mouseY, 250, 250)) {
                    _statusLabel.displayMessage(((Human) mo).getNextMessage());
                }
            }
        }
    }

    public void spaceReleased() {
    }

    public void tKeyPressed() {
        _switchItem = true;
    }
    public void shiftKeyPressed() { _player.sprint();}
    public void shiftKeyReleased(){_player.stopSprinting();}
    public void spaceKeyPressed() { _pickUpItem = true;}

    public void run() {

        while (true) {

            if (_switchItem) {
                _items.remove(_player.getItem());
                _player.nextItem();
                _items.add(_player.getItem());
                setNotification(_player.getItem().getName());
                _player.getItem().setBelongsToMainCharacter(true);

                _switchItem = false;
            }

            if (_useItem) {
                _useItem = false;
                Drawable productOfItem = _player.useItem();
                if (productOfItem != null) {
                    if (productOfItem instanceof Bullet) {
                        _bullets.add((Bullet) productOfItem);
                    } else if (productOfItem instanceof Footprint) {
                        if (_footprints.size() > 10) {
                            _footprints.remove(0);
                        }
                        _footprints.add((Footprint) productOfItem);
                    }
                }
            }

            if(_pickUpItem){
                _pickUpItem = false;
                for (int i = 0; i < _items.size(); i++) {
                    Item item = _items.get(i);
                        if (_player.colliding(item)) {
                            _player.giveItem(item);
                            _items.remove(item);
                        }
                    }
            }

            Vector<Moving> all = getAllMovingObjects();
            for (Moving m : all) {
                boolean collided = false;
                for (int i = 0; i < all.size() && !collided; i++) {
                    Moving m2 = all.get(i);
                    if (m != m2) {
                        if (m.colliding(m2)) {
                            collided = true;
                        } else {
                            m.increment();
                        }
                    }
                }
            }

            for (int i = 0; i < _bullets.size(); i++) {
                if (_bullets.elementAt(i).hasHitObject()) {
                    _bullets.remove(i);
                    i--;
                }
            }
            _mainPanel.repaint();
        }
    }


    public Vector<Moving> getAllMovingObjects() {
        Vector<Moving> toReturn = new Vector<Moving>();
        toReturn.addAll(_bullets);
        toReturn.addAll(_scenery);
        toReturn.addAll(_footprints);
        toReturn.addAll(_humans);
        toReturn.addAll(_items);

        return toReturn;
    }


    public Image initImage(String path) {
        ImageIcon toReturn = new ImageIcon(this.getClass().getClassLoader().getResource(path.substring(1)));
        return toReturn.getImage();
    }
}