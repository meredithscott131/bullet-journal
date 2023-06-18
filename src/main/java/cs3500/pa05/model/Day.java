package cs3500.pa05.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Day class represents a single day on the calendar
 */
public class Day {
  private DayWeek day;
  private List<UserCalInput> dayInputs;

  public Day() {}

  public Day(DayWeek day, ArrayList<UserCalInput> dayInputs) {
    this.day = day;
    this.dayInputs = dayInputs;
  }

  public Day(DayWeek day) {
    this.day = day;
  }

  public List<UserCalInput> getDayInputs() {
    return dayInputs;
  }

  public DayWeek getGetDayWeek() {
    return day;
  }

  public List<UserCalInput> getInputs() {
    return this.dayInputs;
  }
}
