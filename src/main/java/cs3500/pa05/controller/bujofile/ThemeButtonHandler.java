package cs3500.pa05.controller.bujofile;

import cs3500.pa05.controller.event.PopupController;
import cs3500.pa05.model.Calendar;
import cs3500.pa05.view.StyleType;
import cs3500.pa05.view.gui.PopupView;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ThemeButtonHandler implements EventHandler {

  private Calendar calendar;


  private Button button;


  public ThemeButtonHandler(Calendar calendar, Button button) {
    this.calendar = calendar;
    this.button = button;
  }


  @Override
  public void handle(Event event) {

    Scene scene = button.getScene();
      //only traveling down the if statement once
      if (calendar.getStyleType() == StyleType.NORMAL) {
        scene.getStylesheets().add("Pink.css");
        calendar.setStyleType(StyleType.PINK);
      } else if (calendar.getStyleType() == StyleType.PINK) {
        scene.getStylesheets().add("Dark.css");
        calendar.setStyleType(StyleType.DARK);
      } else if (calendar.getStyleType() == StyleType.DARK) {
        scene.getStylesheets().add("Light.css");
        calendar.setStyleType(StyleType.LIGHT);
      } else if (calendar.getStyleType() == StyleType.LIGHT) {
        scene.getStylesheets().add("Pink.css");
        calendar.setStyleType(StyleType.PINK);
        System.out.println(calendar.getStyleType());
      }


      //    /Users/aspentabar/Desktop/ CS3500/pa05-boujeebujo/src/main/resources/bouje.bujo


  }


}
