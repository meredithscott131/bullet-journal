package cs3500.pa05.controller;

import cs3500.pa05.controller.ChooseJournalController;
import cs3500.pa05.controller.TempJournalController;
import cs3500.pa05.view.View;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

public class TempJournalView implements View {
  private FXMLLoader loader;

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
  //@Override
  public Scene load() throws IllegalStateException {
    try {
      return this.loader.load();
    } catch (IOException exc) {
      throw new IllegalStateException("Unable to load journal temp popup.");
    }
  }
}