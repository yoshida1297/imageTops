package framebone;

import java.util.*;

public class WidgetContainer {

  public static List<WidgetFrame> contain = new ArrayList<>();

  public WidgetContainer() {
    WidgetFrame mainframe = new Widget();
    contain.add(mainframe);
  }

  public static void addWidget() {
    WidgetFrame newWidget = new Widget();
    contain.add(newWidget);
    System.out.println(contain.size());
  }

  public static void removeWidget(WidgetFrame w) {
    contain.removeIf(widget -> widget.equals(w));
    if (contain.size() == 0) {
      System.exit(0);
    }
    System.out.println(contain.size());
  }

}
