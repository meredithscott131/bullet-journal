package cs3500.pa05.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * CompareByInputNameTest class is the test class for CompareByInputName
 */
class CompareByInputNameTest {

  /**
   * testCompare method is the test method for compare
   */
  @Test
  void testCompare() {
    Task task1 = new Task("Aname", "des", DayWeek.MONDAY, "category", true);
    Task task2 = new Task("Bname2", "des2", DayWeek.MONDAY, "category2", false);

    Task task3 = new Task("Bname", "des", DayWeek.MONDAY, "category", true);
    Task task4 = new Task("Aname2", "des2", DayWeek.MONDAY, "category2", false);

    Task task5 = new Task("name", "des", DayWeek.MONDAY, "category", true);
    Task task6 = new Task("name", "des2", DayWeek.MONDAY, "category2", false);

    CompareByInputName comarator1 = new CompareByInputName();

    assertEquals(comarator1.compare(task1, task2), -1);
    assertEquals(comarator1.compare(task3, task4), 1);
    assertEquals(comarator1.compare(task5, task6), 0);
  }
}