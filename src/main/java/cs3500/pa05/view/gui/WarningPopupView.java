package cs3500.pa05.view.gui;

import cs3500.pa05.controller.WarningPopupController;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

/**
 * Represents the View for the Warning Popup
 */
public class WarningPopupView {
  private final FXMLLoader loader;

  /**
   * Instantiates a new Warning popup view.
   *
   * @param controller the controller
   */
  public WarningPopupView(WarningPopupController controller) {
    this.loader = new FXMLLoader();
    this.loader.setLocation(getClass().getClassLoader().getResource("PopUpWarning.fxml"));
    this.loader.setController(controller);
  }

  /**
   * Loads a scene from a journal GUI layout.
   *
   * @return the layout
   * @throws IllegalStateException the illegal state exception
   */
  public Scene load() throws IllegalStateException {
    try {
      return this.loader.load();
    } catch (IOException exc) {
      throw new IllegalStateException("Unable to load popup.");
    }
  }
}