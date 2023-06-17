package cs3500.pa05.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import cs3500.pa05.json.CalendarJson;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalendarAdaptarTest {

  Calendar calendar;

  @BeforeEach
  public void innit() {
    List<UserCalInput>
        inputsSunday = new ArrayList<>(Arrays.asList(new Event("Dinner", "eating",
        DayWeek.SUNDAY, "6:30", 60)));
    Day sunday = new Day(DayWeek.SUNDAY, inputsSunday);
    Day monday = new Day(DayWeek.SUNDAY, new ArrayList<>());
    Day tuesday = new Day(DayWeek.SUNDAY, new ArrayList<>());
    Day wednesday = new Day(DayWeek.SUNDAY, new ArrayList<>());
    List<UserCalInput>
        inputsThursday = new ArrayList<>(Arrays.asList(new Task("Dinner", "eating",
        DayWeek.SUNDAY, false)));
    Day thursday = new Day(DayWeek.SUNDAY, inputsThursday);
    Day friday = new Day(DayWeek.SUNDAY, new ArrayList<>());
    Day saturday = new Day(DayWeek.SUNDAY, new ArrayList<>());
    List<Day> days = new ArrayList<>(Arrays.asList(sunday, monday, tuesday, wednesday, thursday,
        friday, saturday));

    calendar = new Calendar("Test Week", days, 4, 4);
  }

  @Test
  public void testConvertToJson() {
    String expected = """
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
              "day" : "SUNDAY",
              "events" : [ ],
              "tasks" : [ ]
            }, {
              "day" : "SUNDAY",
              "events" : [ ],
              "tasks" : [ ]
            }, {
              "day" : "SUNDAY",
              "events" : [ ],
              "tasks" : [ ]
            }, {
              "day" : "SUNDAY",
              "events" : [ ],
              "tasks" : [ {
                "name" : "Dinner",
                "description" : "eating",
                "day" : "SUNDAY",
                "complete" : false
              } ]
            }, {
              "day" : "SUNDAY",
              "events" : [ ],
              "tasks" : [ ]
            }, {
              "day" : "SUNDAY",
              "events" : [ ],
              "tasks" : [ ]
            } ]
          }""";

    CalendarAdapter adapter = new CalendarAdapter(this.calendar);
    CalendarJson calendarJson = adapter.convertToJson();
    ObjectMapper obj = new ObjectMapper();
    try {
      String jsonStr = obj.writerWithDefaultPrettyPrinter().writeValueAsString(calendarJson);
      assertEquals(expected.trim().replaceAll("[\n\r]+", ""),
          jsonStr.trim().replaceAll("[\n\r]+", ""));
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }
  }
}