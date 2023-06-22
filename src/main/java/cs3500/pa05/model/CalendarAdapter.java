package cs3500.pa05.model;

import cs3500.pa05.json.CalendarJson;
import cs3500.pa05.json.DayJson;
import cs3500.pa05.json.EventJson;
import cs3500.pa05.json.TaskJson;
import java.util.ArrayList;
import java.util.List;

/**
 * Responsible for converting between Calendar and CalendarJson objects
 */
public class CalendarAdapter {

  /**
   * Given a Calendar object, convert it to a Json Calendar
   *
   * @param modelCalendar the calendar
   * @return the calendar json
   */
  public CalendarJson convertToJson(Calendar modelCalendar) {
    int maxEvents = modelCalendar.getMaxEvent();
    int maxTasks = modelCalendar.getMaxTask();
    DayWeek startDay = modelCalendar.getStartDay();
    String title = modelCalendar.getName();
    String quotesNotes = modelCalendar.getQuotesNotes();
    DayJson[] days = new DayJson[7];
    ArrayList<String> categories = new ArrayList<>();
    String password = modelCalendar.getPassword();

    for (int i = 0; i < days.length; i++) {
      List<EventJson> events = new ArrayList<>();
      List<TaskJson> tasks = new ArrayList<>();
      for (int j = 0; j < modelCalendar.getDays().get(i).getInputs().size(); j++) {
        UserCalInput input = modelCalendar.getDays().get(i).getInputs().get(j);
        addUserInputJson(input, events, tasks);
        checkCategory(input, modelCalendar, categories);
      }
      DayJson dayJson = new DayJson(modelCalendar.getDays().get(i).getGetDayWeek(),
          events, tasks);
      days[i] = dayJson;
    }

    return new CalendarJson(maxTasks, maxEvents, title, days,
        quotesNotes, startDay.toString(), categories, password);
  }

  /**
   * Adds an input to either the list of tasks or events
   *
   * @param input the user input
   * @param events the list of events
   * @param tasks the list of tasks
   */
  private void addUserInputJson(UserCalInput input, List<EventJson> events, List<TaskJson> tasks) {
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
  }

  /**
   * Adds the given user input's category to the category list
   * if the list doesn't already contain it.
   *
   * @param input the user input
   * @param modelCalendar the calendar
   * @param categories the list of categories belonging to the calendar
   */
  private void checkCategory(UserCalInput input, Calendar modelCalendar,
                            ArrayList<String> categories) {
    if (input.getCategory() != null && !modelCalendar.getCategories()
        .contains(input.getCategory().toUpperCase())) {
      categories.add(input.getCategory().toUpperCase());
    }
  }


  /**
   * Given a Calendar Json, convert it to a Calendar object
   *
   * @param calendarJson the calendar json
   * @param bujo         the bujo path
   * @return             the calendar
   */
  public Calendar convertToCalendar(CalendarJson calendarJson, String bujo) {
    int maxEvents = calendarJson.maxEvents();
    int maxTasks = calendarJson.maxTasks();
    DayWeek startDay = DayWeek.valueOf(calendarJson.startDay());
    String title = calendarJson.title();
    String quotesNotes = calendarJson.quotesNotes();
    List<Day> days = new ArrayList<>();
    ArrayList<String> categories = new ArrayList<>();
    String password = calendarJson.password();

    for (int i = 0; i < calendarJson.days().length; i++) {
      Day day;
      DayWeek dayWeek = calendarJson.days()[i].day();
      ArrayList<UserCalInput> inputs = new ArrayList<>();

      everyEventJson(calendarJson, i, dayWeek, inputs, categories);

      everyTaskJson(calendarJson, i, dayWeek, inputs, categories);

      day = new Day(dayWeek, inputs);
      days.add(day);
    }
    return new Calendar(title, days, maxTasks, maxEvents,
        quotesNotes, startDay, categories, bujo, password);
  }

  /**
   * Checks if the given event category is null and adds it to the
   * category list if the list doesn't already contain it.
   *
   * @param calendarJson  the calendar json
   * @param task          the task
   * @param eventCategory the category of the event
   * @param categories    the list of categories
   */
  private void nullCategoryCalTask(CalendarJson calendarJson, TaskJson task,
                               String eventCategory, ArrayList<String> categories) {
    if (eventCategory != null) {
      if (!calendarJson.categories().contains(task.category().toUpperCase())) {
        categories.add(task.category().toUpperCase());
      }
    }
  }

  /**
   * Checks if the given category is null and adds it to
   * the category list if the list doesn't already contain it.
   *
   * @param calendarJson the calendar json
   * @param event        the event
   * @param category     the category
   * @param categories   the categories
   */
  public void nullCategoryCalEvent(CalendarJson calendarJson, EventJson event,
                                   String category, ArrayList<String> categories) {
    if (category != null) {
      if (!calendarJson.categories().contains(event.category().toUpperCase())) {
        categories.add(event.category().toUpperCase());
      }
    }
  }

  /**
   * Adds every event from the calendar json to the given inputs list.
   *
   * @param calendarJson the calendar json
   * @param day            the day
   * @param dayWeek      the day week
   * @param inputs       the inputs
   * @param categories   the categories
   */
  public void everyEventJson(CalendarJson calendarJson, int day,
                             DayWeek dayWeek, ArrayList<UserCalInput> inputs,
                             ArrayList<String> categories) {
    for (EventJson event : calendarJson.days()[day].events()) {
      EventIn newEvent;
      String eventTitle = event.name();
      String eventDescription = event.description();
      String startTime = event.startTime();
      String category = event.category();

      nullCategoryCalEvent(calendarJson, event, category, categories);

      int duration = event.duration();
      newEvent = new EventIn(eventTitle, eventDescription,
          dayWeek, startTime, category, duration);
      inputs.add(newEvent);
    }
  }

  /**
   * Adds every task from the calendar json to the given inputs list.
   *
   * @param calendarJson the calendar json
   * @param day            the day
   * @param dayWeek      the day week
   * @param inputs       the inputs
   * @param categories   the categories
   */
  public void everyTaskJson(CalendarJson calendarJson, int day,
                             DayWeek dayWeek, ArrayList<UserCalInput> inputs,
                             ArrayList<String> categories) {

    for (TaskJson task : calendarJson.days()[day].tasks()) {
      Task newTask;
      String eventTitle = task.name();
      String eventDescription = task.description();
      String eventCategory = task.category();

      nullCategoryCalTask(calendarJson, task, eventCategory, categories);

      boolean complete = task.complete();
      newTask = new Task(eventTitle, eventDescription, dayWeek, eventCategory, complete);
      inputs.add(newTask);
    }
  }
}