package cs3500.pa05.model;
import cs3500.pa05.json.CalendarJson;
import cs3500.pa05.json.DayJson;

public class CalendarAdaptar {

  cs3500.pa05.model.Calendar modelCalendar;

  public CalendarAdaptar(Calendar modelCalendar) {
    this.modelCalendar = modelCalendar;
  }

  public CalendarJson convertToJson() {
    int maxEvents = this.modelCalendar.getMaxEvent();
    int maxTasks = this.modelCalendar.getMaxTask();
    String title = this.modelCalendar.getName();
    DayJson[] days = new DayJson[7];
    for (int i = 0; i < days.length; i++) {
      DayJson dayJson = new DayJson(this.modelCalendar.getDays().get(i).getGetDayWeek(),
          this.modelCalendar.getDays().get(i).getInputs());
      days[i] = dayJson;
    }
    return new CalendarJson(maxTasks, maxEvents, title, days);
  }
}