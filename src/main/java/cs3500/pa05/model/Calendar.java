package cs3500.pa05.model;

import cs3500.pa05.view.StyleType;
import java.util.ArrayList;
import java.util.List;
/**
 * Calendar class represents a calendar
 */
public class Calendar {
  private String name;
  private List<Day> days;
  private List<UserCalInput> totalUserInputs;
  private int maxTask;
  private int maxEvent;
  private String quotesNotes;
  private String bujoPath;
  private StyleType styleType = StyleType.NORMAL;

  public Calendar(String name, List<Day> days, int maxTask, int maxEvent,
                  String quotesNotes, String bujoPath) {
    this.name = name;
    this.days = days;
    this.maxTask = maxTask;
    this.maxEvent = maxEvent;
    this.totalUserInputs = new ArrayList<>();
    this.quotesNotes = quotesNotes;
    this.bujoPath = bujoPath;
    //this.styleType = styleType;
    calenderInit();
  }

  public Calendar() {}

  public List<UserCalInput> getTotalUserInputs() {
    return totalUserInputs;
  }

  public void calenderInit() {
    for(Day d: days) {
      List<UserCalInput> inputs = d.getInputs();
      for(UserCalInput in : inputs) {
        totalUserInputs.add(in);
      }
    }
  }

  /**
   * setName method sets the current name
   */
  public void setName(String name) {
    this.name = name;
  }

  public void setMaxEvent(int num) {
    this.maxEvent = num;
  }

  public void setMaxTask(int num) {
    this.maxTask = num;
  }

  public void setTotalUserInputs(List<UserCalInput> users) {
    this.totalUserInputs = users;
  }

  public void setBujoPath(String str) {
    this.bujoPath = str;
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

  public String getQuotesNotes() {
    return quotesNotes;
  }

  public void setQuotesNotes(String notes) {
    this.quotesNotes = notes;
  }

  public String getBujoPath() {
    return this.bujoPath;
  }

  public void setDays(List<Day> daysIn) {
    this.days = daysIn;
  }

  public void setStyleType(StyleType styleType) {
    this.styleType = styleType;
  }

  public StyleType getStyleType() {
    return this.styleType;
  }


  public void initDaysList(List<Day> givenDay) {
    days = givenDay;
    days.add(new Day(DayWeek.SUNDAY, new ArrayList<>()));
    days.add(new Day(DayWeek.MONDAY, new ArrayList<>()));
    days.add(new Day(DayWeek.TUESDAY, new ArrayList<>()));
    days.add(new Day(DayWeek.WEDNESDAY, new ArrayList<>()));
    days.add(new Day(DayWeek.THURSDAY, new ArrayList<>()));
    days.add(new Day(DayWeek.FRIDAY, new ArrayList<>()));
    days.add(new Day(DayWeek.SATURDAY, new ArrayList<>()));
  }
}