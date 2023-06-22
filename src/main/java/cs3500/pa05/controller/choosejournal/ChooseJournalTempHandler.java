package cs3500.pa05.controller.choosejournal;

import cs3500.pa05.controller.tempjournal.TempJournalController;
import cs3500.pa05.controller.tempjournal.TempJournalView;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.stage.Stage;

/**
 * Represents the handler for the template journal popup.
 */
public class ChooseJournalTempHandler implements EventHandler {

  /**
   * Instantiates a new template journal handler.
   */
  ChooseJournalTempHandler() {

  }

  /**
   * Handles the submit button action.
   *
   * @param event the action event
   */
  @Override
  public void handle(Event event) {
    //run it here
    Stage stage = new Stage();
    TempJournalController tempController = new TempJournalController();
    TempJournalView tempPopupView = new TempJournalView(tempController);

    try {
      stage.setScene(tempPopupView.load());
      stage.show();
      tempController.run();

    } catch (IllegalStateException exc) {
      System.err.println("Unable to load temp Popup GUI.");
    }
  }
}
