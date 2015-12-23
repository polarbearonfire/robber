package utility;

import Interface.IDrawableObject;
import startup.GameController;


public class FileHelper {

    GameController _gc;

    public FileHelper(GameController gc) {
        _gc = gc;
    }

    public String[] getValues(String textLine) {
        IDrawableObject toReturn = null;
        String[] values = new String[5];
        for (int i = 0; i < 4; i++) {
            values[i] = textLine.substring(0, textLine.indexOf(' '));
            textLine = textLine.substring(textLine.indexOf(' ') + 1, textLine.length());
        }
        values[4] = textLine;
        return values;
    }
}