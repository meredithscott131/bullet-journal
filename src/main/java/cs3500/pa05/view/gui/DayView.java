package cs3500.pa05.view.gui;

import cs3500.pa05.model.Day;
import cs3500.pa05.model.DayWeek;
import cs3500.pa05.model.UserCalInput;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class DayView extends VBox {
  private Day day;

  @FXML
  private VBox mondayBox;

  @FXML
  private VBox tuesdayBox;

  @FXML
  private VBox wednesdayBox;

  @FXML
  private VBox thursdayBox;

  @FXML
  private VBox fridayBox;

  @FXML
  private VBox sundayBox;
  //null if this is not shown yet
  //when making a scene it has to first be shown first

  //for popups
  //make a new scene
  //dialogs
  //completely new popup scene
  //main controller has sub controller
  //the sub contorller has its own model
  //another controller for just the popup
  //one controller does main stuff and the other does just popups
  //new view for pop up

  //submit button to close popup
  //stage.close()

  public VBox getDayBox() {
    if (day.getGetDayWeek() == DayWeek.MONDAY) {
      return mondayBox;
    } else if(day.getGetDayWeek() == DayWeek.TUESDAY) {
      return tuesdayBox;
    } else if(day.getGetDayWeek() == DayWeek.WEDNESDAY) {
      return wednesdayBox;
    } else if(day.getGetDayWeek() == DayWeek.THURSDAY) {
      return thursdayBox;
    } else if(day.getGetDayWeek() == DayWeek.FRIDAY) {
      return fridayBox;
    } else if(day.getGetDayWeek() == DayWeek.SATURDAY) {
      return tuesdayBox;
    } else {
      return sundayBox;
    }
  }

  public void drawUserCallInput() {

    for (UserCalInput userIn : day.getDayInputs()) {
      VBox vbox = new VBox();
      Label titleEvent = new Label(userIn.getName());
      Label contentEvent = new Label(userIn.getDescription());
      vbox.getChildren().add(titleEvent);
      vbox.getChildren().add(contentEvent);

      getDayBox().getChildren().add(vbox);
    }
  }
}
