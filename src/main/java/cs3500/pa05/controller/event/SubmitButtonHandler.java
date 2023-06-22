package cs3500.pa05.controller.event;

import cs3500.pa05.model.Calendar;
import cs3500.pa05.model.Day;
import cs3500.pa05.model.EventIn;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.stage.Stage;

/**
 * SubmitButtonHandler class controls the submit button
 */
public class SubmitButtonHandler implements EventHandler {
  private final EventIn eventIn;
  private final Calendar calendar;
  private final String nameTask;
  private final String nameDecription;
  private final int duration;
  private final String startTime;


  /**
   * Controller #1
   */
 public SubmitButtonHandler(Calendar calendar, EventIn eventIn, String nameTask,
                            String nameDecription, String startTime, int duration) {
    this.calendar = calendar;
    this.eventIn = eventIn;
    this.nameTask = nameTask;
    this.nameDecription = nameDecription;
    this.duration = duration;
    this.startTime = startTime;
  }

  /**
   *  handle method for the submit button
   */
  @Override
  public void handle(Event event) {
    // Adds event to calendar object
    setUserNameInput();
    setUserDescriptionInput();
    setUserDurationInput();
    setStartTimeInput();

    Day dayToAddTo = this.calendar.getOneDay(eventIn.getDayWeek());

    this.calendar.getTotalUserInputs().add(eventIn);
    dayToAddTo.getDayInputsObservable().add(eventIn);

    Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
    window.close(); // closes popup window
  }

  /**
   * setUserNameInput sets the user input for the name
   */
  public void setUserNameInput() {
    if (nameTask.startsWith("#")) {
      String[] titleArr = nameTask.split(" ", 2);
      this.eventIn.setCategory(titleArr[0].substring(1));
      this.calendar.addCategory(titleArr[0].substring(1));
      this.eventIn.setName(titleArr[1]);
    } else {
      this.eventIn.setName(nameTask);
    }
  }

  /**
   * setUserDescriptionInput is the setter for a description from the user
   */
  public void setUserDescriptionInput() {
    eventIn.setDescription(nameDecription);
  }

  /**
   * setUserDurationInput is the setter for a duration from the user
   */
  public void setUserDurationInput() {
    eventIn.setDuration(duration);
  }

  /**
   * setStartTimeInput is the setter for a start time from the user
   */
  public void setStartTimeInput() {
    eventIn.setStartTime(startTime);
  }

  public boolean isNullEvent() {
    return nameTask == ""
        || eventIn.getDayWeek() == null
        || duration == 0
        || startTime == "";
  }
}
