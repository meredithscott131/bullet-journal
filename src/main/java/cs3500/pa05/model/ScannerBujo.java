package cs3500.pa05.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import cs3500.pa05.json.CalendarJson;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * Responsible for reading a bujo file and converting
 * its contents to a calendar object.
 */
public class ScannerBujo {
  private final CalendarAdapter adapter = new CalendarAdapter();

  /**
   * Reads from the given file and parses its content
   * to a new calendar object.
   *
   * @param file the file
   * @return the calendar
   */
  public Calendar readFromFile(File file) {
    Calendar calendar;
    if (!file.toPath().toString().endsWith(".bujo")) {
      throw new IllegalArgumentException("Invalid File. Must be bujo.");
    } else {
      try {
        String bujoString = Files.readString(file.toPath());
        CalendarJson calendarJson = new ObjectMapper().readValue(bujoString, CalendarJson.class);
        calendar = adapter.convertToCalendar(calendarJson, file.getPath());
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }
    return calendar;
  }

}