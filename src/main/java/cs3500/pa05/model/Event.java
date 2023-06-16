package cs3500.pa05.model;


import java.time.LocalTime;

/**
 * Event class contains a new creation of an event.
 */
public class Event extends UserCalInput {

  //Fields
  LocalTime startTime;
  int duration;

  public Event(String name, String description, Day day,
               LocalTime startTime, int duration) {
    super(name, description, day);

  }

} //closes Event class
