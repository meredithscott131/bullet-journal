package cs3500.pa05.model;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Day class represents a single day on the calendar
 */
public class Day {
  private DayWeek day;
  private List<UserCalInput> dayInputs = new ArrayList<>();

  private ObservableList<UserCalInput> dayInputsObservable;

  private List<UserCalInput> dayInputsObservableCopy = new ArrayList<>();

  public Day() {}

  public Day(DayWeek day, ArrayList<UserCalInput> dayInputs) {
    this.day = day;
    this.dayInputs = dayInputs;
    this.dayInputsObservable = FXCollections.observableList(this.dayInputs);

  }

  public void listClear() {
    dayInputsObservableCopy = new ArrayList<>();
  }

  public void listCopy() {
    for (UserCalInput use : dayInputsObservable) {
      dayInputsObservableCopy.add(use);
    }
  }

  public List<UserCalInput> getListCopy() {
    return dayInputsObservableCopy;
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

  public List<String> getObservableInNames() {
    List<String> list = new ArrayList<>();
    for (UserCalInput use : dayInputsObservable) {
      list.add(use.getName());
    }
    return list;
  }

  public List<Integer> getObservableInDuration() {
    List<Integer> list = new ArrayList<>();
    for (UserCalInput use : dayInputsObservable) {
      if (use instanceof EventIn) {
        list.add(((EventIn) use).getDuration());
      } else if (use instanceof Task) {
        list.add(0);
      }
    }
    return list;
  }

  public int getNumEventsInDay() {
    int counter = 0;
    for (UserCalInput use : dayInputsObservable) {
      if (use instanceof EventIn) {
        counter++;
      }
    }
    return counter;
  }

  public int getNumTaskInDay() {
    int counter = 0;
    for (UserCalInput use : dayInputsObservable) {
      if (use instanceof Task) {
        counter++;
      }
    }
    return counter;
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
