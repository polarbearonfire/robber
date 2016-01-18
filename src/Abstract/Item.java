
package Abstract;


public abstract class Item extends Moving {
    protected Drawable  _owner;


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
        if (_owner != null && _owner != this) {
            return _owner.getRotation();
        } else {
            return _rotation;
        }
    }

    @Override
    public int getRotatingPointX() {
        if (_owner != null && _owner != this) {
            return _owner.getRotatingPointX();
        } else {
            return super.getRotatingPointX();
        }
    }
    public Drawable use(double x, double y){
        return null;
    }

    @Override
    public int getRotatingPointY() {
        if (_owner != null && _owner != this) {
            return _owner.getRotatingPointY();
        } else {
            return super.getRotatingPointY();
        }
    }

    public String getName() {
        return "Item";

    }

}
