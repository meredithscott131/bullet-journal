package cs3500.pa05.model;

import java.util.Comparator;

/**
 * Responsible for comparing events by their duration times.
 */
public class CompareByDuration implements Comparator<UserCalInput> {

  /**
   * @param use1 the first object to be compared.
   * @param use2 the second object to be compared.
   * @return their difference
   */
  @Override
  public int compare(UserCalInput use1, UserCalInput use2) {
    Integer o1 = 0;
    int o2 = 0;

    if (use1 instanceof EventIn) {
      o1 = ((EventIn) use1).getDuration();
    } else {
      o1 = 0;
    }

    if (use2 instanceof EventIn) {
      o2 = ((EventIn) use2).getDuration();
    }

    return Integer.compare(o1.compareTo(o2), 0);
  }
}
