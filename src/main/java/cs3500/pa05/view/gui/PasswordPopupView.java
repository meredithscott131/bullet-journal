package cs3500.pa05.view.gui;

import cs3500.pa05.controller.PasswordController;
import cs3500.pa05.view.View;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

/**
 * Represents the View for the Password Popup
 */
public class PasswordPopupView implements View {
  private final FXMLLoader loader;

  /**
   * Instantiates a new Password popup view.
   *
   * @param controller the controller
   */
  public PasswordPopupView(PasswordController controller) {
    this.loader = new FXMLLoader();
    this.loader.setLocation(getClass().getClassLoader().getResource("enterPassword.fxml"));
    this.loader.setController(controller);
  }

  /**
   * Loads a scene from a journal GUI layout.
   *
   * @return the layout
   */
  @Override
  public Scene load() throws IllegalStateException {
    try {
      return this.loader.load();
    } catch (IOException exc) {
      throw new IllegalStateException("Unable to load popup.");
    }
  }
}