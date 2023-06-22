package cs3500.pa05.controller.welcome;

import cs3500.pa05.controller.bujofile.BujoPopupController;
import cs3500.pa05.view.gui.BujoPopupView;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.stage.Stage;

/**
 * Represents the handler for the welcome screen.
 */
public class WelcomeHandler implements EventHandler {

  /**
   * Handles the button by launching the bujo popup
   */
  @Override
  public void handle(Event event) {
    runBujoPopup();
  }

  /**
   * Run bujo popup.
   */
  public void runBujoPopup() {
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