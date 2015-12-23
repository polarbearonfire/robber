
package Abstract;


public abstract class Human extends Moving {

    protected boolean _isShooting;
    protected boolean _isPainting;
    public java.util.Queue<Item> _items;
    public Item _item;

    protected int USE_GUN_LIMIT = 300;
    protected int USE_PAINT_LIMIT = 300;

    @Override
    public void increment() {
        super.increment();
        if (_item != null) {
            _item.setXCoord(this.getX() + getWidth() / 4);
            _item.setYCoord((this.getY()));
            _item.setRotation(this.getRotation());
        }

    }

    abstract public Moving useItem();

    public double getItemPlaceX() {
        return _xCoord + getWidth() / 2;
    }

    public double getItemPlaceY() {
        return _yCoord;
    }


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
            this._item.setBelongsToMainCharacter(true);
        }
        item.setOwner(this);
    }


    public void setShooting(boolean whether) {
        _isShooting = whether;
    }

    public void togglePainting() {
        _isPainting = !_isPainting;
    }


    public void setPainting(boolean whether) {
        this._isPainting = whether;
    }

    public boolean isPainting() {
        return this._isPainting;
    }

    public boolean isShooting() {
        return this._isShooting;
    }


}
