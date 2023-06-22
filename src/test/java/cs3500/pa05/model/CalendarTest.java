package cs3500.pa05.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;


/**
 * CalendarTest class is the test class for Calendar
 */
class CalendarTest {

  /**
   * testSetName method is the test method for setName
   */
  @Test
  void testSetName() {
    String expected = "Name";
    Calendar calendar = new Calendar();
    calendar.setName(expected);
    assertEquals(expected, calendar.getName());
  }

  /**
   * testGetOneDay method is the test method for getOneDay
   */
  @Test
  void testGetOneDay() {
    Day day1 = new Day(DayWeek.MONDAY);
    Day day2 = new Day(DayWeek.THURSDAY);
    List<Day> dayList = new ArrayList<>(Arrays.asList(day1, day2));
    Calendar currCalendar = new Calendar("Title", dayList, 2, 2,
        "quotes", DayWeek.MONDAY, new ArrayList<>(),
        "path", "password");

    DayWeek currDay = DayWeek.MONDAY;
    assertEquals(currCalendar.getOneDay(currDay), day1);
  }

  /**
   * testAddCategory method is the test method for addCategory
   */
  @Test
  void testAddCategory() {
    Day day1 = new Day(DayWeek.MONDAY);
    Day day2 = new Day(DayWeek.THURSDAY);
    List<Day> dayList = new ArrayList<>(Arrays.asList(day1, day2));

    ArrayList cat = new ArrayList<>();

    Calendar currCalendar = new Calendar("Title", dayList, 2, 2,
        "quotes", DayWeek.MONDAY, cat,
        "path", "password");

    currCalendar.addCategory("one");
    currCalendar.getCategories();

    ArrayList expected = new ArrayList<>();
    expected.add("ONE");
    assertEquals(currCalendar.getCategories(), expected);
  }

  /**
   * testSetListTask method is the test method for setListTask
   */
  @Test
  void testSetListTask() {
    Day day1 = new Day(DayWeek.MONDAY);
    Day day2 = new Day(DayWeek.THURSDAY);
    List<Day> dayList = new ArrayList<>(Arrays.asList(day1, day2));

    ArrayList cat = new ArrayList<>();
    Calendar currCalendar = new Calendar("Title", dayList, 2, 2,
        "quotes", DayWeek.MONDAY, cat,
        "path", "password");

    currCalendar.setTotalUserInputs(cat);
    currCalendar.setListTask();

    assertEquals(currCalendar.getListTasks().size(), currCalendar.getTotalUserInputs().size());
  }

  /**
   * testInitCalender method is the test method for initCalender
   */
  @Test
  void testInitCalender() {

    Task task1 = new Task("name", "des", DayWeek.MONDAY, "category", false);
    Task task2 = new Task("name2", "des2", DayWeek.MONDAY, "category2", false);

    ArrayList<UserCalInput> currDayInputsMon = new ArrayList<>();
    currDayInputsMon.add(task1);
    currDayInputsMon.add(task2);

    Task task3 = new Task("name", "des", DayWeek.MONDAY, "category", false);
    Task task4 = new Task("name2", "des2", DayWeek.MONDAY, "category2", false);

    ArrayList<UserCalInput> currDayInputsTues = new ArrayList<>();
    currDayInputsMon.add(task3);
    currDayInputsMon.add(task4);


    Day day1 = new Day(DayWeek.MONDAY, currDayInputsMon);
    Day day2 = new Day(DayWeek.THURSDAY, currDayInputsTues);
    List<Day> dayList = new ArrayList<>(Arrays.asList(day1, day2));

    ArrayList cat = new ArrayList<>();
    Calendar currCalendar = new Calendar("Title", dayList, 2, 2,
        "quotes", DayWeek.MONDAY, cat,
        "path", "password");

    currCalendar.calenderInit();

    assertEquals(currCalendar.getTotalUserInputs().size(), 8);
  }

  /**
   * testInitDaysList method is the test method for initDaysList
   */
  @Test
   void testInitDaysList() {
    Task task1 = new Task("name", "des", DayWeek.MONDAY, "category", false);
    Task task2 = new Task("name2", "des2", DayWeek.MONDAY, "category2", false);

    ArrayList<UserCalInput> currDayInputsMon = new ArrayList<>();
    currDayInputsMon.add(task1);
    currDayInputsMon.add(task2);

    Task task3 = new Task("name", "des", DayWeek.MONDAY, "category", false);
    Task task4 = new Task("name2", "des2", DayWeek.MONDAY, "category2", false);

    ArrayList<UserCalInput> currDayInputsTues = new ArrayList<>();
    currDayInputsMon.add(task3);
    currDayInputsMon.add(task4);

    Day day1 = new Day(DayWeek.MONDAY, currDayInputsMon);
    Day day2 = new Day(DayWeek.THURSDAY, currDayInputsTues);
    List<Day> dayList = new ArrayList<>(Arrays.asList(day1, day2));

    ArrayList cat = new ArrayList<>();
    Calendar currCalendar = new Calendar("Title", dayList, 2, 2,
        "quotes", DayWeek.MONDAY, cat,
        "path", "password");

    List currDayList = new ArrayList<>();

    currCalendar.initDaysList(currDayList);
    assertEquals(currCalendar.getDays().size(), 7);
  }

  /**
   * testGetTotalTasks method is the test method for getTotalTasks
   */
  @Test
  void testGetTotalTasks() {

    Task task1 = new Task("name", "des", DayWeek.MONDAY, "category", false);
    Task task2 = new Task("name2", "des2", DayWeek.MONDAY, "category2", false);

    ArrayList<UserCalInput> currDayInputsMon = new ArrayList<>();
    currDayInputsMon.add(task1);
    currDayInputsMon.add(task2);

    Task task3 = new Task("name", "des", DayWeek.MONDAY, "category", false);
    Task task4 = new Task("name2", "des2", DayWeek.MONDAY, "category2", false);

    ArrayList<UserCalInput> currDayInputsTues = new ArrayList<>();
    currDayInputsMon.add(task3);
    currDayInputsMon.add(task4);

    Day day1 = new Day(DayWeek.MONDAY, currDayInputsMon);
    Day day2 = new Day(DayWeek.THURSDAY, currDayInputsTues);
    List<Day> dayList = new ArrayList<>(Arrays.asList(day1, day2));

    ArrayList cat = new ArrayList<>();

    List expected = new ArrayList<>();
    expected.add(task1);
    expected.add(task2);
    expected.add(task3);
    expected.add(task4);

    Calendar currCalendar = new Calendar("Title", dayList, 2, 2,
        "quotes", DayWeek.MONDAY, cat,
        "path", "password");

    assertEquals(currCalendar.getTotalTasks(), expected);
  }

  /**
   * testGetTotalTasksCount method is the test method for getTotalTasksCount
   */
  @Test
  void testGetTotalTasksCount() {

    Task task1 = new Task("name", "des", DayWeek.MONDAY, "category", true);
    Task task2 = new Task("name2", "des2", DayWeek.MONDAY, "category2", false);

    ArrayList<UserCalInput> currDayInputsMon = new ArrayList<>();
    currDayInputsMon.add(task1);
    currDayInputsMon.add(task2);

    Task task3 = new Task("name", "des", DayWeek.MONDAY, "category", false);
    Task task4 = new Task("name2", "des2", DayWeek.MONDAY, "category2", false);

    ArrayList<UserCalInput> currDayInputsTues = new ArrayList<>();
    currDayInputsMon.add(task3);
    currDayInputsMon.add(task4);

    Day day1 = new Day(DayWeek.MONDAY, currDayInputsMon);
    Day day2 = new Day(DayWeek.THURSDAY, currDayInputsTues);
    List<Day> dayList = new ArrayList<>(Arrays.asList(day1, day2));

    ArrayList cat = new ArrayList<>();
    Calendar currCalendar = new Calendar("Title", dayList, 2, 2,
        "quotes", DayWeek.MONDAY, cat,
        "path", "password");

    assertEquals(currCalendar.getTotalTasksCount(), 1);
  }
}