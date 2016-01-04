package enums;

public enum Paths {
    ROBBER, ROBBER_RIGHT, ROBBER_LEFT,
    BASIC_BULLET, BASIC_GUN,
    FLASHLIGHT,
    FLASHLIGHT_OFF,
    PAINT,
    FOOTPRINT,
    GUARD,
    WALL,
    CUBICLE,
    FRENZIED,
    CALM,
    CURSOR,
    PRISON_BARS,
    PRISONER;

    Paths() {
    }

    public String toString() {
        switch (this) {
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
            case FLASHLIGHT_OFF:
                return "/resources/flashlightOff.png";
            case FOOTPRINT:
                return "/resources/footprint.png";
            case FRENZIED:
                return "/resources/frenzied.png";
            case CALM:
                return "/resources/calm.png";
            case CURSOR:
                return "/resources/cursor.png";
            case PRISON_BARS:
                return "/resources/prisonBars.png";
            case PRISONER:
                return "/resources/guard.png";
        }
        return "";
    }
}