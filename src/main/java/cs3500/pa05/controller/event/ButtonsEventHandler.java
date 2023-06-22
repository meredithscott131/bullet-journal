package cs3500.pa05.controller.event;

import cs3500.pa05.model.Calendar;
import cs3500.pa05.view.gui.PopupView;
import javafx.event.Event;
import  javafx.event.EventHandler;
import javafx.stage.Stage;

/**
 * Represents the handler for the buttons in the event popup
 */
public class ButtonsEventHandler implements EventHandler {
  private final Calendar calendar;

  /**
   * Instantiates a new buttons event handler.
   *
   * @param calendar the calendar
   */
  public ButtonsEventHandler(Calendar calendar) {
    this.calendar = calendar;
  }

  /**
   * Handles a button press
   */
  @Override
  public void handle(Event event) {
    Stage stage = new Stage();
    PopupController popupController = new PopupController(this.calendar);
    PopupView popupView = new PopupView(popupController);
    stage.setScene(popupView.load());

    stage.show();
    popupController.run();
  }
}
