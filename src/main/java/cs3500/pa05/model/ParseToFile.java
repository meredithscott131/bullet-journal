package cs3500.pa05.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import cs3500.pa05.json.CalendarJson;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

/**
 * Responsible for parsing a calendar object to a bujo file
 */
public class ParseToFile {
  private final ObjectMapper mapper = new ObjectMapper();

  /**
   * Writes the given calendar to the given bujo path
   *
   * @param path     the path
   * @param calendar the calendar
   */
  public void writeToFile(Path path, Calendar calendar) {
    CalendarAdapter adapter = new CalendarAdapter();

    if (calendar.getIsTemp()) {
      calendar.setNormalList();
    }

    CalendarJson calendarJson = adapter.convertToJson(calendar);
    try {
      String jsonStr = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(calendarJson);
      BufferedWriter writer = new BufferedWriter(new FileWriter(path.toFile()));
      writer.write(jsonStr);
      writer.close();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}