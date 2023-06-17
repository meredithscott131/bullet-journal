package cs3500.pa05.model;


import java.time.LocalTime;

/**
 * Event class contains a new creation of an event.
 */
public class Event extends UserCalInput {

  //Fields
  LocalTime startTime;
  int duration;

  public Event(String name, String description, DayWeek day,
               LocalTime startTime, int duration) {
    super(name, description, day);
    this.startTime = startTime;
    this.duration = duration;
  }

  public LocalTime getStartTime() {
    return startTime;
  }

  public int getDuration() {
    return duration;
  }

  public void setName(String str) {
    name = str;
  }

  public void setDay(DayWeek dayWeek) {
    day = dayWeek;
  }

  public void setDescription(String str) {
    description = str;
  }

  public void setDuration(int num) {
    duration = num;
  }

} //closes Event class
