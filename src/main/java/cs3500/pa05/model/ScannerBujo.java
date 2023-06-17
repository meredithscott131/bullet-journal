package cs3500.pa05.model;
import cs3500.pa05.json.Calendar;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class ScannerBujo {
  private final ObjectMapper mapper = new ObjectMapper();

  public Calendar readFromFile(File file) {
    Calendar calendar;
    if (!file.toPath().endsWith("bujo")) {
      throw new IllegalArgumentException("Invalid File. Must be bujo.");
    } else {
      try {
        JsonParser parser = this.mapper.getFactory().createParser(file);
        calendar = parser.readValueAs(cs3500.pa05.json.Calendar.class);
      } catch (IOException e) {
        throw new RuntimeException("Cannot parse file");
      }
      return calendar;
    }
  }
}
