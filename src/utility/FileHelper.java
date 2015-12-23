package utility;

import startup.GameController;

import java.util.ArrayList;
import java.util.Scanner;


public class FileHelper {

    GameController _gc;

    public FileHelper(GameController gc) {
        _gc = gc;
    }

    public ArrayList<String> getValues(Scanner sc) {
        String textLine = sc.nextLine();
        ArrayList<String> values = new ArrayList();
        while (textLine.contains(" ")) {
            values.add(textLine.substring(0, textLine.indexOf(' ')));
            textLine = textLine.substring(textLine.indexOf(' ') + 1, textLine.length());
        }
        values.add(textLine);
        return values;
    }
}