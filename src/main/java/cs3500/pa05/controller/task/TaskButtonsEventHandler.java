package cs3500.pa05.controller.task;

import cs3500.pa05.model.Calendar;
import cs3500.pa05.view.gui.TaskPopupView;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.stage.Stage;

/**
 * Represents the handler for the task button event
 */
public class TaskButtonsEventHandler implements EventHandler {
  private final Calendar calendar;

  /**
   * Instantiates a new task buttons event handler.
   *
   * @param calendar the calendar
   */
  public TaskButtonsEventHandler(Calendar calendar) {
    this.calendar = calendar;
  }

  /**
   * Handles the event.
   *
   * @param event action event
   */
  @Override
  public void handle(Event event) {
    Stage stage = new Stage();
    TaskPopupController popupController = new TaskPopupController(this.calendar);
    TaskPopupView popupView = new TaskPopupView(popupController);
    stage.setScene(popupView.load());
    stage.show();
    popupController.run();
  }
}