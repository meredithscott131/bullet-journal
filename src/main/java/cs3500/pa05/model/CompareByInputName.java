package cs3500.pa05.model;

import java.io.File;
import java.util.Comparator;

public class CompareByInputName implements Comparator<UserCalInput> {

  @Override
  public int compare(UserCalInput use1, UserCalInput use2) {
    String str1 = use1.getName();
    String str2 = use2.getName();

    if(str1.compareTo(str2) < 0) {
      return -1;
    } else if (str1.compareTo(str2) == 0) {
      return 0;
    } else {
      return 1;
    }
  }
}
