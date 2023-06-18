package cs3500.pa05.controller;

import cs3500.pa05.model.Calendar;
import cs3500.pa05.model.DayWeek;
import cs3500.pa05.model.EventIn;
import cs3500.pa05.view.JournalView;
import cs3500.pa05.view.gui.PopupView;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Represents the cs3500.pa05.controller for the journal
 */
public class JournalController implements Controller {

  //Fields:

  //CalendarHandler handler;??????
  private Calendar calendar;

  PopupController popupController;

  @FXML
  private Button taskButton;

  @FXML
  private VBox sundayBox;
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
  private VBox saturdayBox;
  public JournalController(Calendar calendar) {
    this.calendar = calendar;
  }

  /**
   * Initializes the journal
   */
  @Override
  public void run() {
    ButtonsEventHandler butt = new ButtonsEventHandler(this.calendar);
    taskButton.setOnAction(butt);
  }

  public void addEvent(EventIn event, VBox eventBox) {
    if (event.getDayWeek().equals(DayWeek.SUNDAY)) {
      sundayBox.getChildren().add(eventBox);
    } else if (event.getDayWeek().equals(DayWeek.MONDAY)) {
      mondayBox.getChildren().add(eventBox);
    } else if (event.getDayWeek().equals(DayWeek.TUESDAY)) {
      mondayBox.getChildren().add(eventBox);
    } else if (event.getDayWeek().equals(DayWeek.WEDNESDAY)) {
      mondayBox.getChildren().add(eventBox);
    } else if (event.getDayWeek().equals(DayWeek.THURSDAY)) {
      mondayBox.getChildren().add(eventBox);
    } else if (event.getDayWeek().equals(DayWeek.FRIDAY)) {
      mondayBox.getChildren().add(eventBox);
    } else if (event.getDayWeek().equals(DayWeek.SATURDAY)) {
      mondayBox.getChildren().add(eventBox);
    }
  }
}
