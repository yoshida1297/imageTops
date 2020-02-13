package framebone;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;

public class Widget extends WidgetFrame {

  private ImageIcon image;
  private ImageIcon imageScaling;
  private JLabel LabelImage = new JLabel();
  private JPanel pane = new JPanel();
  private String path;

  // choose
  public Widget() {
    JFileChooser chooser = new JFileChooser();
    boolean checker = false;
    while (checker == false) {
      if (chooser.showOpenDialog(this) == 0) {
        path = chooser.getSelectedFile().toString();

        // extension check
        String extension = path.substring(path.lastIndexOf(".") + 1);
        checker = extensionCheck(extension);
      }
      else {
        System.exit(0);
      }

      if(path != null) {
        new Widget(path);
      }
    }
  }

  // path
  public Widget(String path) {
    setBackground(new Color(0, 0, 0, 0.1f));
    image = new ImageIcon(path);
    paint();
  }

  @Override
  // @WidgetFrame
  public void paint() {
    pane.removeAll();
    imageScaling = new ImageUtils().scaleImage(scale, image);
    LabelImage.setIcon(imageScaling);
    // 背景に合わせてリサイズ
    setSize(imageScaling.getIconWidth(), imageScaling.getIconHeight());
    pane.setSize(imageScaling.getIconWidth(), imageScaling.getIconHeight());
    LabelImage.setBackground(new Color(0, 0, 0, 0));

    pane.add(LabelImage);
    add(pane);
  }

  private boolean extensionCheck(String path) {
    String[] extensions = {"jpeg", "png", "gif"};
    boolean match = Arrays.stream(extensions).anyMatch(s -> s.equals(path));
    return match;
  }


  @Override
  public void keyBindSetting() {
    addKeyListener(new KeyListener() {
      public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_ESCAPE) {

          if(WidgetContainer.contain.size() == 1){
            System.exit(0);
          }
          else{
            dispose();
          }
        }

        // t = new Image
        if( key == KeyEvent.VK_T){
          WidgetContainer.addWidget();
        }

        // r = repaint
        if (key == KeyEvent.VK_R) {
          paint();
        }
      }

      public void keyReleased(KeyEvent e) {
      }

      public void keyTyped(KeyEvent e) {
      }
    });
  }

}
