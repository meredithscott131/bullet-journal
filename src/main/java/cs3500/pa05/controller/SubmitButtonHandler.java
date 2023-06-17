package cs3500.pa05.controller;

import cs3500.pa05.model.Calendar;
import cs3500.pa05.model.EventIn;
import cs3500.pa05.view.gui.PopupView;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class SubmitButtonHandler implements EventHandler {

  EventIn eventIn;

  String nameTask;

  String nameDecription;

  int duration;

  String startTime;


  SubmitButtonHandler(EventIn eventIn, String nameTask, String nameDecription,
                      String startTime, int duration) {
    this.eventIn = eventIn;
    this.nameTask = nameTask;
    this.nameDecription = nameDecription;
    this.duration = duration;
    this.startTime = startTime;
  }


  @Override
  public void handle(Event event) {
    if(!isNullEvent()) {
      //nothing happens
    } else {
      setUserNameInput();
      setUserDescriptionInput();
      setUserDurationInput();
      //setStartTimeInput();
      System.out.println(nameTask.toString());
      System.out.println(nameDecription.toString());
      System.out.println(duration);
      //System.out.println(startTime.toString());
    }
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
    return eventIn.getName() == null
        && eventIn.getDescription() == null
        && eventIn.getStartTime() == null
        && eventIn.getDuration() == 0;
  }
}
