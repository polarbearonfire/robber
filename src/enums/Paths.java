/*    */
package enums;

/*    */
/*    */ public enum Paths {
    /*  4 */   ROBBER, ROBBER_RIGHT, ROBBER_LEFT, BASIC_BULLET, BASIC_GUN, FLASHLIGHT, PAINT, FOOTPRINT, GUARD, WALL, CUBICLE, FRENZIED,
    CALM;

    /*    */
    Paths() {
    }

    /*  7 */
    public String toString() {
        switch (this) {
/*    */
            case ROBBER:
                return "/resources/robber.png";
            case ROBBER_RIGHT:
                return "/resources/robber right.png";
            case ROBBER_LEFT:
                return "/resources/robber left.png";
            case BASIC_BULLET:
                return "/resources/basicbullet.png";
            case BASIC_GUN:
                return "/resources/basicgun.png";
            case PAINT:
                return "/resources/paint.png";
            case CUBICLE:
                return "/resources/cubicle.png";
            case GUARD:
                return "/resources/guard.png";
            case WALL:
                return "/resources/wall.png";
            case FLASHLIGHT:
                return "/resources/flashlight.png";
            case FOOTPRINT:
                return "/resources/footprint.png";
            case FRENZIED:
                return "/resources/frenzied.png";
            case CALM:
                return "/resources/calm.png";
        }
        return "";
    }
}