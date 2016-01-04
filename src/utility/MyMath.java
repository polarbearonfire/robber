package utility;

/**
 * Created by danecarlson on 9/24/2015.
 */
public class MyMath {

    public static double findAngleOfTwoPoints(Coord origin, Coord other) {

        double x1 = origin.getX();
        double y1 = origin.getY();

        double x2 = other.getX();
        double y2 = other.getY();


        double width = Math.abs(x2 - x1);
        double height = Math.abs(y2 - y1);
        double hyp = Math.sqrt(Math.pow(width, 2) + Math.pow(height, 2));

        double angle = Math.asin(height / hyp);
        angle = Math.toDegrees(angle);
        if (x2 < x1) {
            angle = 180 - angle;
        }
        if (y2 > y1) {
            angle = 360 - angle;
        }

        return angle;

    }

    public static double findAngleOfTwoPoints(double x1, double y1, double x2, double y2) {

        double width = Math.abs(x2 - x1);
        double height = Math.abs(y2 - y1);
        double hyp = Math.sqrt(Math.pow(width, 2) + Math.pow(height, 2));

        double angle = Math.asin(height / hyp);
        angle = Math.toDegrees(angle);
        if (x2 < x1) {
            angle = 180 - angle;
        }
        if (y2 > y1) {
            angle = 360 - angle;
        }

        return angle;

    }

    public static double getDistanceBetweenTwoPoints(double x1, double y1, double x2, double y2) {
        double width = Math.abs(x1 - x2);
        double height = Math.abs(y1 - y2);

        return Math.sqrt(Math.pow(width, 2) + Math.pow(height, 2));
    }
}
