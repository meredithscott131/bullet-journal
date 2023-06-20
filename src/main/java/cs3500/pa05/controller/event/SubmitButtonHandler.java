package cs3500.pa05.controller.event;

import cs3500.pa05.model.Calendar;
import cs3500.pa05.model.Day;
import cs3500.pa05.model.EventIn;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.stage.Stage;

public class SubmitButtonHandler implements EventHandler {
  private final EventIn eventIn;
  private final Calendar calendar;
  private final String nameTask;
  private final String nameDecription;
  private final int duration;
  private final String startTime;

 public SubmitButtonHandler(Calendar calendar, EventIn eventIn, String nameTask,
                            String nameDecription, String startTime, int duration) {
    this.calendar = calendar;
    this.eventIn = eventIn;
    this.nameTask = nameTask;
    this.nameDecription = nameDecription;
    this.duration = duration;
    this.startTime = startTime;
  }

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

  public void setUserNameInput() {
    eventIn.setName(nameTask);
  }

  public void setUserDescriptionInput() {
    eventIn.setDescription(nameDecription);
  }

  public void setUserDurationInput() {
    eventIn.setDuration(duration);
  }

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