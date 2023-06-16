package cs3500.pa05.model;


import cs3500.pa05.model.DayWeek;

/**
 * UserCalInput class information for an event or task
 */
public abstract class UserCalInput {

  //Fields:
  String name;
  String description;
  DayWeek day;

  public UserCalInput(String name, String description, DayWeek day) {
    this.name = name;
    this.description = description;
    this.day = day;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

} //closes UserCalInput class
