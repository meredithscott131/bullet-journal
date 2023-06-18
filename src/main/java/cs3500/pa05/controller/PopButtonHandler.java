package cs3500.pa05.controller;

import cs3500.pa05.model.Calendar;
import cs3500.pa05.model.DayWeek;
import cs3500.pa05.model.EventIn;
import cs3500.pa05.view.gui.PopupView;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class PopButtonHandler implements EventHandler {

  private Calendar calendar;

  private DayWeek dayWeek;

  private EventIn eventIn;

  public PopButtonHandler(DayWeek dayWeek, EventIn eventIn) {
    this.eventIn = eventIn;
    this.dayWeek = dayWeek;
  }

  @Override
  public void handle(Event event) {
    eventIn.setDay(dayWeek);
    System.out.println(dayWeek);
  }
}
