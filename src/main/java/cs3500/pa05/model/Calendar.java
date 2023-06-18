package cs3500.pa05.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Calendar class represents a calendar
 */
public class Calendar {
  private String name;
  private List<Day> days;
  private int maxTask;
  private int maxEvent;

  public Calendar(String name, List<Day> days, int maxTask, int maxEvent) {
    this.name = name;
    this.days = days;
    this.maxTask = maxTask;
    this.maxEvent = maxEvent;
  }

  public Calendar() {}

  /**
   * setName method sets the current name
   */
  public void setName(String name) {
    this.name = name;
  }

  public Day getOneDay(DayWeek dayWeek) {
    Day finalDay = new Day();
    for(Day d : days) {
      if(d.getGetDayWeek().equals(dayWeek)) {
        finalDay = d;
      }
    }
    return finalDay;
  }

  /**
   * getDays method gets the current days
   */
  public List<Day> getDays() {
    return this.days;
  }

  public int getMaxTask() {
    return this.maxTask;
  }

  public int getMaxEvent() {
    return this.maxEvent;
  }

  public String getName() {
    return this.name;
  }

  public List<EventIn> eventsInCal() {
    List<EventIn> eventIns = new ArrayList<>();
    for(Day d: days) {
      List<UserCalInput> inputs = d.getDayInputs();
      for(UserCalInput in : inputs) {
        if(in instanceof EventIn) {
          eventIns.add((EventIn) in);
        }
      }
    }
    return eventIns;
  }

  public List<Task> tasksInCal() {
    List<Task> tasks = new ArrayList<>();
    for(Day d: days) {
      List<UserCalInput> inputs = d.getDayInputs();
      for(UserCalInput in : inputs) {
        if(in instanceof Task) {
          tasks.add((Task) in);
        }
      }
    }
    return tasks;
  }
}


