package cs3500.pa05.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import cs3500.pa05.json.CalendarJson;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

public class ParseToFile {
  private ObjectMapper mapper = new ObjectMapper();

  public void writeToFile(Path path, Calendar calendar) {
    System.out.println("Note being passed into writer: " + calendar.getQuotesNotes());
    CalendarAdapter adapter = new CalendarAdapter();
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