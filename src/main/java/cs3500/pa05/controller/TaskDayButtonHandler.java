package cs3500.pa05.controller;

import cs3500.pa05.model.Calendar;
import cs3500.pa05.model.DayWeek;
import cs3500.pa05.model.EventIn;
import cs3500.pa05.model.Task;
import javafx.event.Event;
import javafx.event.EventHandler;

public class TaskDayButtonHandler implements EventHandler {

  private DayWeek dayWeek;

  private Task task;

  public TaskDayButtonHandler(DayWeek dayWeek, Task task) {
    this.task = task;
    this.dayWeek = dayWeek;
  }

  @Override
  public void handle(Event event) {
    task.setDay(dayWeek);
  }
}
