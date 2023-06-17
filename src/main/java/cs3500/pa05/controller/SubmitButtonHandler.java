package cs3500.pa05.controller;

import cs3500.pa05.model.Calendar;
import cs3500.pa05.model.Day;
import cs3500.pa05.model.EventIn;
import cs3500.pa05.view.gui.PopupView;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class SubmitButtonHandler implements EventHandler {

  EventIn eventIn;

  Calendar calendar;

  String nameTask;

  String nameDecription;

  int duration;

  String startTime;


 public SubmitButtonHandler(Calendar calendar, EventIn eventIn, String nameTask, String nameDecription,
                      String startTime, int duration) {
    System.out.println(nameTask +  nameDecription + startTime + duration);

   this.calendar = calendar;
    this.eventIn = eventIn;
    this.nameTask = nameTask;
    this.nameDecription = nameDecription;
    this.duration = duration;
    this.startTime = startTime;
  }


  @Override
  public void handle(Event event) {
    if(isNullEvent()) {
      System.out.println("Null " + nameTask);
      System.out.println("Null " + nameDecription);
      System.out.println("Null " + duration);
      //nothing happens
    } else {
      System.out.println("nametask = " + nameTask);
      System.out.println("des = " + nameDecription);
      System.out.println("dur = " + startTime);
      System.out.println("dur = " + duration);

      setUserNameInput();
      setUserDescriptionInput();
      setUserDurationInput();
      setStartTimeInput();
      Day dayToAddTo = calendar.getOneDay(eventIn.getDayWeek());
      dayToAddTo.getDayInputs().add(eventIn);

      System.out.println("event name " + eventIn.getName() + "\n"
          + "event D " + eventIn.getDescription() + "\n"
          + "event dayweek " + eventIn.getDayWeek() + "\n"
          + "event start " + eventIn.getStartTime() + "\n"
          + "event duration " + eventIn.getDuration() + "\n");

      System.out.println("Day " + dayToAddTo.getDayInputs().get(0).getName() + "\n");





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
    return nameTask == ""
        || nameDecription == ""
        || eventIn.getDayWeek() == null
        || duration == 0
        || startTime == "";
  }
}
