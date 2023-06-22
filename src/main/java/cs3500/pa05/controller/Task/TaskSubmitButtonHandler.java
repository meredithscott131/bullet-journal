package cs3500.pa05.controller.Task;

import cs3500.pa05.model.Calendar;
import cs3500.pa05.model.Day;
import cs3500.pa05.model.EventIn;
import cs3500.pa05.model.Task;
import cs3500.pa05.model.UserCalInput;
import java.util.Objects;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.stage.Stage;

/**
 * Represents the handler for the task popup submit button.
 */
public class TaskSubmitButtonHandler implements EventHandler {
  private final Task task;
  private final Calendar calendar;
  private final String nameTask;
  private final String nameDescription;

  /**
   * Instantiates a new task submit button handler.
   *
   * @param calendar       the calendar
   * @param task           the task
   * @param nameTask       the name task
   * @param nameDescription the name description
   */
  public TaskSubmitButtonHandler(Calendar calendar, Task task, String nameTask,
                                 String nameDescription) {
    this.calendar = calendar;
    this.task = task;
    this.nameTask = nameTask;
    this.nameDescription = nameDescription;
  }

  /**
   * Handles a submit button press.
   */
  @Override
  public void handle(Event event) {
    if (isNullEvent()) {
      //nothing happens
    } else {
      // Adds event to calendar object
      setUserNameInput();
      setUserDescriptionInput();

      Day dayToAddTo = this.calendar.getOneDay(task.getDayWeek());
      this.calendar.getTotalUserInputs().add(task);
      dayToAddTo.getDayInputsObservable().add(task);

      Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
      window.close(); // closes popup window
    }
  }

  /**
   * Sets the task's name and determines whether the user
   * assigned this task to a category
   */
  public void setUserNameInput() {
    if (nameTask.startsWith("#")) {
      String[] titleArr = nameTask.split(" ", 2);
      this.task.setCategory(titleArr[0].substring(1));
      this.calendar.addCategory(titleArr[0].substring(1));
      this.task.setName(titleArr[1]);
    } else {
      this.task.setName(nameTask);
    }
  }

  /**
   * Sets the task description.
   */
  public void setUserDescriptionInput() {
    task.setDescription(nameDescription);
  }

  /**
   * Determines whether this event has any null values
   *
   * @return whether there are any null values
   */
  public boolean isNullEvent() {
    return Objects.equals(nameTask, "")
        || task.getDayWeek() == null;
  }
}
