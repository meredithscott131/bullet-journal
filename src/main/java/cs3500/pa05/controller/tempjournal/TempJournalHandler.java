package cs3500.pa05.controller.tempjournal;

import cs3500.pa05.controller.Controller;
import cs3500.pa05.controller.password.PasswordController;
import cs3500.pa05.model.Calendar;
import cs3500.pa05.model.ScannerBujo;
import cs3500.pa05.view.View;
import cs3500.pa05.view.gui.PasswordPopupView;
import java.nio.file.Path;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * TempJournalHandler class is the handler
 */
public class TempJournalHandler implements EventHandler {

  private final String pathStr;

  private final String nameStr;

  /**
   * TempJournalHandler constructors
   *
   * @param nameStr name param
   * @param pathStr path param
   */
  public TempJournalHandler(String pathStr, String nameStr) {
    this.pathStr = pathStr;
    this.nameStr = nameStr;
  }

  /**
   * handles template journal
   * @param event event
   */
  @Override
  public void handle(Event event) {
    Path path = Path.of(pathStr);
    ScannerBujo scannerBujo = new ScannerBujo();
    Calendar cal = scannerBujo.readFromFile(path.toFile()); //normal read from file

    //is this where the issue is

    //init calender
    cal.setIsTemp();
    runOnExisting(path, cal, nameStr);

    Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
    window.close();
  }

  /**
   * Runs a pre-existing calendar.
   *
   * @param path the bujo file path
   * @param cal  the calendar
   * @param nameStr  the nameStr name
   */
  public void runOnExisting(Path path, Calendar cal, String nameStr) {
    PasswordController passwordController = new PasswordController(path, cal, nameStr);
    //added this run.
    //could be this
    PasswordPopupView passwordView = new PasswordPopupView(passwordController);
    setView(passwordView, passwordController);
    System.out.println("run on existing");
  }

  /**
   * Sets the desired view.
   *
   * @param view       the view
   * @param controller the controller
   */
  public void setView(View view, Controller controller) {
    Stage stage = new Stage();
    Scene scene = view.load();
    try {
      stage.setScene(scene);
      scene.getStylesheets().add("Normal.css");
      stage.show();
      controller.run();
    } catch (IllegalStateException exc) {
      System.err.println("Unable to load existing GUI.");
    }
  }
}
