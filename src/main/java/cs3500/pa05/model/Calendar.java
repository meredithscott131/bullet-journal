package cs3500.pa05.model;

import cs3500.pa05.controller.JournalController;
import java.util.ArrayList;
import java.util.List;

/**
 * Calendar class represents a calendar
 */
public class Calendar {
  //Fields:
  String name;
  List<Day> days;

  private int maxTask;

  private int maxEvent;

  public Calendar(String name, List<Day> days, int maxTask, int maxEvent) {
    this.name = name;
    this.days = days;
    this.maxTask = maxTask;
    this.maxEvent = maxEvent;
  }

  public Calendar() {
  }

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
    List<Day> currList = new ArrayList<>();
    return currList;
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

} //closes Calendar class


