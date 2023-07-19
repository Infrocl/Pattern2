package org.example.facade;

import javax.swing.*;
import java.awt.*;

public class TrafficLights extends JComponent {
    private final int x;
    private final int y;
    private Color color = Color.GREEN;
    private int lightTime = 0;


    public TrafficLights(int x, int y) {
        this.x = x;
        this.y = y;
    }

    private void changeColor() {
        lightTime++;
        if (color == Color.GREEN && lightTime > 135) {
            lightTime = 0;
            color = Color.YELLOW;
        }
        if (color == Color.YELLOW && lightTime > 55) {
            lightTime = 0;
            color = Color.RED;
        }
        if (color == Color.RED && lightTime > 100) {
            lightTime = 0;
            color = Color.GREEN;
        }
    }

    public Color draw(Graphics g) {
        changeColor();
        g.setColor(Color.GRAY);
        g.fillRect(x + 10, y - 30, 10, 50);
        g.fillRect(x, y - 60, 30, 40);
        g.setColor(color);
        g.fillOval(x + 2, y - 60, 25, 25);
        return g.getColor();
    }
}
