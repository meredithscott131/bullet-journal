package cs3500.pa05.model;


import java.util.List;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * Day class represents a single day on the calendar
 */
public class Day {

  //Fields:
  DayWeek day;
  List<UserCalInput> dayInputs;

  int maxTask;

  int minTask;

  public List<UserCalInput> getDayInputs() {
    return dayInputs;
  }

  public DayWeek getGetDayWeek() {
    return day;
  }

  public void addContent() {
    if (day.equals(DayWeek.SUNDAY)) {

    }
  }//closes Day class

  public void drawUserCallInput(VBox dayVbox) {

    for(UserCalInput userIn : dayInputs) {
      VBox vbox = new VBox();
      Label titleEvent = new Label(userIn.getName());
      Label contentEvent = new Label(userIn.getDescription());
      vbox.getChildren().add(titleEvent);
      vbox.getChildren().add(contentEvent);

      dayVbox.getChildren().add(vbox);
    }
  }
}
