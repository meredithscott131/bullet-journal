package cs3500.pa05.controller;


import cs3500.pa05.model.Calendar;
import cs3500.pa05.view.JournalView;
import cs3500.pa05.view.gui.PopupView;
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

  @FXML
  Button taskButton;



  public JournalController(Calendar calendar) {
    this.calendar = calendar;
  }


  /**
   * Initializes the journal
   */
  @Override
  public void run() {
    start();
  }

  public void start() {
    Stage stage = new Stage();
    PopupController popupController = new PopupController(calendar);
    PopupView popupView = new PopupView(this);
    try {
      handleNewEvent(popupController);
      if (popupController.getIsOn()) {
        stage.setScene(popupView.load());
        popupController.run();
        stage.show();
    } else {
      stage.close();
    }
    } catch (IllegalStateException exc) {
      System.err.println("Unable to load GUI.");
    }
  }

  public void handleNewEvent(PopupController popup) {
    taskButton.setOnAction(e -> popup.turnOn());
  }

}
