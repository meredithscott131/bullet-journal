package cs3500.pa05.model;
import cs3500.pa05.json.CalendarJson;
import cs3500.pa05.json.DayJson;
import cs3500.pa05.json.EventJson;
import cs3500.pa05.json.TaskJson;
import java.util.ArrayList;
import java.util.List;

public class CalendarAdapter {

  public CalendarJson convertToJson(Calendar modelCalendar) {
    int maxEvents = modelCalendar.getMaxEvent();
    int maxTasks = modelCalendar.getMaxTask();
    DayWeek startDay = modelCalendar.getStartDay();
    String title = modelCalendar.getName();
    String quotesNotes = modelCalendar.getQuotesNotes();
    DayJson[] days = new DayJson[7];
    ArrayList<String> categories = new ArrayList<>();

    for (int i = 0; i < days.length; i++) {
      List<EventJson> events = new ArrayList<>();
      List<TaskJson> tasks = new ArrayList<>();
      for (int j = 0; j < modelCalendar.getDays().get(i).getInputs().size(); j++) {
        UserCalInput input = modelCalendar.getDays().get(i).getInputs().get(j);
        if (input instanceof EventIn) {
          events.add(new EventJson(input.getName(), input.getDescription(), input.getDayWeek(),
              ((EventIn) input).getStartTime(),
              ((EventIn) input).getDuration(),
              input.getCategory()));
        } else {
          tasks.add(new TaskJson(input.getName(),
              input.getDescription(),
              input.getDayWeek(),
              (((Task) input).getComplete()),
              input.getCategory()));
        }

        if (!modelCalendar.getCategories().contains(input.getCategory().toUpperCase())) {
          categories.add(input.getCategory().toUpperCase());
        }
      }
      DayJson dayJson = new DayJson(modelCalendar.getDays().get(i).getGetDayWeek(),
          events, tasks);
      days[i] = dayJson;
    }
    return new CalendarJson(maxTasks, maxEvents, title, days,
        quotesNotes, startDay.toString(), categories);
  }

  //try catch here
  //

  public Calendar convertToCalendar(CalendarJson calendarJson, String bujo) {
    int maxEvents = calendarJson.maxEvents();
    int maxTasks = calendarJson.maxTasks();
    DayWeek startDay = DayWeek.valueOf(calendarJson.startDay());
    String title = calendarJson.title();
    String quotesNotes = calendarJson.quotesNotes();
    List<Day> days = new ArrayList<>();
    ArrayList<String> categories = new ArrayList<>();

    for (int i = 0; i < calendarJson.days().length; i++) {
      Day day;
      DayWeek dayWeek = calendarJson.days()[i].day();
      ArrayList<UserCalInput> inputs = new ArrayList<>();
      for (EventJson event : calendarJson.days()[i].events()) {
        EventIn newEvent;
        String eventTitle = event.name();
        String eventDescription = event.description();
        String startTime = event.startTime();
        String category = event.category();
        if (category != null) {
          if (!calendarJson.categories().contains(event.category().toUpperCase())) {
            categories.add(event.category().toUpperCase());
          }
        }
        int duration = event.duration();
        newEvent = new EventIn(eventTitle, eventDescription,
            dayWeek, startTime, category, duration);
        inputs.add(newEvent);
      }
      for (TaskJson task : calendarJson.days()[i].tasks()) {
        Task newTask;
        String eventTitle = task.name();
        String eventDescription = task.description();
        String eventCategory = task.category();
        if (eventCategory != null) {
          if (!calendarJson.categories().contains(task.category().toUpperCase())) {
            categories.add(task.category().toUpperCase());
          }
        }
        boolean complete = task.complete();
        newTask = new Task(eventTitle, eventDescription, dayWeek, eventCategory, complete);
        inputs.add(newTask);
      }
      day = new Day(dayWeek, inputs);
      days.add(day);
    }
    return new Calendar(title, days, maxTasks, maxEvents, quotesNotes, startDay, categories, bujo);
  }
}