package cs3500.pa05.model;

import java.util.Comparator;

/**
 * Responsible for comparing inputs by their name
 */
public class CompareByInputName implements Comparator<UserCalInput> {

  /**
   * @param use1 the first object to be compared.
   * @param use2 the second object to be compared.
   * @return their difference
   */
  @Override
  public int compare(UserCalInput use1, UserCalInput use2) {
    String str1 = use1.getName().toLowerCase();
    String str2 = use2.getName().toLowerCase();

    if  (str1.compareTo(str2) < 0) {
      return -1;
    } else if (str1.compareTo(str2) == 0) {
      return 0;
    } else {
      return 1;
    }
  }
}
