package cs3500.pa05.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


/**
 * EventTest class is the test class for EventTest
 */
class EventTest {

  /**
   * testGetStartTime method is the test method for getStartTime
   */
  @Test
  void testGetStartTime() {
    String expected = "10:00";
    EventIn event = new EventIn("Event", "Description", DayWeek.MONDAY, "category", expected, 60);
    String actual = event.getStartTime();
    assertEquals(expected, actual);
  }

  /**
   * testGetDuration method is the test method for getDuration
   */
  @Test
  void testGetDuration() {
    int expectedDur = 60;
    EventIn event =
        new EventIn("Event", "Description", DayWeek.MONDAY, "category", "10:00", expectedDur);
    int actualDur = event.getDuration();
    assertEquals(expectedDur, actualDur);
  }

  /**
   * testSetName method is the test method for setName
   */
  @Test
  void testSetName() {
    String expected = "Event1";
    EventIn event = new EventIn("Event1", "Description", DayWeek.MONDAY, "category", "10:00", 60);
    event.setName(expected);
    String actual = event.getName();
    assertEquals(expected, actual);
  }

  /**
   * testSetDay method is the test method for setDay
   */
  @Test
  void testSetDay() {
    DayWeek expectedDay = DayWeek.TUESDAY;
    EventIn event = new EventIn("Event", "Description", DayWeek.TUESDAY, "category", "10:00", 60);
    event.setDay(expectedDay);
    DayWeek actualDay = event.getDayWeek();
    assertEquals(expectedDay, actualDay);
  }

  /**
   * testSetDescription method is the test method for setDescription
   */
  @Test
  void testSetDescription() {
    String expected = "Your mom";
    EventIn event = new EventIn("Event", "Your mom", DayWeek.MONDAY, "category", "10:00", 60);
    event.setDescription(expected);
    String actual = event.getDescription();
    assertEquals(expected, actual);
  }

  /**
   * testSetDuration method is the test method for setDuration
   */
  @Test
  void testSetDuration() {
    int expected = 60;
    EventIn event = new EventIn("Event", "Description", DayWeek.MONDAY, "category", "10:00", 60);
    event.setDuration(expected);
    int actual = event.getDuration();
    assertEquals(expected, actual);
  }

  /**
   * testSetStartTime method is the test method for setStartTime
   */
  @Test
  void testSetStartTime() {
    String expected = "11:00";
    EventIn event = new EventIn("Event", "Description", DayWeek.MONDAY, "category", "10:00", 60);
    event.setStartTime("11:00");
    String actual = event.getStartTime();
    assertEquals(expected, actual);
  }
}