package cs3500.pa05.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.ArrayList;


class CalendarTest {


  @Test
  void testSetName() {
    String expected = "Name";
    Calendar calendar = new Calendar();
    calendar.setName(expected);
    String actual = calendar.name;
    assertEquals(expected, actual);
  }

  @Test
  void testGetOneDay() {
    Calendar currCalendar = new Calendar();

    Day day1 = new Day(DayWeek.MONDAY);
    Day day2 = new Day(DayWeek.THURSDAY);

    currCalendar.days = new ArrayList<>();

    currCalendar.days.add(day1);
    currCalendar.days.add(day2);

    DayWeek currDay = DayWeek.MONDAY;

    assertEquals(currCalendar.getOneDay(currDay), day1);
  }


    //@Test
    void testGetDays() {

    }


}