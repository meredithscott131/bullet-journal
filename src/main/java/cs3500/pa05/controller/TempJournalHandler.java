package cs3500.pa05.controller;

import cs3500.pa05.model.Calendar;
import cs3500.pa05.model.Day;
import cs3500.pa05.model.ScannerBujo;
import cs3500.pa05.view.View;
import cs3500.pa05.view.gui.PasswordPopupView;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TempJournalHandler implements EventHandler {

  private final String pathStr;

  private final String nameStr;

  public TempJournalHandler(String pathStr, String nameStr) {
    this.pathStr = pathStr;
    this.nameStr = nameStr;
  }

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
   */
  public void runOnExisting(Path path, Calendar cal, String nameStr) {
    PasswordController passwordController = new PasswordController(path, cal, nameStr);
    //added this run
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