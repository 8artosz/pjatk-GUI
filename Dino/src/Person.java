import java.awt.*;
import java.awt.image.BufferedImage;

public class Person {
    private float x = 0;
    private float y = 0;
    private double speedy = 0;
    public BufferedImage characterImage;
    private boolean isAlive = true;
    public Person(){
        characterImage = Images.getImage("data/main-character1.png");
    }
    public void update(){
        if(y>= Image.groundY-characterImage.getHeight()){
            speedy=0;
            y= Image.groundY-characterImage.getHeight();
        }else {
            speedy += 0.4;
            y += speedy;
        }
    }
    public void draw(Graphics g){
        g.setColor(Color.black);
        g.drawImage(characterImage,(int)x,(int)y,null);
    }

    public void jump(){
        if(y== Image.groundY-characterImage.getHeight()) {
            speedy = -7.5;
            y += speedy;
        }
    }

    public float getX(){
        return x;
    }
    public void setX(float x){
        this.x=x;
    }
    public float getY(){
        return y;
    }
    public void setY(float y){
        this.y=y;
    }
    public void setAlive(boolean alive){
        isAlive=alive;
    }
    public boolean getAlive(){
        return isAlive;
    }

}
