package cs3500.pa05.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import cs3500.pa05.json.CalendarJson;
import cs3500.pa05.json.DayJson;
import cs3500.pa05.json.EventJson;
import cs3500.pa05.json.TaskJson;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * CalendarAdapterTest class is the test class for CalendarAdapter
 */
class CalendarAdapterTest {
  private Calendar calendar;
  private PrintWriter writer;
  private Path path1 = Paths.get("src/test/java/cs3500/pa05/model/boujee.bujo");
  private String expected = """
          {
            "max tasks" : 4,
            "max events" : 4,
            "title" : "Test Week",
            "days" : [ {
              "day" : "SUNDAY",
              "events" : [ {
                "name" : "Dinner",
                "description" : "eating",
                "day" : "SUNDAY",
                "start time" : "6:30",
                "duration" : 60
              } ],
              "tasks" : [ ]
            }, {
              "day" : "MONDAY",
              "events" : [ ],
              "tasks" : [ ]
            }, {
              "day" : "TUESDAY",
              "events" : [ ],
              "tasks" : [ ]
            }, {
              "day" : "WEDNESDAY",
              "events" : [ ],
              "tasks" : [ ]
            }, {
              "day" : "THURSDAY",
              "events" : [ ],
              "tasks" : [ {
                "name" : "Dinner",
                "description" : "eating",
                "day" : "THURSDAY",
                "complete" : false
              } ]
            }, {
              "day" : "FRIDAY",
              "events" : [ ],
              "tasks" : [ ]
            }, {
              "day" : "SATURDAY",
              "events" : [ ],
              "tasks" : [ ]
            } ]
          }""";

  /**
   * innit method is a setup before each file test
   */
  @BeforeEach
  public void innit() {
    // reset bujo file
    try {
      writer = new PrintWriter(path1.toString());
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }
    writer.print("");
    writer.close();

    // creating sample calendar
    ArrayList<UserCalInput>
        inputsSunday = new ArrayList<>(Arrays.asList(new EventIn("Dinner", "eating",
        DayWeek.SUNDAY, "catagory", "6:30", 60)));
    Day sunday = new Day(DayWeek.SUNDAY, inputsSunday);
    Day monday = new Day(DayWeek.MONDAY, new ArrayList<>());
    Day tuesday = new Day(DayWeek.TUESDAY, new ArrayList<>());
    Day wednesday = new Day(DayWeek.WEDNESDAY, new ArrayList<>());
    ArrayList<UserCalInput>
        inputsThursday = new ArrayList<>(Arrays.asList(new Task("Dinner", "eating",
        DayWeek.THURSDAY, "catagory", false)));
    Day thursday = new Day(DayWeek.THURSDAY, inputsThursday);
    Day friday = new Day(DayWeek.FRIDAY, new ArrayList<>());
    Day saturday = new Day(DayWeek.SATURDAY, new ArrayList<>());
    List<Day> days = new ArrayList<>(Arrays.asList(sunday, monday, tuesday, wednesday, thursday,
        friday, saturday));

    calendar = new Calendar("Test Week", days, 4, 4,
        "quotes", DayWeek.MONDAY,
        new ArrayList<>(), "path",
        "password");

  }

  /**
   * testScannerBujo method is the test method for scannerBujo
   */
  @Test
  public void testScannerBujo() {
    ParseToFile parser = new ParseToFile();
    parser.writeToFile(path1, this.calendar);

    ScannerBujo scannerBujo = new ScannerBujo();
    Calendar cal = scannerBujo.readFromFile(path1.toFile());

    assertEquals(4, cal.getMaxEvent());
    assertEquals(4, cal.getMaxEvent());
    assertEquals("Test Week", cal.getName());
    assertEquals(7, cal.getDays().size());
    assertEquals(1, cal.getDays().get(0).getInputs().size());
    assertEquals(1, cal.getDays().get(4).getInputs().size());
  }

  /**
   * testScannerBujoError method is the test method for scannerBujoError
   */
  @Test
  public void testScannerBujoError() {
    File falseFile = new File("wrong.md");

    ScannerBujo scannerBujo = new ScannerBujo();
    assertThrows(IllegalArgumentException.class,
        () -> scannerBujo.readFromFile(falseFile));
  }

  @Test
  public void checkingNull() {

    Day sunday = new Day(DayWeek.SUNDAY, new ArrayList<>());
    Day monday = new Day(DayWeek.MONDAY, new ArrayList<>());
    Day tuesday = new Day(DayWeek.TUESDAY, new ArrayList<>());
    Day wednesday = new Day(DayWeek.WEDNESDAY, new ArrayList<>());
    ArrayList<UserCalInput>
        inputsThursday = new ArrayList<>(Arrays.asList(new Task("Dinner", "eating",
        DayWeek.THURSDAY, "catagory", false)));
    Day thursday = new Day(DayWeek.THURSDAY, inputsThursday);
    Day friday = new Day(DayWeek.FRIDAY, new ArrayList<>());

    UserCalInput input = new Task("name", "b",
        DayWeek.SUNDAY, null, false);
    ArrayList<UserCalInput> inList = new ArrayList<>();
    inList.add(input);
    Day saturday = new Day(DayWeek.SATURDAY, new ArrayList<>());
    List<Day> days = new ArrayList<>(Arrays.asList(sunday, monday, tuesday, wednesday, thursday,
        friday, saturday));

    Calendar cal = new Calendar("b", new ArrayList<>(), 1, 1,
        "hi", DayWeek.SUNDAY, new ArrayList<>(), null, "pass");

    Calendar nullCal = new Calendar("b", days, 1, 1,
        "hi", DayWeek.SUNDAY, new ArrayList<>(), "path", "pas");

    CalendarAdapter adapt = new CalendarAdapter();
    CalendarJson jsonCal = adapt.convertToJson(nullCal);
    assertEquals(1, jsonCal.categories().size());

  }


  @Test
  public void testNullCategoryCalTask() {

    DayJson[] sayArray = new DayJson[1];
    List<EventJson> eventJson = new ArrayList<>();
    List<TaskJson> taskJson = new ArrayList<>();
    sayArray[0] = new DayJson(DayWeek.SUNDAY, eventJson, taskJson);

    CalendarJson calJson = new CalendarJson(2,2,"title",
        sayArray, "quote", DayWeek.MONDAY.toString(), new ArrayList<>(), "pas");

    TaskJson task = new TaskJson("j", "e", DayWeek.SUNDAY, true, "i");
    ArrayList<String> str = new ArrayList<>();
    str.add("u");

    assertEquals(1, str.size());

    CalendarAdapter calAdapt = new CalendarAdapter();
    calAdapt.nullCategoryCalTask(calJson, task, "hi", str);

    assertTrue(str.contains("I"));
    assertEquals(2, str.size());
  }
}