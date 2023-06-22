package cs3500.pa05.controller.bujofile;

import cs3500.pa05.model.DayWeek;
import javafx.event.Event;
import javafx.event.EventHandler;

/**
 * Represents the handler for the bujo popup
 */
public class BujoPopupDayHandler implements EventHandler {
  private final DayWeek dayWeek;
  private DayWeek startDay;

  /**
   * Instantiates a new Bujo popup handler for day selection.
   *
   * @param dayWeek  the day week
   * @param startDay the start day
   */
  public BujoPopupDayHandler(DayWeek dayWeek, DayWeek startDay) {
    this.dayWeek = dayWeek;
    this.startDay = startDay;
  }

  /**
   * Handles the user action event.
   *
   * @param event the action event
   */
  @Override
  public void handle(Event event) {
    this.startDay = dayWeek;
  }
}