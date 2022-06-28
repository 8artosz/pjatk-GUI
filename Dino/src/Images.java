import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Images {
    public static BufferedImage getImage (String path){
        BufferedImage img = null;
        try{
            img = ImageIO.read(new File(path));
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        return img;
    }
}
