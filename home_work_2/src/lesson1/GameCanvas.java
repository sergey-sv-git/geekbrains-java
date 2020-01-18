package lesson1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameCanvas extends JPanel {

    MainCircles gameController;
    long lastFrameTime;
    BackGround backGround;
    Sprite addSprite;
    int count = 0;

    GameCanvas(MainCircles gameController) {

        this.gameController = gameController;
        lastFrameTime = System.nanoTime();
        backGround = new BackGround();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //60fps
        long currentTime = System.nanoTime();
        float deltaTime = (currentTime - lastFrameTime) * 0.000000001f;
        gameController.onDrawFrame(this, g, deltaTime);
        lastFrameTime = currentTime;
        setBackground(backGround.getNewColor());
        try {
            Thread.sleep(16);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        repaint();
    }

    public int getLeft() { return 0; }
    public int getRight() { return getWidth() - 1; }
    public int getTop() { return 0; }
    public int getBottom() { return getHeight() - 1; }
}
