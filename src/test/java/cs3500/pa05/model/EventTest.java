package cs3500.pa05.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalTime;

class EventTest {

    @Test
    void testGetStartTime() {
      String expected = "10:00";
      EventIn event = new EventIn("Event", "Description", DayWeek.MONDAY, expected, 60);
      String actual = event.getStartTime();
      assertEquals(expected, actual);
    }

    @Test
    void testGetDuration() {
      int expectedDur = 60;
      EventIn event = new EventIn("Event", "Description", DayWeek.MONDAY,"10:00", expectedDur);
      int actualDur = event.getDuration();
      assertEquals(expectedDur, actualDur);
    }

    @Test
    void testSetName() {
      String expected = "Event1";
      EventIn event = new EventIn("Event1", "Description", DayWeek.MONDAY,"10:00:00", 60);
      event.setName(expected);
      String actual = event.name;
      assertEquals(expected, actual);
    }

    @Test
    void testSetDay() {
      DayWeek expectedDay = DayWeek.TUESDAY;
      EventIn event = new EventIn("Event", "Description", DayWeek.TUESDAY, "10:00:00", 60);
      event.setDay(expectedDay);
      DayWeek actualDay = event.day;
      assertEquals(expectedDay, actualDay);
    }

    @Test
    void testSetDescription() {
      String expected = "Your mom";
      EventIn event = new EventIn("Event", "Your mom", DayWeek.MONDAY,"10:00", 60);
      event.setDescription(expected);
      String actual = event.getDescription();
      assertEquals(expected, actual);
    }

    @Test
    void testSetDuration() {
      int expected = 60;
      EventIn event = new EventIn("Event", "Description", DayWeek.MONDAY,"10:00", 60);
      event.setDuration(expected);
      int actual = event.getDuration();
      assertEquals(expected, actual);
    }


  @Test
  void testSetStartTime() {
    String expected = "11:00";
    EventIn event = new EventIn("Event", "Description", DayWeek.MONDAY,"10:00", 60);
    event.setStartTime("11:00");
    String actual = event.getStartTime();
    assertEquals(expected, actual);
  }

}