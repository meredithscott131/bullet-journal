package cs3500.pa05.controller;

import cs3500.pa05.model.Calendar;
import cs3500.pa05.view.StyleType;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;

/**
 * Represents the handler for the theme button.
 */
public class ThemeButtonHandler implements EventHandler {
  private final Calendar calendar;
  private final Button button;

  /**
   * Instantiates a new theme button handler.
   *
   * @param calendar the calendar
   * @param button   the button
   */
  public ThemeButtonHandler(Calendar calendar, Button button) {
    this.calendar = calendar;
    this.button = button;
  }

  /**
   * Handles the theme button press
   */
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
  }
}