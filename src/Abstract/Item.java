
package Abstract;


public abstract class Item extends Moving {


    protected Human _owner;

    public Human getOwner() {
        return _owner;
    }


    public abstract Moving use(int paramInt1, int paramInt2);

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
            return (int) _owner.getX() + _owner.getWidth() / 2;
        } else {
            return super.getRotatingPointX();
        }
    }

    @Override
    public int getRotatingPointY() {
        if (_owner != null) {
            return (int) _owner.getY() + _owner.getHeight() / 2;
        } else {
            return super.getRotatingPointY();
        }
    }

    public String getName() {
        return "Item";

    }

}
