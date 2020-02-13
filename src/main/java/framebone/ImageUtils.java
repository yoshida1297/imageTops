package framebone;

import javax.swing.*;
import java.awt.*;

public class ImageUtils extends Component {

    public ImageIcon scaleImage(double scale, String file) {
        ImageIcon image = new ImageIcon(file);
        int width = image.getIconWidth();
        MediaTracker tracker = new MediaTracker(this);
        Image img = image.getImage().getScaledInstance((int) (width * scale), -1, Image.SCALE_SMOOTH);
        tracker.addImage(img, 1);
        image = new ImageIcon(img);
        return image;
    }

    public ImageIcon scaleImage(double scale, ImageIcon im) {
        ImageIcon image = im;
        int width = image.getIconWidth();
        MediaTracker tracker = new MediaTracker(this);
        Image img = image.getImage().getScaledInstance((int) (width * scale), -1, Image.SCALE_SMOOTH);
        tracker.addImage(img, 1);
        image = new ImageIcon(img);
        return image;
    }
}
