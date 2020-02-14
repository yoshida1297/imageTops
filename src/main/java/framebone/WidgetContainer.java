package framebone;

import java.util.*;

public class WidgetContainer{

  public static List<WidgetFrame> contain = new ArrayList<>();
  
  public WidgetContainer(){
    WidgetFrame mainframe = new Widget();
    contain.add(mainframe);
  }

  public static void addWidget(){
    WidgetFrame newWidget = new Widget();
    contain.add(newWidget);
    System.out.println(contain.size());
  }

  public static void removeWidget(WidgetFrame w){
     contain.removeIf(widget -> widget.equals(w));  
    System.out.println(contain.size());
  }

}
