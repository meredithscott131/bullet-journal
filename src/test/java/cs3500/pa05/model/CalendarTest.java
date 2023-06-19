package cs3500.pa05.model;

import java.util.Arrays;
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
    assertEquals(expected, calendar.getName());
  }

  @Test
  void testGetOneDay() {
    Day day1 = new Day(DayWeek.MONDAY);
    Day day2 = new Day(DayWeek.THURSDAY);
    List<Day> dayList = new ArrayList<>(Arrays.asList(day1, day2));
    Calendar currCalendar = new Calendar("Title", dayList, 2, 2);

    DayWeek currDay = DayWeek.MONDAY;

    assertEquals(currCalendar.getOneDay(currDay), day1);
  }


    //@Test
    void testGetDays() {

    }


}