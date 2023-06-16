package cs3500.pa05.model;


import cs3500.pa05.model.DayWeek;

/**
 * UserCalInput class information for an event or task
 */
public abstract class UserCalInput {

  //Fields:
  private String name;
  private String description;
  private DayWeek day;

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

} //closes UserCalInput class
