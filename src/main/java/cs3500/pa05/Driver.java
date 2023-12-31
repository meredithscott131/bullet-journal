package cs3500.pa05;

import cs3500.pa05.controller.welcome.WelcomeController;
import cs3500.pa05.view.gui.WelcomeHandlerView;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * cs3500.pa05.Driver class to run the program
 */
public class Driver extends Application {

  /**
   * Starts the GUI for a journal
   *
   * @param stage the JavaFX stage to add elements to
   */
  @Override
  public void start(Stage stage) {

    WelcomeController welController = new WelcomeController();
    WelcomeHandlerView welPopupView = new WelcomeHandlerView(welController);

    try {
      stage.setScene(welPopupView.load());
      stage.show();
      welController.run();

    } catch (IllegalStateException exc) {
      System.err.println("Unable to load welcome GUI.");
    }
  }

  /**
   * Entry point for journal
   *
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    launch();
  }
}