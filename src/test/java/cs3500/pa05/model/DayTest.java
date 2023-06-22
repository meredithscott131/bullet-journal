package cs3500.pa05.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.Test;

/**
 * DayTest class is the test class for Day
 */
class DayTest {

  /**
   * testGetDayInputs method is the test method for getDayInputs
   */
  @Test
  public void testGetDayInputs() {
    Day currDay = new Day();

    List input = new ArrayList<>();
    UserCalInput currInput = new Task("Name", "Description", DayWeek.MONDAY, "category", false);
    UserCalInput currInput2 = new Task("Name", "Description", DayWeek.MONDAY, "category", false);

    input.add(currInput);
    input.add(currInput2);
    input = currDay.getDayInputs();

    assertEquals(currDay.getDayInputs(), input);
  }

  /**
   * testGetListCopy method is the test method for getListCopy
   */
  @Test
  public void testGetListCopy() {
    ArrayList input = new ArrayList<>();
    UserCalInput currInput = new Task("Name", "Description", DayWeek.MONDAY, "category", false);
    UserCalInput currInput2 = new Task("Name", "Description", DayWeek.MONDAY, "category", false);

    input.add(currInput);
    input.add(currInput2);

    Day currDay = new Day(DayWeek.MONDAY, input);
    currDay.listCopy();

    assertEquals(currDay.getListCopy(), input);
  }

  /**
   * testGetDayInputsObservable method is the test method for getDayInputsObservable
   */
  @Test
  public void testGetDayInputsObservable() {
    ArrayList input = new ArrayList<>();
    UserCalInput currInput = new Task("Name", "Description", DayWeek.MONDAY, "category", false);
    UserCalInput currInput2 = new Task("Name", "Description", DayWeek.MONDAY, "category", false);

    input.add(currInput);
    input.add(currInput2);
    Day currDay = new Day(DayWeek.MONDAY, input);
    currDay.listCopy();

    assertEquals(currDay.getDayInputsObservable(), input);
  }

  /**
   * testListClear method is the test method for listClear
   */
  @Test
  public void testListClear() {
    ArrayList input = new ArrayList<>();

    Day currDay2 = new Day(DayWeek.MONDAY);
    UserCalInput currInput = new Task("Name", "Description", DayWeek.MONDAY,
        "category", false);
    UserCalInput currInput2 = new Task("Name", "Description", DayWeek.MONDAY,
        "category", false);

    input.add(currInput);
    input.add(currInput2);

    Day currDay = new Day(DayWeek.MONDAY, input);
    ArrayList actual = new ArrayList();
    currDay.listClear();
    currDay.getListCopy();
    ArrayList expected = new ArrayList();

    assertEquals(expected, actual);
  }


  /**
   * testGetNumEventsInDay method is the test method for getNumEventsInDay
   */
  @Test
  public void testGetNumEventsInDay() {
    ArrayList input = new ArrayList<>();
    UserCalInput currInput = new Task("Name", "Description", DayWeek.MONDAY, "category", false);
    UserCalInput currInput2 = new EventIn("Name", "Description", DayWeek.MONDAY, "category", "10:00", 30);
    input.add(currInput);
    input.add(currInput2);

    Day currDay = new Day(DayWeek.MONDAY, input);
    currDay.listCopy();

    assertEquals(currDay.getNumEventsInDay(), 1);
  }

  /**
   * testGetNumTaskInDay method is the test method for getNumTaskInDay
   */
  @Test
  public void testGetNumTaskInDay() {
    ArrayList input = new ArrayList<>();
    UserCalInput currInput = new Task("Name", "Description", DayWeek.MONDAY, "category", false);
    UserCalInput currInput2 = new EventIn("Name", "Description", DayWeek.MONDAY, "category", "10:00", 30);
    input.add(currInput);
    input.add(currInput2);

    Day currDay = new Day(DayWeek.MONDAY, input);
    currDay.listCopy();
    assertEquals(currDay.getNumTaskInDay(), 1);
  }
}