package cs3500.pa05.controller.bujofile;

import cs3500.pa05.model.DayWeek;
import javafx.event.Event;
import javafx.event.EventHandler;

public class BujoPopupDayHandler implements EventHandler {

  private DayWeek dayWeek;
  private DayWeek startDay;

  public BujoPopupDayHandler(DayWeek dayWeek, DayWeek startDay) {
    this.dayWeek = dayWeek;
    this.startDay = startDay;
  }

  @Override
  public void handle(Event event) {
    startDay = dayWeek;
  }
}