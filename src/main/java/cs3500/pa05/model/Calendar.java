package cs3500.pa05.model;

import cs3500.pa05.view.StyleType;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a Calendar in a bullet journal.
 */
public class Calendar {
  private String name;
  private List<Day> days;
  private List<UserCalInput> totalUserInputs;
  private int maxTask;
  private int maxEvent;
  private String quotesNotes;
  private String bujoPath;
  private StyleType styleType = StyleType.NORMAL;
  private OrderType orderType = OrderType.NORMAL;
  private final List<Task> listTasks = new ArrayList<>();
  private DayWeek startDay;
  private ArrayList<String> categories;
  private String password;
  private boolean isTemp;

  /**
   * Instantiates a new Calendar.
   *
   * @param name        the name of the calendar
   * @param days        the days on the calendar
   * @param maxTask     the max amount of tasks
   * @param maxEvent    the max amount of events
   * @param quotesNotes the quotes & notes
   * @param startDay    the calendar start day
   * @param categories  the categories
   * @param bujoPath    the bujo path
   * @param password    the password
   */
  public Calendar(String name, List<Day> days, int maxTask, int maxEvent,
                  String quotesNotes, DayWeek startDay, ArrayList<String> categories,
                  String bujoPath, String password) {

    this.name = name;
    this.days = days;
    this.maxTask = maxTask;
    this.maxEvent = maxEvent;
    this.totalUserInputs = new ArrayList<>();
    this.quotesNotes = quotesNotes;
    this.bujoPath = bujoPath;
    this.startDay = startDay;
    this.categories = categories;
    this.password = password;
    calenderInit();
  }

  /**
   * Instantiates a new Calendar.
   * TODO get rid of this?
   */
  public Calendar() {}

  /**
   * Sets the password of this calendar.
   *
   * @param pass the password
   */
  public void setPassword(String pass) {
    this.password = pass;
  }

  /**
   * Sets the start day of this calendar.
   *
   * @param dayWeek the day of the week
   */
  public void setStartDay(DayWeek dayWeek) {
    this.startDay = dayWeek;
  }

  /**
   * Gets the calendar start day.
   *
   * @return the start day
   */
  public DayWeek getStartDay() {
    return this.startDay;
  }

  /**
   * Gets total user inputs stored in the calendar
   *
   * @return the total user inputs
   */
  public List<UserCalInput> getTotalUserInputs() {
    return this.totalUserInputs;
  }

  /**
   * Gets categories stored in this calendar
   *
   * @return the categories
   */
  public ArrayList<String> getCategories() {
    return this.categories;
  }

  /**
   * Adds a category to this calendar if the categories
   * list doesn't already have it.
   *
   * @param category the category
   */
  public void addCategory(String category) {
    if (!this.categories.contains(category.toUpperCase())) {
      this.categories.add(category.toUpperCase());
    }
  }

  /**
   * Gets list of tasks stored in this calendar.
   *
   * @return the list of tasks
   */
  public List<Task> getListTasks() {
    return listTasks;
  }

  /**
   * Gets the amount of total tasks stored in the calendar.
   *
   * @return the total tasks count
   */
  public int getTotalTasksCount() {
    int counter = 0;
    for (UserCalInput use : totalUserInputs) {
      if (use instanceof Task) {
        if (((Task) use).getComplete()) {
          counter++;
        }
      }
    }
    return counter;
  }

  /**
   * Gets the order type of inputs of this calendar.
   *
   * @return the order type
   */
  public OrderType getOrderType() {
    return this.orderType;
  }

  /**
   * Sets order type of inputs of this calendar.
   *
   * @param order the order
   */
  public void setOrderType(OrderType order) {
    this.orderType = order;
  }

  /**
   * Gets total tasks in this calendar.
   *
   * @return the total tasks
   */
  public List<Task> getTotalTasks() {
    List<Task> tasks = new ArrayList<>();
    for (UserCalInput use : totalUserInputs) {
      if (use instanceof Task) {
        tasks.add((Task) use);
      }
    }
    return tasks;
  }

  /**
   * Initializes the totalUserInputs list.
   */
  public void calenderInit() {
    for (Day d : days) {
      List<UserCalInput> inputs = d.getInputs();
      totalUserInputs.addAll(inputs);
    }
  }

  /**
   * Sets this calendar's name
   *
   * @param name the name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Sets the max events for this calendar.
   *
   * @param num the max
   */
  public void setMaxEvent(int num) {
    this.maxEvent = num;
  }

  /**
   * Sets the max tasks for this calendar.
   *
   * @param num the max
   */
  public void setMaxTask(int num) {
    this.maxTask = num;
  }

  /**
   * Sets the totalUserInputs list for this calendar.
   *
   * @param users the input list
   */
  public void setTotalUserInputs(List<UserCalInput> users) {
    this.totalUserInputs = users;
  }

  /**
   * Sets bujo path for this calendar.
   *
   * @param str the path
   */
  public void setBujoPath(String str) {
    this.bujoPath = str;
  }

  /**
   * Gets the given day given its assigned DayWeek value.
   *
   * @param dayWeek the day week
   * @return the day
   */
  public Day getOneDay(DayWeek dayWeek) {
    Day finalDay = new Day();
    for (Day d : days) {
      if (d.getGetDayWeek().equals(dayWeek)) {
        finalDay = d;
      }
    }
    return finalDay;
  }

  /**
   * Gets the list of days in this calendar.
   *
   * @return the days
   */
  public List<Day> getDays() {
    return this.days;
  }

  /**
   * Gets the max of tasks for this calendar.
   *
   * @return the max of tasks
   */
  public int getMaxTask() {
    return this.maxTask;
  }

  /**
   * Gets the max of events for this calendar.
   *
   * @return the max of events
   */
  public int getMaxEvent() {
    return this.maxEvent;
  }

  /**
   * Gets this calendar's name
   *
   * @return the name
   */
  public String getName() {
    return this.name;
  }

  /**
   * Gets the quotes & notes content of this calendar.
   *
   * @return the quotes & notes
   */
  public String getQuotesNotes() {
    return quotesNotes;
  }

  /**
   * Sets quotes & notes content for this calendar.
   *
   * @param notes the notes
   */
  public void setQuotesNotes(String notes) {
    this.quotesNotes = notes;
  }

  /**
   * Gets bujo path for this calendar.
   *
   * @return the bujo path
   */
  public String getBujoPath() {
    return this.bujoPath;
  }

  /**
   * Sets the list of days for this calendar.
   *
   * @param daysIn the days
   */
  public void setDays(List<Day> daysIn) {
    this.days = daysIn;
  }

  /**
   * Initializes the list of days for this calendar
   *
   * @param givenDay the given list of days
   */
  public void initDaysList(List<Day> givenDay) {
    days = givenDay;
    days.add(new Day(DayWeek.SUNDAY, new ArrayList<>()));
    days.add(new Day(DayWeek.MONDAY, new ArrayList<>()));
    days.add(new Day(DayWeek.TUESDAY, new ArrayList<>()));
    days.add(new Day(DayWeek.WEDNESDAY, new ArrayList<>()));
    days.add(new Day(DayWeek.THURSDAY, new ArrayList<>()));
    days.add(new Day(DayWeek.FRIDAY, new ArrayList<>()));
    days.add(new Day(DayWeek.SATURDAY, new ArrayList<>()));
  }

  /**
   * Gets style type for this calendar.
   *
   * @return the style type
   */
  public StyleType getStyleType() {
    return this.styleType;
  }

  /**
   * Sets style type for this calendar.
   *
   * @param styleType the style type
   */
  public void setStyleType(StyleType styleType) {
    this.styleType = styleType;
  }

  /**
   * Gets password for this calendar.
   *
   * @return the password
   */
  public String getPassword() {
    return password;
  }

  /**
   * Sets the list of tasks.
   */
  public void setListTask() {
    for (UserCalInput use : totalUserInputs) {
      if (use instanceof Task) {
        listTasks.add((Task) use);
      }
    }
  }

  public boolean getIsTemp() {
    return isTemp;
  }

  public void setIsTemp() {
    isTemp = true;
  }

  public void setNormalList() {
    for(Day d: days) {
      List<UserCalInput> listObservable = d.getDayInputsObservable();
      for(UserCalInput use : listObservable) {
        d.getInputs().clear();
        d.getInputs().add(use);
      }
    }
  }
}