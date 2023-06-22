package cs3500.pa05.controller.title;

import cs3500.pa05.model.Calendar;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * Represents the handler for the title popup
 */
public class TitlePopupHandler implements EventHandler {
  private final Calendar calendar;
  private final Label titleLabel;

  /**
   * Instantiates a new title popup handler.
   *
   * @param calendar   the calendar
   * @param titleLabel the title label
   */
  TitlePopupHandler(Calendar calendar, Label titleLabel) {
    this.calendar = calendar;
    this.titleLabel = titleLabel;
  }

  /**
   * Handles the submit button press from the user
   */
  @Override
  public void handle(Event event) {
    Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
    window.close(); // closes popup window
    this.titleLabel.setText(this.calendar.getName());
  }
}
