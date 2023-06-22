package cs3500.pa05.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    EventIn task4 = new EventIn("Bname2", "des2", DayWeek.MONDAY, "category2", "11:00", 20);

    CompareByDuration comarator1 = new CompareByDuration();

    assertEquals(comarator1.compare(task1, task2), 1);
    assertEquals(comarator1.compare(task2, task1), -1);
    assertEquals(comarator1.compare(task2, task3), 0);


    Task task5 = new Task("Aname", "des", DayWeek.MONDAY, "category", false);
    Task task6 = new Task("Bname2", "des2", DayWeek.MONDAY, "category2", false);
    Task task7 = new Task("Bname2", "des2", DayWeek.MONDAY, "category2", false);
    Task task8 = new Task("Bname2", "des2", DayWeek.MONDAY, "category2", false);

    assertEquals(comarator1.compare(task5, task6), 0);
    assertEquals(comarator1.compare(task6, task5), 0);
    assertEquals(comarator1.compare(task6, task7), 0);

  }
}