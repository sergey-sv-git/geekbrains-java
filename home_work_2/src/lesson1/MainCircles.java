package lesson1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainCircles extends JFrame {
    private static final int POS_X = 300;
    private static final int POS_Y = 50;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;

    Sprite[] sprites = new Sprite[10];
    private static int count = 0;
    Sprite newSprite;
    Sprite addSprite[] = new Sprite[0];
    Sprite spriteFinal[];

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainCircles();
            }
        });
    }

    private MainCircles() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        initApplication();
        GameCanvas canvas = new GameCanvas(this);
        add(canvas, BorderLayout.CENTER);
        setTitle("Circles");
        setVisible(true);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1){
                    count++;
                    plusSprite();
                }
                if (e.getButton() == MouseEvent.BUTTON3){
                    if (count>0){
                        count--;
                        minusSprite();
                    }
                }
            }
        });
    }

    private void initApplication() {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i] = new Ball();
        }
    }

    private void plusSprite(){
        newSprite = new Ball();
        spriteFinal = new Sprite[count];
        spriteFinal[count - 1] = newSprite;
        for (int i = 0; i < spriteFinal.length-1; i++) {
            spriteFinal[i] = addSprite[i];
        }
        addSprite = new Sprite[count];
        for (int i = 0; i < addSprite.length; i++) {
            addSprite[i] = spriteFinal[i];
        }
    }

    private void minusSprite(){
        spriteFinal = new Sprite[count];
        for (int i = 0; i < spriteFinal.length; i++) {
            spriteFinal[i] = addSprite[i];
        }
    }
    private void minusFirstSprites(){

    }

    public void onDrawFrame(GameCanvas canvas, Graphics g, float deltaTime) {
        update(canvas, deltaTime); // obnovlenie // S = v * t
        render(canvas, g); // otrisovka
    }

    private void update(GameCanvas canvas, float deltaTime) {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i].update(canvas, deltaTime);
        }
        if (count > 0){
            for (int i = 0; i < spriteFinal.length; i++) {
                spriteFinal[i].update(canvas, deltaTime);
            }
        }
    }

    private void render(GameCanvas canvas, Graphics g) {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i].render(canvas, g);
        }
        if (count > 0){
            for (int i = 0; i < spriteFinal.length; i++) {
                spriteFinal[i].render(canvas, g);
            }
        }
    }

}
