package cs3500.pa05.view.gui;

import cs3500.pa05.controller.welcome.WelcomeController;
import cs3500.pa05.view.View;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

/**
 * Represents the View for the Welcome Handler
 */
public class WelcomeHandlerView implements View {
  private final FXMLLoader loader;

  /**
   * Instantiates a new Welcome handler view.
   *
   * @param controller the controller
   */
  public WelcomeHandlerView(WelcomeController controller) {
    this.loader = new FXMLLoader();
    this.loader.setLocation(getClass().getClassLoader().getResource("welcome.fxml"));
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