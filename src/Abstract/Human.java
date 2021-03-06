
package Abstract;


import enums.Direction;

import java.awt.*;
import java.util.Vector;

public abstract class Human extends Moving {

    public java.util.Queue<Item> _items;
    public Item _item;
    public String _name = "Human";
    protected Vector<String> _script;
    protected int USE_ITEM_LIMIT = 300;

    //speed is either sprint or walk
    protected double _sprint, _walk;


    @Override
    public void increment() {
        super.increment();
        if (_item != null) {
            _item.setX(this.getX() + getWidth() / 2);
            _item.setY((this.getY() - _item.getHeight() / 2) + this.getHeight() / 8);
            _item.setRotation(this.getRotation());
        }
    }

    @Override
    public boolean colliding(Moving other) {
        if(other != _item) {
            if (super.colliding(other)) {
                if(!(other instanceof Item)){
                    fixCollision(other);
                }
                return true;
            }
        }
        return false;
    }

    public void fixCollision(Moving other) {
        //we know this is colliding with other, so adjust moving direction accordingly

        Rectangle thisRect = new Rectangle(
                (int) getX(),
                (int) getY(),
                getWidth(),
                getHeight());
        Rectangle otherRect = new Rectangle(
                (int) other.getX(),
                (int) other.getY(),
                other.getWidth(),
                other.getHeight());


        if (thisRect.intersectsLine(
                otherRect.getX(),
                otherRect.getY(),
                otherRect.getX() + otherRect.getWidth(),
                otherRect.getY())) {
            if (this._yDir == Direction.DOWN) {
                _y -= _speed;
            }
            if (other.getYDirection() == Direction.UP) {
                other.setY(other.getY() + other.getSpeed());
            }
        }
        if (thisRect.intersectsLine(
                otherRect.getX(),
                otherRect.getY() + otherRect.getHeight(),
                otherRect.getX() + otherRect.getWidth(),
                otherRect.getY() + otherRect.getHeight())) {
            if (this._yDir == Direction.UP) {
                _y += _speed;
            }
            if (other.getYDirection() == Direction.DOWN) {
                other.setY(other.getY() - other.getSpeed());
            }
        }
        if (thisRect.intersectsLine(
                otherRect.getX(),
                otherRect.getY(),
                otherRect.getX(),
                otherRect.getY() + otherRect.getHeight())
                ) {
            if (this._xDir == Direction.RIGHT) {
                _x -= _speed;
            }
            if (other.getXDirection() == Direction.LEFT) {
                other.setX(other.getX() + other.getSpeed());
            }
        }
        if (thisRect.intersectsLine(
                otherRect.getX() + otherRect.getWidth(),
                otherRect.getY(),
                otherRect.getX() + otherRect.getWidth(),
                otherRect.getY() + otherRect.getHeight())
                ) {
            if (this._xDir == Direction.LEFT) {
                _x += _speed;
            }
            if (other.getXDirection() == Direction.RIGHT) {
                other.setX(other.getX() - other.getSpeed());
            }
        }
    }

    abstract public Drawable useItem();

    public Item getItem() {
        return _item;
    }


    public void nextItem() {
        if ((this._items != null) && (this._items.size() > 0)) {
            Item next = this._items.remove();
            Item old = this._item;
            this._item = next;
            this._items.add(old);
        }
    }

    public void giveItem(Item item) {
        if (this._item == null) {
            this._item = item;
        } else {
            this._items.add(item);
        }
        item.setOwner(this);
    }

    public String getNextMessage() {
        return _name + ": " + _script.elementAt(0);
    }

    public void stopSprinting() {
        _speed = _walk;
    }
    public void sprint(){
        _speed = _sprint;
    }
}
