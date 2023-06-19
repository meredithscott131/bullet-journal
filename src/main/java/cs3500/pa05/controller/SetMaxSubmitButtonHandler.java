package cs3500.pa05.controller;

import cs3500.pa05.model.Day;
import javafx.event.Event;
import javafx.event.EventHandler;

public class SetMaxSubmitButtonHandler implements EventHandler {


  private int maxTasks;
  private int maxEvents;
  private Day day;


  SetMaxSubmitButtonHandler(int maxTasks, int maxEvents, Day day) {
    this.maxTasks = maxTasks;
    this.maxEvents = maxEvents;
    this.day = day;
  }


  @Override
  public void handle(Event event) {
    if (isNullEvent()) {
      //nothing happens
    } else {


    }
  }




  public boolean isNullEvent() {
    return maxTasks < 0 || maxEvents < 0 || day.getGetDayWeek() == null;
  }


}
