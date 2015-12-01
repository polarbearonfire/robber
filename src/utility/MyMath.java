package utility;

/**
 * Created by danecarlson on 9/24/2015.
 */
public class MyMath {

    public static double findAngleOfTwoPoints(Coord origin, Coord other) {

        double x1 = origin.getX();
        double x2 = other.getX();

        double y1 = origin.getY();
        double y2 = other.getY();


        double width = x2 - x1;
        double height = y1 - y2;
        double hyp = Math.sqrt(Math.pow(width,2) + Math.pow(height,2));

        double angle = Math.asin(height / hyp);
        angle = Math.toDegrees(angle);

        if(width < 0){
            angle = 180 - angle;
        }
        if(angle < 0){
            angle = 360 + angle;
        }
        return angle;

    }
}
