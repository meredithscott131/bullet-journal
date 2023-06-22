package cs3500.pa05.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * CompareByDurationTest class is the test class for CompareByDuration
 */
class CompareByDurationTest {

  /**
   * testCompare class is the test class for compare
   */
  @Test
  void testCompare() {

    EventIn task1 = new EventIn("Aname", "des", DayWeek.MONDAY, "category", "10:00", 30);
    EventIn task2 = new EventIn("Bname2", "des2", DayWeek.MONDAY, "category2", "10:00", 20);
    EventIn task3 = new EventIn("Bname2", "des2", DayWeek.MONDAY, "category2", "10:00", 20);

    CompareByDuration comarator1 = new CompareByDuration();

    assertEquals(comarator1.compare(task1, task2), 1);
    assertEquals(comarator1.compare(task2, task1), -1);
    assertEquals(comarator1.compare(task2, task3), 0);
  }
}