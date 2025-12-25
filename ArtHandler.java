import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class ArtHandler extends JPanel {
    private final List<BufferedImage> images = new ArrayList<>();
     

    public ArtHandler() {
        super();
    }

    /**
     * Add an image to the panel for drawing.
     * The image will fill the panel.
     */
    public void draw(BufferedImage img) {
        if (img != null) {
            images.add(img);
            repaint(); // Trigger re-draw
        }
    }

    /**
     * Optional: clear all images
     */
    public void clear() {
        images.clear();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw all images stored in the list
        for (BufferedImage img : images) {
            g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
        }
    }

}
