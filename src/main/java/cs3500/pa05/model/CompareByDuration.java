package cs3500.pa05.model;

import java.util.Comparator;

public class CompareByDuration implements Comparator<UserCalInput> {

  @Override
  public int compare(UserCalInput use1, UserCalInput use2) {
    Integer o1 = 0;
    Integer o2 = 0;

    if(use1 instanceof EventIn) {
      o1 = ((EventIn) use1).getDuration();
    } else {
      o1 = 0;
    }

    if(use2 instanceof EventIn) {
      o2 = ((EventIn) use1).getDuration();
    } else {
      o2 = 0;
    }

    if(o1.compareTo(o2) < 0) {
      return -1;
    } else if (o1.compareTo(o2) == 0) {
      return 0;
    } else {
      return 1;
    }
  }
}
