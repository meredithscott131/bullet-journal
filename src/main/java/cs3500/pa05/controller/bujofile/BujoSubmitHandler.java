package cs3500.pa05.controller.bujofile;

import cs3500.pa05.controller.JournalController;
import cs3500.pa05.model.Calendar;
import cs3500.pa05.model.ParseToFile;
import cs3500.pa05.model.ScannerBujo;
import cs3500.pa05.view.JournalView;
import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.stage.Stage;

public class BujoSubmitHandler implements EventHandler {

  private final String pathStr;

  private final String maxEventStr;

  private final String maxTaskStr;

  private final String newBujoStr;

  //private final Stage stage;

  BujoSubmitHandler(String pathStr, String maxEventStr,  String maxTaskStr, String newBujoStr) {
    this.pathStr = pathStr;
    this.maxEventStr = maxEventStr;
    this.maxTaskStr = maxTaskStr;
    this.newBujoStr = newBujoStr;
    //this.stage = stage;
  }

  @Override
  public void handle(Event event) {
    if(!isInvalidBujo()) {
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

      Calendar cal = initCalendar(maxEvent, maxTask, correctPath);
      System.out.println(cal.getName().isEmpty());
      runOnNew(path, cal);

      Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
      window.close(); // closes popup window

    }
  }

  public Calendar initCalendar(int maxEvent, int maxTask, String path) {
    Calendar cal = new Calendar();
    cal.setName("");
    cal.setMaxTask(maxTask);
    cal.setMaxEvent(maxEvent);
    cal.setTotalUserInputs(new ArrayList<>());
    cal.setQuotesNotes("");
    cal.setBujoPath(path);
    cal.initDaysList(new ArrayList<>());
    return cal;
  }

  public void runOnExisting(Path path) {
    ScannerBujo scannerBujo = new ScannerBujo();
    Calendar cal = scannerBujo.readFromFile(path.toFile());
    JournalController journalCont = new JournalController(cal);
    JournalView journalView = new JournalView(journalCont);
    Stage stage = new Stage();

    try {
      stage.setScene(journalView.load());
      stage.show();
      journalCont.run();

    } catch (IllegalStateException exc) {
      System.err.println("Unable to load existing GUI.");
    }
  }

  public void runOnNew(Path path, Calendar calen) {

    ParseToFile parse = new ParseToFile();
    parse.writeToFile(path, calen);

    ScannerBujo scannerBujo = new ScannerBujo();
    Calendar cal = scannerBujo.readFromFile(path.toFile());

    JournalController journalCont = new JournalController(cal);
    JournalView journalView = new JournalView(journalCont);
    Stage stage = new Stage();

    try {
      stage.setScene(journalView.load());
      stage.show();
      journalCont.run();

    } catch (IllegalStateException exc) {
      System.err.println("Unable to load existing GUI.");
    }
  }


  public boolean isInvalidBujo() {
    return (pathStr == "")
        || (!isPathValid(pathStr));
  }

  public static boolean isPathValid(String str) {
    Path givenPath = Path.of(str);
    File file = givenPath.toFile();
    if (!file.exists()) {
      return false;
    }else {
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
