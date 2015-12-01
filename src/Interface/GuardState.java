package Interface;

import Moving.Guard;
import Moving.Player;

/**
 * Created by danecarlson on 9/21/2015.
 */
public abstract class GuardState {
    protected Guard _g;
    protected Player _p;

    protected final double SPEED_INCREMENT = .01;

    public abstract void increment();


    public abstract void determineDirections();


}
