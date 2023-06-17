package cs3500.pa05.model;
import cs3500.pa05.json.CalendarJson;
import cs3500.pa05.json.DayJson;
import cs3500.pa05.json.EventJson;
import cs3500.pa05.json.TaskJson;
import java.util.ArrayList;
import java.util.List;

public class CalendarAdapter {

  Calendar modelCalendar;

  public CalendarAdapter(Calendar modelCalendar) {
    this.modelCalendar = modelCalendar;
  }

  public CalendarJson convertToJson() {
    int maxEvents = this.modelCalendar.getMaxEvent();
    int maxTasks = this.modelCalendar.getMaxTask();
    String title = this.modelCalendar.getName();
    DayJson[] days = new DayJson[7];
    for (int i = 0; i < days.length; i++) {
      List<EventJson> events = new ArrayList<>();
      List<TaskJson> tasks = new ArrayList<>();
      for (int j = 0; j < this.modelCalendar.getDays().get(i).getInputs().size(); j++) {
        UserCalInput input = this.modelCalendar.getDays().get(i).getInputs().get(j);
        if (input instanceof Event) {
          events.add(new EventJson(input.getName(), input.getDescription(), input.getDayWeek(),
              ((Event) input).getStartTime(), ((Event) input).getDuration()));
        } else if (input instanceof Task) {
          tasks.add(new TaskJson(input.getName(), input.getDescription(), input.getDayWeek(),
              (((Task) input).getComplete())));
        }
      }
      DayJson dayJson = new DayJson(this.modelCalendar.getDays().get(i).getGetDayWeek(),
          events, tasks);
      days[i] = dayJson;
    }
    return new CalendarJson(maxTasks, maxEvents, title, days);
  }
}