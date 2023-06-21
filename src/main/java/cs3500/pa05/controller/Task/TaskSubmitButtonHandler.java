package cs3500.pa05.controller.Task;

import cs3500.pa05.model.Calendar;
import cs3500.pa05.model.Day;
import cs3500.pa05.model.EventIn;
import cs3500.pa05.model.Task;
import cs3500.pa05.model.UserCalInput;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.stage.Stage;

public class TaskSubmitButtonHandler implements EventHandler {
  private final Task task;
  private final Calendar calendar;
  private final String nameTask;
  private final String nameDecription;
  private final Stage stage;

  public TaskSubmitButtonHandler(Calendar calendar, Task task, String nameTask,
                             String nameDecription, Stage stage) {
    this.calendar = calendar;
    this.task = task;
    this.nameTask = nameTask;
    this.nameDecription = nameDecription;
    this.stage = stage;
  }

  @Override
  public void handle(Event event) {
    if(isNullEvent()) {
      //nothing happens
    } else {
      // Adds event to calendar object
      setUserNameInput();
      setUserDescriptionInput();

      Day dayToAddTo = this.calendar.getOneDay(task.getDayWeek());
      //dayToAddTo.getDayInputs().add(eventIn);
      this.calendar.getTotalUserInputs().add(task);
      dayToAddTo.getDayInputsObservable().add(task);

      Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
      window.close(); // closes popup window
    }
  }

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

  public void setUserDescriptionInput() {
    task.setDescription(nameDecription);
  }

  public boolean isNullEvent() {
    return nameTask == ""
        || task.getDayWeek() == null;
  }
}
