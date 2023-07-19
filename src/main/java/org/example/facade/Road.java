package org.example.facade;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Road extends JComponent {
    private static final int DELAY = 10;
    private static final int WINDOW_W = 400;
    private static final int WINDOW_H = 225;
    private final Image background;

    private final Car car;
    private final TrafficLights trafficLights;

    public Road() {
        Image image;
        try {
            background = ImageIO.read(new File("C:\\Users\\Marina\\IdeaProjects\\demo\\Pattern2\\src\\images\\road.jpg"));
            image = ImageIO.read(new File("C:\\Users\\Marina\\IdeaProjects\\demo\\Pattern2\\src\\images\\pink_car.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.car = new Car(image, 120, 40, 20, 165, WINDOW_W, 300);
        this.trafficLights = new TrafficLights(300, 150);
    }

    public void draw() {
        new Timer(DELAY, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actEvt) {
                repaint();
            }
        }).start();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(WINDOW_W, WINDOW_H);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, WINDOW_W, WINDOW_H, null);
        car.draw(g, trafficLights.draw(g));
    }

    public static void createAndShowGui() {
        Road road = new Road();
        road.draw();
        JFrame frame = new JFrame("Машинка");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(road);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Road.createAndShowGui();
            }
        });
    }
}


