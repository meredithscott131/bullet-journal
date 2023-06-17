package cs3500.pa05.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import cs3500.pa05.json.CalendarJson;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalendarAdapterTest {

  private Calendar calendar;
  private PrintWriter writer;
  private Path p = Paths.get("src/test/java/cs3500/pa05/model/boujee.bujo");
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

  @BeforeEach
  public void innit() {
    // reset bujo file
    try {
      writer = new PrintWriter(p.toString());
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }
    writer.print("");
    writer.close();

    // creating sample calendar
    List<UserCalInput>
        inputsSunday = new ArrayList<>(Arrays.asList(new Event("Dinner", "eating",
        DayWeek.SUNDAY, "6:30", 60)));
    Day sunday = new Day(DayWeek.SUNDAY, inputsSunday);
    Day monday = new Day(DayWeek.MONDAY, new ArrayList<>());
    Day tuesday = new Day(DayWeek.TUESDAY, new ArrayList<>());
    Day wednesday = new Day(DayWeek.WEDNESDAY, new ArrayList<>());
    List<UserCalInput>
        inputsThursday = new ArrayList<>(Arrays.asList(new Task("Dinner", "eating",
        DayWeek.THURSDAY, false)));
    Day thursday = new Day(DayWeek.THURSDAY, inputsThursday);
    Day friday = new Day(DayWeek.FRIDAY, new ArrayList<>());
    Day saturday = new Day(DayWeek.SATURDAY, new ArrayList<>());
    List<Day> days = new ArrayList<>(Arrays.asList(sunday, monday, tuesday, wednesday, thursday,
        friday, saturday));

    calendar = new Calendar("Test Week", days, 4, 4);
  }

  @Test
  public void testConvertToJson() {
    CalendarAdapter adapter = new CalendarAdapter();
    CalendarJson calendarJson = adapter.convertToJson(this.calendar);
    ObjectMapper obj = new ObjectMapper();
    try {
      String jsonStr = obj.writerWithDefaultPrettyPrinter().writeValueAsString(calendarJson);
      assertEquals(this.expected.trim().replaceAll("[\n\r]+", ""),
          jsonStr.trim().replaceAll("[\n\r]+", ""));
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }
  }

  @Test
  public void testParseToFile() {
    ParseToFile parser = new ParseToFile();
    parser.writeToFile(p, this.calendar);

    String bujoString;
    try {
      bujoString = Files.readString(p);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    assertEquals(this.expected.trim().replaceAll("[\n\r]+", ""),
        bujoString.trim().replaceAll("[\n\r]+", ""));
  }

  @Test
  public void testScannerBujo() {
    ParseToFile parser = new ParseToFile();
    parser.writeToFile(p, this.calendar);

    ScannerBujo scannerBujo = new ScannerBujo();
    Calendar cal = scannerBujo.readFromFile(p.toFile());

    assertEquals(4, cal.getMaxEvent());
    assertEquals(4, cal.getMaxEvent());
    assertEquals("Test Week", cal.getName());
    assertEquals(7, cal.getDays().size());
    assertEquals(1, cal.getDays().get(0).getInputs().size());
    assertEquals(1, cal.getDays().get(4).getInputs().size());
  }
}