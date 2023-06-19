package cs3500.pa05.view.gui;

import cs3500.pa05.controller.SetMaxPopupController;
import cs3500.pa05.controller.WarningPopupController;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

public class WarningPopupView {

  private FXMLLoader loader;

  public WarningPopupView(WarningPopupController controller) {
    this.loader = new FXMLLoader();
    this.loader.setLocation(getClass().getClassLoader().getResource("PopUpWarning.fxml"));
    this.loader.setController(controller);
  }



  /**
   * Loads a scene from a journal GUI layout.
   *
   * @return the layout
   */
  //@Override
  public Scene load() throws IllegalStateException {
    try {
      return this.loader.load();
    } catch (IOException exc) {
      throw new IllegalStateException("Unable to load popup.");
    }
  }


}
