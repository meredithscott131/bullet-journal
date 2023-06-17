package cs3500.pa05.model;

import cs3500.pa05.json.CalendarJson;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

public class ParseToFile {

  public void writeToFile(Path path, Calendar calendar) {
    CalendarAdapter adaptar = new CalendarAdapter(calendar);
    CalendarJson calendarJson = adaptar.convertToJson();

    String str = calendarJson.toString();
    BufferedWriter writer = null;
    try {
      writer = new BufferedWriter(new FileWriter(path.toFile()));
      writer.write(str);
      writer.close();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
