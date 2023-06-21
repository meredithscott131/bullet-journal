package cs3500.pa05.controller.bujofile;

import cs3500.pa05.controller.JournalController;
import cs3500.pa05.controller.PasswordController;
import cs3500.pa05.model.Calendar;
import cs3500.pa05.model.DayWeek;
import cs3500.pa05.model.ParseToFile;
import cs3500.pa05.model.ScannerBujo;
import cs3500.pa05.view.JournalView;
import cs3500.pa05.view.gui.PasswordPopupView;
import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BujoSubmitHandler implements EventHandler {

  private final String pathStr;

  private final String maxEventStr;

  private final String maxTaskStr;

  private final String newBujoStr;

  private String calendarTitle;

  private DayWeek startDay;

  private Calendar cal;

  private String passwordStr;

  BujoSubmitHandler(String pathStr, String maxEventStr,  String maxTaskStr,
                    String newBujoStr, String calendarTitle, DayWeek startDay, String passwordStr) {
    this.pathStr = pathStr;
    this.maxEventStr = maxEventStr;
    this.maxTaskStr = maxTaskStr;
    this.newBujoStr = newBujoStr;
    this.calendarTitle = calendarTitle;
    this.startDay = startDay;
    this.passwordStr = passwordStr;
    //this.stage = stage;
  }

  @Override
  public void handle(Event event) {
    if (!isInvalidBujo()) {
      //take the existing bujo
      Path path = Path.of(pathStr);
      runOnExisting(path);

      Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
      window.close(); // closes popup window

    } else {
      //make new bujo with numbers
      int maxEvent = getValidNum(maxEventStr);
      int maxTask = getValidNum(maxTaskStr);

      String correctPath = "NewBujo/" + newBujoStr + ".bujo";
      Path path = Path.of(correctPath);

      if (calendarTitle.isEmpty()) {
        this.calendarTitle = "unnamed";
      }

      cal = initCalendar(maxEvent, maxTask, correctPath, calendarTitle, startDay, passwordStr);

      System.out.println(cal.getName().isEmpty());
      runOnNew(path, cal);

      Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
      window.close(); // closes popup window

    }
  }

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

  //pass in dayweek
  public void runOnExisting(Path path) {
    PasswordController passwordController = new PasswordController(path);
    PasswordPopupView paswordView = new PasswordPopupView(passwordController);

    Stage stage = new Stage();
    Scene scene = paswordView.load();

    try {
      stage.setScene(scene);
      scene.getStylesheets().add("Normal.css");
      stage.show();
      passwordController.run();

    } catch (IllegalStateException exc) {
      System.err.println("Unable to load existing GUI.");
    }

    /*
    ScannerBujo scannerBujo = new ScannerBujo();
    Calendar cal = scannerBujo.readFromFile(path.toFile());
    JournalController journalCont = new JournalController(cal);

    //based on dayweek load a certain journaliew (change fxml)
    JournalView journalView = new JournalView(journalCont, cal.getStartDay());
    Stage stage = new Stage();
    Scene scene = journalView.load();

    try {
      stage.setScene(scene);
      scene.getStylesheets().add("Normal.css");
      stage.show();
      journalCont.run();

    } catch (IllegalStateException exc) {
      System.err.println("Unable to load existing GUI.");
    }
    */
  }

  public void runOnNew(Path path, Calendar calen) {

    ParseToFile parse = new ParseToFile();
    parse.writeToFile(path, calen);

    ScannerBujo scannerBujo = new ScannerBujo();
    Calendar cal = scannerBujo.readFromFile(path.toFile());

    JournalController journalCont = new JournalController(cal);
    JournalView journalView = new JournalView(journalCont, startDay);
    Stage stage = new Stage();
    Scene scene = journalView.load();

    try {
      stage.setScene(scene);
      scene.getStylesheets().add("Normal.css");
      stage.show();
      journalCont.run();

    } catch (IllegalStateException exc) {
      System.err.println("Unable to load existing GUI.");
    }
  }


  public boolean isInvalidBujo() {
    return (pathStr == "")
        || !(pathStr.toString().endsWith(".bujo"))
        || (!isPathValid(pathStr));
  }

  public static boolean isPathValid(String str) {
    Path givenPath = Path.of(str);
    File file = givenPath.toFile();
    if (!file.exists()) {
      return false;
    } else {
      return true;
    }
  }

  public int getValidNum(String str) {
    return Integer.parseInt(str);
  }

  public boolean isValidNum(String strNum) {
    if (strNum.isEmpty()) {
      return false;
    } else {
      try {
        Integer.parseInt(strNum);
        return true;
      } catch (NumberFormatException e) {
        return false;
      }
    }
  }

}
