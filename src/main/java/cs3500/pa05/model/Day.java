package cs3500.pa05.model;

import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Day class represents a single day on the calendar
 */
public class Day {
  private DayWeek day;
  private ObservableList<UserCalInput> dayInputsObservable;
  private List<UserCalInput> dayInputs = new ArrayList<>();
  private List<UserCalInput> dayInputsObservableCopy = new ArrayList<>();

  /**
   * Empty Constructor for days:
   */
  public Day() {}

  /**
   * Constructor for days that takes in only day:
   *
   * @param day the day
   */
  public Day(DayWeek day) {
    this.day = day;
  }

  /**
   * Constructor for days that takes in day and dayInputs:
   *
   * @param day       the day
   * @param dayInputs the day inputs
   */
  public Day(DayWeek day, ArrayList<UserCalInput> dayInputs) {
    this.day = day;
    this.dayInputs = dayInputs;
    this.dayInputsObservable = FXCollections.observableList(this.dayInputs);

  }

  /**
   * Constructs the observable input list copy
   */
  public void listCopy() {
    dayInputsObservableCopy.addAll(dayInputsObservable);
  }

  /**
   * Gets number of events and tasks in day.
   *
   * @return the number of events and tasks in day
   */
  public int getNumEventsAndTasksInDay() {
    int counter = 0;
    for (UserCalInput use : dayInputsObservable) {
      if (use instanceof EventIn) {
        counter++;
      }
    }
    return counter;
  }

  /**
   * Clears the dayInputsObservableCopy list
   */
  public void listClear() {
    dayInputsObservableCopy = new ArrayList<>();
  }

  /**
   * Gets day inputs observable list.
   *
   * @return the day inputs observable list
   */
  public ObservableList<UserCalInput> getDayInputsObservable() {
    return dayInputsObservable;
  }

  /**
   * Gets the dayInputsObservableCopy list.
   *
   * @return the list copy
   */
  public List<UserCalInput> getListCopy() {
    return dayInputsObservableCopy;
  }

  /**
   * Gets day inputs.
   *
   * @return the day inputs
   */
  public List<UserCalInput> getDayInputs() {
    return dayInputs;
  }

  /**
   * Gets get day week.
   *
   * @return the get day week
   */
  public DayWeek getGetDayWeek() {
    return day;
  }

  /**
   * Gets inputs.
   *
   * @return the inputs
   */
  public List<UserCalInput> getInputs() {
    return this.dayInputs;
  }
}