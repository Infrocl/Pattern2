package org.example.facade;

import java.awt.*;
import javax.swing.*;

public class Car extends JComponent {
    private final Image image;
    private final int rightBorder;
    private final int width;
    private final int height;
    private int x;
    private final int y;
    private final int stopLine;

    public Car(Image image,int width, int height, int x, int y, int rightBorder, int stopLine) {
        this.image = image;
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.rightBorder = rightBorder;
        this.stopLine = stopLine;
    }

    private void move(Color color) {
        if (x != stopLine - width || color == Color.GREEN) {
            x += 1;
            if (x >= rightBorder) {
                x = 0;
            }
        }
    }

    public void draw(Graphics g, Color color) {
        move(color);
        g.drawImage(image, x, y, width, height, null);
    }
}
