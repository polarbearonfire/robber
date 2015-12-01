
package Interface;


public abstract class Item extends DrawableObject {


    protected Human _owner;

    public Human getOwner() {
        return _owner;
    }

    public abstract void load(int paramInt1, int paramInt2);

    public abstract DrawableObject use(int paramInt1, int paramInt2);

    public void setOwner(Human owner) {
        _owner = owner;
    }

    public void setBelongsToMainCharacter(boolean whether) {
        _belongsToMainCharacter = whether;
    }

    public boolean belongsToMainCharacter() {
        return _belongsToMainCharacter;
    }

    public double getRotation() {
        if(_owner != null) {
            return _owner.getRotation();
        }
        else{
            return _rotation;
        }
    }

    @Override
    public int getRotatingPointX() {
        if (_owner != null) {
            return (int) _owner.getXCoord() + _owner.getWidth() / 2;
        } else {
            return super.getRotatingPointX();
        }
    }

    @Override
    public int getRotatingPointY() {
        if (_owner != null) {
            return (int) _owner.getYCoord() + _owner.getHeight() / 2;
        } else {
            return super.getRotatingPointY();
        }
    }

    public String getName() {
        return "Item";

    }

}
