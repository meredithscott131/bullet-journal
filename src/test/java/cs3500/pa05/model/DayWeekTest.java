package cs3500.pa05.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DayWeekTest {

    @Test
    public void testEnumDayWeek() {
      assertEquals("SUNDAY", DayWeek.SUNDAY.toString());
      assertEquals("MONDAY", DayWeek.MONDAY.toString());
      assertEquals("TUESDAY", DayWeek.TUESDAY.toString());
      assertEquals("WEDNESDAY", DayWeek.WEDNESDAY.toString());
      assertEquals("THURSDAY", DayWeek.THURSDAY.toString());
      assertEquals("FRIDAY", DayWeek.FRIDAY.toString());
      assertEquals("SATURDAY", DayWeek.SATURDAY.toString());
    }



}