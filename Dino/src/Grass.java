import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Grass {
    private List<ImageLand> listImage;
    private BufferedImage imageLand1;
    public Grass(){
        imageLand1 = Images.getImage("data/land2.png");
        listImage = new ArrayList<ImageLand>();
        int numberofparts = 600/imageLand1.getWidth()+2;
        for(int i=0; i<numberofparts; i++){
            ImageLand imageLand = new ImageLand();
            imageLand.x = (int) (i * imageLand1.getWidth());
            imageLand.image=imageLand1;
            listImage.add(imageLand);
        }
    }
    public void update(){
        for(ImageLand imageLand: listImage){
            imageLand.x-=5;
        }
        ImageLand firstElement = listImage.get(0);
        if(firstElement.x + imageLand1.getWidth() < 0){
            firstElement.x = listImage.get(listImage.size()-1).x + imageLand1.getWidth();
            listImage.add(firstElement);
            listImage.remove(0);
        }
    }
    public void draw (Graphics g){
        for(ImageLand imageLand : listImage) {
            g.drawImage(imageLand.image, imageLand.x, 90, null);
        }
    }
}
class ImageLand{
    int x;
    BufferedImage image;
}
