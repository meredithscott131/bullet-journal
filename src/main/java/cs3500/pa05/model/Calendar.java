package cs3500.pa05.model;

import cs3500.pa05.view.StyleType;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Calendar class represents a calendar
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

  private List<Task> listTasks = new ArrayList<>();

  private DayWeek startDay;
  private ArrayList<String> categories;
  private String password;

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

  public Calendar() {}

  public void setPassword(String pass) {
    this.password = pass;
  }

  public void setStartDay(DayWeek dayWeek) {
    this.startDay = dayWeek;
  }

  public DayWeek getStartDay() {
    return this.startDay;
  }

  public List<UserCalInput> getTotalUserInputs() {
    return this.totalUserInputs;
  }

  public ArrayList<String> getCategories() {
    return this.categories;
  }

  public void addCategory(String category) {
    if (!this.categories.contains(category.toUpperCase())) {
      this.categories.add(category.toUpperCase());
    }
  }

  public List<Task> getListTasks() {
    return listTasks;
  }

  public void setListTask() {
    for (UserCalInput use : totalUserInputs) {
      if (use instanceof Task) {
        listTasks.add((Task) use);
      }
    }
  }

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

  public OrderType getOrderType() {
    return this.orderType;
  }

  public void setOrderType(OrderType order) {
    this.orderType = order;
  }

  public List<Task> getTotalTasks() {
    List<Task> tasks = new ArrayList<>();
    for (UserCalInput use : totalUserInputs) {
      if (use instanceof Task) {
        tasks.add((Task) use);
      }
    }

    return tasks;
  }

  public void calenderInit() {
    for (Day d : days) {
      List<UserCalInput> inputs = d.getInputs();
      for (UserCalInput in : inputs) {
        totalUserInputs.add(in);
      }
    }
  }

  /**
   * setName method sets the current name
   */
  public void setName(String name) {
    this.name = name;
  }

  public void setMaxEvent(int num) {
    this.maxEvent = num;
  }

  public void setMaxTask(int num) {
    this.maxTask = num;
  }

  public void setTotalUserInputs(List<UserCalInput> users) {
    this.totalUserInputs = users;
  }

  public void setBujoPath(String str) {
    this.bujoPath = str;
  }

  //jderlw
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
   * getDays method gets the current days
   */
  public List<Day> getDays() {
    return this.days;
  }

  public int getMaxTask() {
    return this.maxTask;
  }

  public int getMaxEvent() {
    return this.maxEvent;
  }

  public String getName() {
    return this.name;
  }

  public String getQuotesNotes() {
    return quotesNotes;
  }

  public void setQuotesNotes(String notes) {
    this.quotesNotes = notes;
  }

  public String getBujoPath() {
    return this.bujoPath;
  }

  public void setDays(List<Day> daysIn) {
    this.days = daysIn;
  }

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

  public StyleType getStyleType() {
    return this.styleType;
  }

  public void setStyleType(StyleType styleType) {
    this.styleType = styleType;
  }

  public String getPassword() {
    return password;
  }

}