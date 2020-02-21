package framebone;

import java.awt.*;
import java.awt.event.*;
import java.util.Date;

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;

public class WidgetFrame extends JFrame {

  // マウスクリック用のハンドラ
  static Point mouseDownCompCoords;
  double scale = 1.0;
  public final Long generateTime = new Date().getTime();
  public JPopupMenu popup;

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

    popup = new JPopupMenu();
    JMenuItem menu1 = new JMenuItem("tester");
    popup.add(menu1);
  }

  // キー入力設定
  public void keyBindSetting() {
    addKeyListener(new KeyListener() {
      public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_ESCAPE) {
          remove();
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
        if (e.getButton() == 1) {
          mouseDownCompCoords = null;
        } else if (e.getButton() == 3) {
          showPopup(e);
        }
      }

      public void mousePressed(MouseEvent e) {
        if (e.getButton() == 1) {
          mouseDownCompCoords = e.getPoint();
        }
      }
    });
    addMouseMotionListener(new MouseMotionListener() {
      public void mouseMoved(MouseEvent e) {
      }

      public void mouseDragged(MouseEvent e) {
        if (mouseDownCompCoords != null) {
          Point currCoords = e.getLocationOnScreen();
          setLocation(currCoords.x - mouseDownCompCoords.x, currCoords.y - mouseDownCompCoords.y);
        }
      }
    });

    addMouseWheelListener(new MouseInputAdapter() {
      @Override
      public void mouseWheelMoved(MouseWheelEvent e) {
        if (e.getWheelRotation() == -1) {
          scale += 0.25;
        } else if (e.getWheelRotation() == 1) {
          if (scale > 0.25) {
            scale -= 0.25;
          }
        }
        paint();
      }
    });

  }

  private void showPopup(MouseEvent e) {
    popup.show(e.getComponent(), e.getX(), e.getY());
  }

  public void paint() {
    // not
  }

  protected void remove() {
    WidgetContainer.removeWidget(this);
    dispose();
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o == null) {
      return false;
    }
    if (!(o instanceof WidgetFrame)) {
      return false;
    }
    WidgetFrame object = (WidgetFrame) o;
    if (object.generateTime.equals(this.generateTime)) {
      return true;
    } else {
      return false;
    }
  }

}
