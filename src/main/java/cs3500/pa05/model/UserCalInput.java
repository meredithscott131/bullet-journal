package cs3500.pa05.model;

/**
 * UserCalInput class information for an event or task
 */
public abstract class UserCalInput {
  private String name;
  private String description;
  private DayWeek day;

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

  public DayWeek getDayWeek() {
    return day;
  }

  public void setName(String str) {
    this.name = str;
  }

  public void setDay(DayWeek dayWeek) {
    day = dayWeek;
  }

  public void setDescription(String str) {
    description = str;
  }

}
