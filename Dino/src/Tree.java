import java.awt.*;
import java.awt.image.BufferedImage;

public class Tree extends Obstacle {
    private BufferedImage image;
    public int x,y;
    private Person person;
    public Tree(Person person){
        person = new Person();
        image = Images.getImage("data/cactus1.png");
        x=200;
        y=65;

    }
    public void update() {
        x -= 15  ;
    }
    @Override
    public void draw(Graphics g){
        g.drawImage(image,x,y,null);
    }
    @Override
    public int getX(){
        return x;
    }
    public void setX(int x){
        this.x=x;
    }
    @Override
    public int getY(){
        return y;
    }
    public void setY(int y){
        this.y=y;
    }
    public void setImage(BufferedImage image){
        this.image=image;
    }
    @Override
    public boolean isoutofscreen(){
        return(x + image.getWidth() < 0);
    }
}
