import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ArtList{
    public static BufferedImage Loading;
    public static BufferedImage BobingtonAerial;
    static{
        try {
            Loading = ImageIO.read(ImagePanel.class.getResource("/Art/Colors4Fantasy.png"));
            BobingtonAerial = ImageIO.read(ImagePanel.class.getResource("/Art/Bobington.png"));
        } catch (IOException | IllegalArgumentException e) {
            // TODO Auto-generated catch block
            System.out.println("Error loading image");
            e.printStackTrace();
        }
    }
}
