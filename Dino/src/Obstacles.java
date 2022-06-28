import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Obstacles {
    private List<Obstacle> przeszkody;
    private Random random;
    private BufferedImage image1,image2;
    private Person person;
    public Obstacles(Person person){
        this.person = person;
        przeszkody = new ArrayList<Obstacle>();
        image1 = Images.getImage("data/cactus1.png");
        image2 = Images.getImage("data/cactus2.png");
        random = new Random();
        przeszkody.add(getRandom());
        random = new Random();
    }
    public void update(){
        for(Obstacle p : przeszkody){
            p.update();
            if(p.getX()==90 && person.getY()>43){
                    person.setAlive(false);
                }
            }
        Obstacle pom = przeszkody.get(0);
        if(pom.isoutofscreen()){
            przeszkody.remove(pom);
            przeszkody.add(getRandom());
        }
    }

    public void draw(Graphics g){
        for(Obstacle p : przeszkody)
            p.draw(g);
    }
    public void reset(){
        przeszkody.clear();
        przeszkody.add(getRandom());
    }

    private Tree getRandom(){
        Tree tree;
        tree = new Tree(person);
        tree.setX(600);
        if(random.nextBoolean()){
            tree.setImage(image1);
        }else{
            tree.setImage(image2);
        }
        return tree;
    }
}
