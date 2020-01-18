package lesson1;
import java.awt.*;

public class Sprite {
    protected float x;
    protected float y;
    protected float halfWidth;
    protected float halfHight;

    protected float getLeft(){return x - halfWidth;}
    protected void setLeft(float left){x = left + halfWidth;}
    protected float getRight(){return x + halfWidth;}
    protected void setRight(float right){x = right - halfWidth;}
    protected float getTop(){return y - halfHight;}
    protected void setTop(float top){y = top + halfHight;}
    protected float getBottom(){return y + halfHight;}
    protected void setBottom(float bottom){y = bottom - halfHight;}
    protected float getWidth(){return 2f*halfWidth;}
    protected float getHight(){return 2f*halfHight;}

    void update(GameCanvas canvas, float deltaTime){}
    void render(GameCanvas canvas, Graphics g){}
}
