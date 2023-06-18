package cs3500.pa05.model;

import java.util.ArrayList;
import java.util.List;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Day class represents a single day on the calendar
 */
public class Day {
  private DayWeek day;
  private List<UserCalInput> dayInputs;

  private ObservableList<UserCalInput> dayInputsObservable;

  public Day() {}

  public Day(DayWeek day, ArrayList<UserCalInput> dayInputs) {
    this.day = day;
    this.dayInputs = dayInputs;
    //FXCollections.observableList(this.dayInputs) = dayInputsObservable;
    //FXCollections.observableList(this.dayInputs)
    this.dayInputsObservable = FXCollections.observableList(this.dayInputs);

  }

  public Day(DayWeek day) {
    this.day = day;
  }

  public List<UserCalInput> getDayInputs() {
    return dayInputs;
  }

  public ObservableList<UserCalInput> getDayInputsObservable() {
    return dayInputsObservable;
  }

  public DayWeek getGetDayWeek() {
    return day;
  }

  public List<UserCalInput> getInputs() {
    return this.dayInputs;
  }

  public ObservableList getAsObservableList() {
    return FXCollections.observableList(this.dayInputs);
  }
}
