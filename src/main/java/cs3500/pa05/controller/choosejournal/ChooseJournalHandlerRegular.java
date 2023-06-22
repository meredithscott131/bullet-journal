package cs3500.pa05.controller.choosejournal;

import cs3500.pa05.controller.bujofile.BujoPopupController;
import cs3500.pa05.view.gui.BujoPopupView;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.stage.Stage;

/**
 * Represents the handler for the regular journal popup.
 */
public class ChooseJournalHandlerRegular implements EventHandler {

  /**
   * Instantiates a new regular journal handler.
   */
  ChooseJournalHandlerRegular() {
  }

  /**
   * Handles the submit button action.
   *
   * @param event the action event
   */
  @Override
  public void handle(Event event) {
    Stage stage = new Stage();
    BujoPopupController bujoController = new BujoPopupController();
    BujoPopupView bujoPopupView = new BujoPopupView(bujoController);

    try {
      stage.setScene(bujoPopupView.load());
      stage.show();
      bujoController.run();

    } catch (IllegalStateException exc) {
      System.err.println("Unable to load bujoPopup GUI.");
    }
  }
}
