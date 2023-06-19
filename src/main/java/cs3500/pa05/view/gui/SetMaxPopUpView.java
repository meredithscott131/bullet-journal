package cs3500.pa05.view.gui;

import cs3500.pa05.controller.SetMaxPopupController;
import cs3500.pa05.controller.TaskPopupController;
import cs3500.pa05.view.View;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

public class SetMaxPopUpView implements View {

  private FXMLLoader loader;

  public SetMaxPopUpView(SetMaxPopupController controller) {
    this.loader = new FXMLLoader();
    this.loader.setLocation(getClass().getClassLoader().getResource("PopUpMaximum.fxml"));
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
