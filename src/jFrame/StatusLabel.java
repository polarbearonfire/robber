package jFrame;

import startup.GameController;

import javax.swing.*;
import java.awt.*;

public class StatusLabel
        extends JLabel {
    private static final long serialVersionUID = 7380123579708902387L;
    GameController _controller;
    String _notification, _message;

    public StatusLabel(GameController gc) {
        _controller = gc;
        _notification = "";
        //this.setBackground(Color.PINK);
        //this.setOpaque(true);
    }

    public void setNotification(String toSet) {
        _notification = toSet;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setFont(new Font("TimesRoman", Font.BOLD, 23));
        g.setColor(Color.red);
        g.drawString(_notification, 0, 100);

        if (_message != null) {
            g.drawString(_message, 500, 100);
        }
    }

    public void displayMessage(String nextMessage) {
        _message = nextMessage;
    }
}
