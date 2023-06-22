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
    CalendarAdapter adapter = new CalendarAdapter();

    if(calendar.getIsTemp()) {
      calendar.setNormalList();
    } else {
    }

    CalendarJson calendarJson = adapter.convertToJson(calendar);

    try {
      //System.out.println(calendar.getTotalUserInputs().get(0).getName());

      String jsonStr = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(calendarJson);

      System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(calendarJson));

      System.out.println(calendarJson.days()[0].tasks().size());
      System.out.println(calendarJson.days()[1].tasks().size());
      System.out.println(calendarJson.days()[2].tasks().size());
      System.out.println(calendarJson.days()[3].tasks().size());
      System.out.println(calendarJson.days()[4].tasks().size());
      System.out.println(calendarJson.days()[5].tasks().size());
      System.out.println(calendarJson.days()[6].tasks().size());


      System.out.println("calender" + calendar.getDays().get(0).getDayInputs().size());
      System.out.println("calender" + calendar.getDays().get(1).getDayInputs().size());
      System.out.println("calender" + calendar.getDays().get(2).getDayInputs().size());
      System.out.println("calender" + calendar.getDays().get(3).getDayInputs().size());
      System.out.println("calender" + calendar.getDays().get(4).getDayInputs().size());
      System.out.println("calender" + calendar.getDays().get(5).getDayInputs().size());

      BufferedWriter writer = new BufferedWriter(new FileWriter(path.toFile()));
      System.out.println(calendarJson.days());
      writer.write(jsonStr);
      writer.close();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}