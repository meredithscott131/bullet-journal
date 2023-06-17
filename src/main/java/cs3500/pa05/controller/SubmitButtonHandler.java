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
      System.out.println("Nully" + nameTask.toString());
      System.out.println(nameDecription.toString());
      System.out.println(duration);
      //nothing happens
    } else {
      System.out.println(nameTask.toString());
      System.out.println(nameDecription.toString());
      System.out.println(duration);

      setUserNameInput();
      setUserDescriptionInput();
      setUserDurationInput();
      setStartTimeInput();
      //System.out.println(startTime.toString());
    }
  }

  //listener: obj that modifies or changes when looking at a certina property
  //when we click play we are reading whats in the text field
  //listener looks at the text field and tells us when we update the text field
  //onchange event listener --> listener that only listens when they stop typing
  //

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
