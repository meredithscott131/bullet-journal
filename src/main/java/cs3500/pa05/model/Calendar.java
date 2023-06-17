package cs3500.pa05.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Calendar class represents a calendar
 */
public class Calendar {
  //Fields:
  String name;
  List<Day> days;


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
} //closes Calendar class
