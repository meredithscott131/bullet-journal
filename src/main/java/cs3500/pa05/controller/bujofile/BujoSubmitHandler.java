package cs3500.pa05.controller.bujofile;

import cs3500.pa05.controller.Controller;
import cs3500.pa05.controller.JournalController;
import cs3500.pa05.controller.PasswordController;
import cs3500.pa05.model.Calendar;
import cs3500.pa05.model.DayWeek;
import cs3500.pa05.model.ParseToFile;
import cs3500.pa05.model.ScannerBujo;
import cs3500.pa05.view.JournalView;
import cs3500.pa05.view.View;
import cs3500.pa05.view.gui.PasswordPopupView;
import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Objects;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Represents the handler for the bujo popup submit button.
 */
public class BujoSubmitHandler implements EventHandler {
  private final String pathStr;
  private final String maxEventStr;
  private final String maxTaskStr;
  private final String newBujoStr;
  private String calendarTitle;
  private final DayWeek startDay;
  private final String passwordStr;

  /**
   * Instantiates a new bujo submit handler.
   *
   * @param pathStr       the pre-existing bujo file path
   * @param maxEventStr   the max events a calendar can have
   * @param maxTaskStr    the max tasks a calendar can have
   * @param newBujoStr    the new bujo file path
   * @param calendarTitle the calendar title
   * @param startDay      the start day of the calendar
   * @param passwordStr   the password for the calendar
   */
  BujoSubmitHandler(String pathStr, String maxEventStr,  String maxTaskStr,
                    String newBujoStr, String calendarTitle, DayWeek startDay, String passwordStr) {
    this.pathStr = pathStr;
    this.maxEventStr = maxEventStr;
    this.maxTaskStr = maxTaskStr;
    this.newBujoStr = newBujoStr;
    this.calendarTitle = calendarTitle;
    this.startDay = startDay;
    this.passwordStr = passwordStr;
  }

  /**
   * Handles the submit button action.
   *
   * @param event the action event
   */
  @Override
  public void handle(Event event) {
    if (!isInvalidBujo()) {
      //take the existing bujo
      Path path = Path.of(pathStr);

      ScannerBujo scannerBujo = new ScannerBujo();
      Calendar cal = scannerBujo.readFromFile(path.toFile());

      runOnExisting(path, cal);

      Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
      window.close();
    } else {
      //make new bujo with numbers
      int maxEvent = getValidNum(maxEventStr);
      int maxTask = getValidNum(maxTaskStr);

      String correctPath = "NewBujo/" + newBujoStr + ".bujo";
      Path path = Path.of(correctPath);

      if (calendarTitle.isEmpty()) {
        this.calendarTitle = "unnamed";
      }

      Calendar cal = initCalendar(maxEvent, maxTask,
          correctPath, calendarTitle,
          startDay, passwordStr);

      ParseToFile parse = new ParseToFile();
      parse.writeToFile(path, cal);

      ScannerBujo scannerBujo = new ScannerBujo();
      Calendar calen = scannerBujo.readFromFile(path.toFile());

      runOnNew(path, calen);

      Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
      window.close();
    }
  }

  /**
   * Initializes a new Calendar
   *
   * @param maxEvent the max event
   * @param maxTask  the max task
   * @param path     the bujo location path
   * @param name     the name
   * @param startDay the start day
   * @param password the password
   * @return the new calendar
   */
  public Calendar initCalendar(int maxEvent, int maxTask, String path,
                               String name, DayWeek startDay, String password) {
    Calendar cal = new Calendar();
    cal.setName(name);
    cal.setMaxTask(maxTask);
    cal.setMaxEvent(maxEvent);
    cal.setTotalUserInputs(new ArrayList<>());
    cal.setQuotesNotes("");
    cal.setBujoPath(path);
    cal.initDaysList(new ArrayList<>());
    cal.setStartDay(startDay);
    cal.setPassword(password);
    return cal;
  }

  /**
   * Runs a pre-existing calendar.
   *
   * @param path the bujo file path
   * @param cal  the calendar
   */
  public void runOnExisting(Path path, Calendar cal) {
    PasswordController passwordController = new PasswordController(path, cal, cal.getName());
    PasswordPopupView passwordView = new PasswordPopupView(passwordController);
    setView(passwordView, passwordController);
  }

  /**
   * Run a new calendar
   *
   * @param path  the bujo file path
   * @param calen the calendar
   */
  public void runOnNew(Path path, Calendar calen) {
    JournalController journalCont = new JournalController(calen);
    JournalView journalView = new JournalView(journalCont, startDay);
    setView(journalView, journalCont);
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


  /**
   * Determines whether the bujo file path is valid.
   *
   * @return whether the path is valid
   */
  public boolean isInvalidBujo() {
    return (Objects.equals(pathStr, ""))
        || !(pathStr.endsWith(".bujo"))
        || (!isPathValid(pathStr));
  }

  /**
   * Determines whether the given path is valid
   *
   * @param str the path
   * @return whether it is valid
   */
  public static boolean isPathValid(String str) {
    Path givenPath = Path.of(str);
    File file = givenPath.toFile();
    return file.exists();
  }

  /**
   * Parses the given string to an integer.
   *
   * @param str the maximum
   * @return it as an integer
   */
  public int getValidNum(String str) {
    return Integer.parseInt(str);
  }
}
