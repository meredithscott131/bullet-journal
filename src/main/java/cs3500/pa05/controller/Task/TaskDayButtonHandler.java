package cs3500.pa05.controller.Task;

import cs3500.pa05.model.DayWeek;
import cs3500.pa05.model.Task;
import javafx.event.Event;
import javafx.event.EventHandler;

/**
 * Represents the handler for the day button in the task popup.
 */
public class TaskDayButtonHandler implements EventHandler {
  private final DayWeek dayWeek;
  private final Task task;

  /**
   * Instantiates a new Task day button handler.
   *
   * @param dayWeek the day week
   * @param task    the task
   */
  public TaskDayButtonHandler(DayWeek dayWeek, Task task) {
    this.task = task;
    this.dayWeek = dayWeek;
  }

  /**
   * Handles the button action event
   */
  @Override
  public void handle(Event event) {
    task.setDay(dayWeek);
  }
}
