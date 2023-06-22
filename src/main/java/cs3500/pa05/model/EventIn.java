package cs3500.pa05.model;

/**
 * Representation of an Event on a calendar
 */
public class EventIn extends UserCalInput {
  private String startTime;
  private int duration;

  /**
   * Instantiates a new EventIn.
   *
   * @param name        the name
   * @param description the description
   * @param day         the day
   * @param category    the category
   * @param startTime   the start time
   * @param duration    the duration
   */
  public EventIn(String name, String description, DayWeek day, String category,
                 String startTime, int duration) {
    super(name, description, day, category);
    this.startTime = startTime;
    this.duration = duration;
  }

  /**
   * Gets start time.
   *
   * @return the start time
   */
  public String getStartTime() {
    return startTime;
  }

  /**
   * Gets duration.
   *
   * @return the duration
   */
  public int getDuration() {
    return duration;
  }

  /**
   * Sets duration.
   *
   * @param num the num
   */
  public void setDuration(int num) {
    duration = num;
  }

  /**
   * Sets start time.
   *
   * @param str the str
   */
  public void setStartTime(String str) {
    startTime = str;
  }
}