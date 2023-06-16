package cs3500.pa05;

import static javafx.application.Application.launch;

import cs3500.pa05.controller.JournalController;
import cs3500.pa05.model.Calendar;
import cs3500.pa05.view.JournalView;
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
    Calendar cal = new Calendar();
    JournalController journalCont = new JournalController(cal);
    JournalView journalView = new JournalView(journalCont);

    try {
      stage.setScene(journalView.load());
      journalCont.run();
      stage.show();
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



} //closes cs3500.pa05.Driver class
