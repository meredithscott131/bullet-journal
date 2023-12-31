package cs3500.pa05.controller.tempjournal;

import cs3500.pa05.controller.tempjournal.TempJournalController;
import cs3500.pa05.view.View;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

/**
 * TempJournalView class is the temp
 */
public class TempJournalView implements View {
  private FXMLLoader loader;

  /**
   * TempJournalView constructor
   * @param controller the controller
   */
  public TempJournalView(TempJournalController controller) {
    this.loader = new FXMLLoader();
    this.loader.setLocation(getClass().getClassLoader().getResource("templateBujo.fxml"));
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
      throw new IllegalStateException("Unable to load journal temp popup.");
    }
  }
}