package cs3500.pa05.model;

/**
 * Event class contains a new creation of an event.
 */
public class EventIn extends UserCalInput {
  private String startTime;
  private int duration;

  public EventIn(String name, String description, DayWeek day, String category,
                 String startTime, int duration) {
    super(name, description, day, category);
    this.startTime = startTime;
    this.duration = duration;
  }

  public String getStartTime() {
    return startTime;
  }

  public int getDuration() {
    return duration;
  }

  public void setDuration(int num) {
    duration = num;
  }

  public void setStartTime(String str) {
    startTime = str;
  }
}
