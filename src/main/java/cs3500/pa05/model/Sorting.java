package cs3500.pa05.model;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Represents the sorting of inputs on the calendar
 */
public class Sorting {
  private final Calendar calendar;

  /**
   * Instantiates a new Sorting.
   *
   * @param calendar the calendar
   */
  public Sorting(Calendar calendar) {
    this.calendar = calendar;
  }

  /**
   * Sort just task.
   *
   * @param orderType the order type
   */
  public void sortJustTask(OrderType orderType) {

    this.calendar.getListTasks().clear();
    this.calendar.setListTask();
    List<Task> tasks = this.calendar.getListTasks();
    Comparator<UserCalInput> compareName = new CompareByInputName();
    Comparator<UserCalInput> compareDuration = new CompareByDuration();

    if (orderType.equals(OrderType.NAME)) {

      Collections.sort(tasks, compareName);
    } else if (orderType.equals(OrderType.DURATION)) {

      Collections.sort(tasks, compareDuration);
    }
  }

  /**
   * Update order.
   *
   * @param orderType the order type
   */
  public void updateOrder(OrderType orderType) {
    Comparator<UserCalInput> compareName = new CompareByInputName();
    Comparator<UserCalInput> compareDuration = new CompareByDuration();

    List<Day> days = this.calendar.getDays();
    for (Day d : days) {
      List<UserCalInput> userInputsCopy = d.getListCopy();

      if (orderType.equals(OrderType.NAME)) {
        userInputsCopy.sort(compareName);
      } else if (orderType.equals(OrderType.DURATION)) {
        userInputsCopy.sort(compareDuration);
      }
    }
  }
}