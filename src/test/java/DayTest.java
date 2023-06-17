package cs3500.pa05.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class DayTest {

  @Test
  public void testGetDayInputs() {
    Day currDay = new Day();

    List input = new ArrayList<>();
    UserCalInput currInput = new Task("Name", "Description", DayWeek.MONDAY, false);
    UserCalInput currInput2 = new Task("Name", "Description", DayWeek.MONDAY, false);

    input.add(currInput);
    input.add(currInput2);

    input = currDay.getDayInputs();

    assertEquals(currDay.getDayInputs(), input);
  }

}