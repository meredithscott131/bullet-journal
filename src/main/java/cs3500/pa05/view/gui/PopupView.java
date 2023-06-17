package cs3500.pa05.view.gui;


import cs3500.pa05.controller.JournalController;
import cs3500.pa05.view.View;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * Represents a interface journal GUI cs3500.pa05.view.view.
 */
public class PopupView implements View {

  FXMLLoader loader;

  public PopupView(JournalController controller) {
    this.loader = new FXMLLoader();
    this.loader.setLocation(getClass().getClassLoader().getResource("PopUpEvent.fxml"));
    //this.loader.setController(controller);
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


} //closes JournalView class
