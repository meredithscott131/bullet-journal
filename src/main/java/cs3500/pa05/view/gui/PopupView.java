package cs3500.pa05.view.gui;

import cs3500.pa05.controller.event.PopupController;
import cs3500.pa05.view.View;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

/**
 * Represents a interface journal GUI cs3500.pa05.view.view.
 */
public class PopupView implements View {
  private FXMLLoader loader;

  public PopupView(PopupController controller) {
    this.loader = new FXMLLoader();
    this.loader.setLocation(getClass().getClassLoader().getResource("PopUpEvent.fxml"));
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
