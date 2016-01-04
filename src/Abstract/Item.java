
package Abstract;


public abstract class Item extends Moving {
    protected Human _owner;


    public boolean colliding(Moving other) {
        return false;
    }

    public void setOwner(Human owner) {
        _owner = owner;
    }

    public void setBelongsToMainCharacter(boolean whether) {
        _belongsToMainCharacter = whether;
    }

    public double getRotation() {
        if (_owner != null) {
            return _owner.getRotation();
        } else {
            return _rotation;
        }
    }

    @Override
    public int getRotatingPointX() {
        if (_owner != null) {
            return _owner.getRotatingPointX();
        } else {
            return super.getRotatingPointX();
        }
    }

    @Override
    public int getRotatingPointY() {
        if (_owner != null) {
            return _owner.getRotatingPointY();
        } else {
            return super.getRotatingPointY();
        }
    }

    public String getName() {
        return "Item";

    }

}
