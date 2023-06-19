package cs3500.pa05.controller;

import cs3500.pa05.model.Day;
import cs3500.pa05.model.DayWeek;
import javafx.event.Event;
import javafx.event.EventHandler;

public class SetMaxDayButtonHandler implements EventHandler {

  private Day dayWeek;
  private String maxTask;
  private String maxEvent;

  public SetMaxDayButtonHandler(Day dayWeek, String maxTask, String maxEvent) {
    this.dayWeek = dayWeek;
    this.maxTask = maxTask;
    this.maxEvent = maxEvent;
  }


  @Override
  public void handle(Event event) {
    dayWeek.setTaskMax(Integer.parseInt(maxTask));
    dayWeek.setTaskMax(Integer.parseInt(maxEvent));
  }
}
