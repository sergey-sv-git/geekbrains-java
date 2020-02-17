package lesson1;

import java.awt.*;

public class BackGround {
    Color color = new Color(
            (int)(Math.random()*255),
            (int)(Math.random()*255),
            (int)(Math.random()*255));
    Color colorNew;
    long lastTime;
    BackGround(){
        lastTime = System.nanoTime();
    }
     public Color getNewColor(){
         long currentTime = System.nanoTime();
         float deltaTime = (currentTime - lastTime)*0.00000001f;
         if (deltaTime > 15){
             lastTime = currentTime;
             colorNew = new Color(
                     (int)(Math.random()*255),
                     (int)(Math.random()*255),
                     (int)(Math.random()*255));;
             color = colorNew;
             return colorNew;
         }
         else return color;
    }
}
