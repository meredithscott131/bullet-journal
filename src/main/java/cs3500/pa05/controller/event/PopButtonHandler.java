package cs3500.pa05.controller.event;

import cs3500.pa05.model.DayWeek;
import cs3500.pa05.model.EventIn;
import javafx.event.Event;
import javafx.event.EventHandler;

/**
 * Represents the handler for the day selection buttons in the event popup
 */
public class PopButtonHandler implements EventHandler {
  private final DayWeek dayWeek;
  private final EventIn eventIn;

  /**
   * Instantiates a new pop button handler.
   *
   * @param dayWeek the day week
   * @param eventIn the event in
   */
  public PopButtonHandler(DayWeek dayWeek, EventIn eventIn) {
    this.eventIn = eventIn;
    this.dayWeek = dayWeek;
  }

  /**
   * Handles a button press event.
   */
  @Override
  public void handle(Event event) {
    eventIn.setDay(dayWeek);
  }
}
