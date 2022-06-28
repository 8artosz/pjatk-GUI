import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Clouds {
        private BufferedImage cloudImage;
        private List<Cloud> clouds;
        public Clouds() {
            cloudImage = Images.getImage("data/cloud.png");
            clouds = new ArrayList<Cloud>();

            Cloud cloud = new Cloud();
            cloud.x = 100;
            cloud.y = 50;
            clouds.add(cloud);

            cloud = new Cloud();
            cloud.x = 200;
            cloud.y = 30;
            clouds.add(cloud);

            cloud = new Cloud();
            cloud.x = 300;
            cloud.y = 40;
            clouds.add(cloud);

            cloud = new Cloud();
            cloud.x = 450;
            cloud.y = 50;
            clouds.add(cloud);

            cloud = new Cloud();
            cloud.x = 600;
            cloud.y = 60;
            clouds.add(cloud);
        }
        public void update(){
            for(Cloud chmura : clouds){
                chmura.x --;
            }
            Cloud pom = clouds.get(0);
            if(pom.x + cloudImage.getWidth() < 0){
                pom.x = 600;
                clouds.remove(pom);
                clouds.add(pom);
            }
        }
        public void draw(Graphics g){
            for(Cloud chmura : clouds){
                g.drawImage(cloudImage, (int) chmura.x, (int) chmura.y, null);
            }
        }
    }
    class Cloud {
        float x,y;
    }
