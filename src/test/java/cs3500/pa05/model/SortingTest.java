package cs3500.pa05.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * SortingTest class is the tester for the sorting class
 */
class SortingTest {

  /**
   * testUpdateOrder method is the tester for the updateOrder
   */
  @Test
  void testUpdateOrder() {
    Day currDay1 = new Day();

    List<Day> listD = new ArrayList();
    listD.add(currDay1);

    ArrayList listC = new ArrayList();
    listC.add("family");

    Calendar currCal =
        new Calendar("name", listD,
            1, 1, "quotes",
            DayWeek.MONDAY, listC, "path",
            "password");

    List input = new ArrayList<>();
    UserCalInput currInput =
        new EventIn("BName", "Description", DayWeek.MONDAY, "category", "10:00", 30);
    UserCalInput currInput2 =
        new EventIn("AName", "Description", DayWeek.MONDAY, "category", "10:00", 20);
    input.add(currInput);
    input.add(currInput2);

    currCal.setTotalUserInputs(input);
    Sorting currSort = new Sorting(currCal);

    currSort.updateOrder(OrderType.NAME);
    assertEquals(input.get(1), currInput2);

    currSort.updateOrder(OrderType.DURATION);
    assertEquals(input.get(1), currInput2);

    currSort.updateOrder(OrderType.NORMAL);
    assertEquals(input.get(1), currInput2);
  }


  /**
   * testSortJustTask method is the tester for the sortJustTask
   */
  @Test
  void testSortJustTask() {

    Day currDay1 = new Day();

    List<Day> listD = new ArrayList();
    listD.add(currDay1);

    ArrayList listC = new ArrayList();
    listC.add("family");

    Calendar currCal =
        new Calendar("name", listD,
            1, 1, "quotes",
            DayWeek.MONDAY, listC, "path",
            "password");

    List input = new ArrayList<>();
    UserCalInput currInput =
        new EventIn("BName", "Description", DayWeek.MONDAY, "category", "10:00", 30);
    UserCalInput currInput2 =
        new EventIn("AName", "Description", DayWeek.MONDAY, "category", "10:00", 20);
    input.add(currInput);
    input.add(currInput2);

    currCal.setTotalUserInputs(input);
    Sorting currSort = new Sorting(currCal);

    currSort.sortJustTask(OrderType.NAME);
    assertEquals(input.get(1), currInput2);

    currSort.sortJustTask(OrderType.DURATION);
    assertEquals(input.get(1), currInput2);

    currSort.sortJustTask(OrderType.NORMAL);
    assertEquals(input.get(1), currInput2);

  }

}