package cs3500.pa05.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * UserCalInputTest class is the test class for UserCalInput
 */
class UserCalInputTest {

  /**
   * testGetName method is the test method for getName
   */
  @Test
  public void testGetName() {
    UserCalInput currInput = new Task("Task", "Description", DayWeek.MONDAY, "category", false);
    String expected = "Task";
    assertEquals(currInput.getName(), expected);
  }

  /**
   * testGetDayWeek method is the test method for getDayWeek
   */
  @Test
  public void testGetDayWeek() {
    UserCalInput currInput = new Task("Task", "Description", DayWeek.MONDAY, "category", false);
    DayWeek expected = DayWeek.MONDAY;
    assertEquals(currInput.getDayWeek(), expected);
  }
}