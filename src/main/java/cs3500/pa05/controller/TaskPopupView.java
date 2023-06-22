package cs3500.pa05.controller;

import cs3500.pa05.controller.Task.TaskPopupController;
import cs3500.pa05.view.View;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

/**
 * TaskPopupView is the view class for popup
 */
public class TaskPopupView implements View {
  private FXMLLoader loader;

  /**
   * TaskPopupView constructor
   *
   * @param controller is the constroller
   */
  public TaskPopupView(TaskPopupController controller) {
    this.loader = new FXMLLoader();
    this.loader.setLocation(getClass().getClassLoader().getResource("PopupTask.fxml"));
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
