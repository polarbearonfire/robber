
package Interface;


public abstract class IHuman extends IMovingObject {

    protected boolean _isShooting;
    protected boolean _isPainting;


    public java.util.Queue<IItem> _items;

    public IItem _item;

    @Override
    public void increment() {
        super.increment();
        if (_item != null) {
            _item.setXCoord(this.getXCoord() + getWidth() / 4);
            _item.setYCoord((this.getYCoord()));
            _item.setRotation(this.getRotation());
        }

    }

    public double getItemPlaceX() {
        return _xCoord + getWidth() / 2;
    }

    public double getItemPlaceY() {
        return _yCoord;
    }


    public IItem getItem() {
        return _item;
    }


    public void nextItem() {
        if ((this._items != null) && (this._items.size() > 0)) {
            IItem next = this._items.remove();
            IItem old = this._item;
            this._item = next;
            this._items.add(old);
        }
    }

    public void giveItem(IItem item) {
        if (this._item == null) {
            this._item = item;
        } else {
            this._items.add(item);
            this._item.setBelongsToMainCharacter(true);
        }
        item.setOwner(this);
    }


    public void setShooting(boolean whether) {
        this._isShooting = whether;
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


    public void loadItem() {
        if (this._item != null) {
            increment();
            int centerX = (int) getXCoord() + getWidth() / 2;
            int centerY = (int) getYCoord() + getHeight() / 2;
            this._item.load(centerX, centerY);
        }
    }

}
