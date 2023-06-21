package cs3500.pa05.controller.bujofile;

import cs3500.pa05.model.Calendar;
import cs3500.pa05.view.StyleType;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;

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

    if (!scene.getStylesheets().isEmpty()) {
      scene.getStylesheets().remove(0, 1);
    }

    if (calendar.getStyleType() == StyleType.NORMAL) {
        scene.getStylesheets().add("Pink.css");
        calendar.setStyleType(StyleType.PINK);
      } else if (calendar.getStyleType() == StyleType.PINK) {
        scene.getStylesheets().add("Dark.css");
        calendar.setStyleType(StyleType.DARK);
      } else if (calendar.getStyleType() == StyleType.DARK) {
        scene.getStylesheets().add("Fonto.css");
        calendar.setStyleType(StyleType.FONTO);
      } else if (calendar.getStyleType() == StyleType.FONTO) {
        scene.getStylesheets().add("Normal.css");
        calendar.setStyleType(StyleType.NORMAL);
      }


      //    /Users/aspentabar/Desktop/ CS3500/pa05-boujeebujo/src/main/resources/bouje.bujo


  }


}