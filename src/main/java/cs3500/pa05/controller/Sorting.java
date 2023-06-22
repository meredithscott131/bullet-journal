package cs3500.pa05.controller;

import cs3500.pa05.model.Calendar;
import cs3500.pa05.model.CompareByDuration;
import cs3500.pa05.model.CompareByInputName;
import cs3500.pa05.model.Day;
import cs3500.pa05.model.OrderType;
import cs3500.pa05.model.Task;
import cs3500.pa05.model.UserCalInput;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sorting {

  Calendar calendar;

  public Sorting(Calendar calendar) {
    this.calendar = calendar;
  }

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

  public void updateOrder(OrderType orderType) {
    Comparator<UserCalInput> compareName = new CompareByInputName();
    Comparator<UserCalInput> compareDuration = new CompareByDuration();

    List<Day> days = this.calendar.getDays();
    for (Day d : days) {
      List<UserCalInput> userInputsCopy = d.getListCopy();

      if (orderType.equals(OrderType.NAME)) {

        Collections.sort(userInputsCopy, compareName);
      } else if (orderType.equals(OrderType.DURATION)) {

        Collections.sort(userInputsCopy, compareDuration);
      }
    }
  }
}
