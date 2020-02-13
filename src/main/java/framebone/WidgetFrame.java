package framebone;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.MouseInputAdapter;

public class WidgetFrame extends JFrame {

    // マウスクリック用のハンドラ
    static Point mouseDownCompCoords;
    double scale = 1.0;

    public WidgetFrame() {
        // 常時前面表示
        setAlwaysOnTop(true);
        // タイトルバーの表示を無効化
        setUndecorated(true);

        getContentPane().setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Widget");
        setVisible(true);

        // 確認のため青色に表示
        setBackground(new Color(0, 0, 255, 100));
        // setSize(300, 300)
        mouseSetting();
        keyBindSetting();

    }

    // キー入力設定
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
            }

            public void keyReleased(KeyEvent e) {
            }

            public void keyTyped(KeyEvent e) {
            }
        });
    }

    // マウスモーション設定
    public void mouseSetting() {
        addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e) {
                mouseDownCompCoords = null;
            }

            public void mousePressed(MouseEvent e) {
                mouseDownCompCoords = e.getPoint();
            }
        });
        addMouseMotionListener(new MouseMotionListener() {
            public void mouseMoved(MouseEvent e) {
            }

            public void mouseDragged(MouseEvent e) {
                Point currCoords = e.getLocationOnScreen();
                setLocation(currCoords.x - mouseDownCompCoords.x, currCoords.y - mouseDownCompCoords.y);
            }

        });
        addMouseWheelListener(new MouseInputAdapter() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                if (e.getWheelRotation() == -1) {
                    scale+=0.25;
                } else if (e.getWheelRotation() == 1) {
                    if(scale > 0.25) {
                        scale -= 0.25;
                    }
                }
                paint();
            }
        });

    }

    public void paint(){
        // not
    }

    @Override
    public boolean equals(Object o){
      if(o == this){
        return true;
      }
      if(o == null){
        return false;
      }
      if(!(o instanceof WidgetFrame)){
        return false;
      }
      WidgetFrame object = (WidgetFrame) o;
      if(object.equals(this)){
        return true;
      }
      else{
        return false;
      }
    }

}
