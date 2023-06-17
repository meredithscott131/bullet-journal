package cs3500.pa05.controller;

import cs3500.pa05.model.Calendar;
import cs3500.pa05.view.JournalView;
import cs3500.pa05.view.gui.PopupView;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * Represents the cs3500.pa05.controller for the journal
 */
public class JournalController implements Controller {

  //Fields:

  //CalendarHandler handler;??????
  Calendar calendar;

  PopupController popupController;

  @FXML
  private Button taskButton;

  /*

  @FXML
  private Button sundayBox;

  @FXML
  private Button mondayBox;

  @FXML
  private Button tuesdayBox;

  @FXML
  private Button wednesdayBox;

  @FXML
  private Button thrusdayBox;

  @FXML
  private Button fridayBox;

  @FXML
  private Button saturdayBox;
*/


  public JournalController(Calendar calendar) {
    this.calendar = calendar;
  }


  /**
   * Initializes the journal
   */
  @Override
  public void run() {
    ButtonsEventHandler butt = new ButtonsEventHandler(calendar);
    taskButton.setOnAction(butt);
  }
}
