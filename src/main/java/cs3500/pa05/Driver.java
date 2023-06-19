package cs3500.pa05;

import cs3500.pa05.controller.JournalController;
import cs3500.pa05.model.Calendar;
import cs3500.pa05.model.ScannerBujo;
import cs3500.pa05.view.JournalView;
import java.io.File;
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
    ScannerBujo scannerBujo = new ScannerBujo();
    Calendar cal = scannerBujo.readFromFile(new File("src/main/resources/workingBouje.bujo"));
    JournalController journalCont = new JournalController(cal);
    JournalView journalView = new JournalView(journalCont);

    try {
      stage.setScene(journalView.load());
      stage.show();
      journalCont.run();

    } catch (IllegalStateException exc) {
      System.err.println("Unable to load GUI.");
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
