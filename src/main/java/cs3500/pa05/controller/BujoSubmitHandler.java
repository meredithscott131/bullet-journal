package cs3500.pa05.controller;

import cs3500.pa05.model.Calendar;
import cs3500.pa05.model.ScannerBujo;
import cs3500.pa05.view.JournalView;
import java.io.File;
import java.nio.file.Path;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class BujoSubmitHandler implements EventHandler {

  private final String pathStr;

  private final String maxEventStr;

  private final String maxTaskStr;

  private final Stage stage;

  BujoSubmitHandler(String pathStr, String maxEventStr, String maxTaskStr
  , Stage stage) {
    this.pathStr = pathStr;
    this.maxEventStr = maxEventStr;
    this.maxTaskStr = maxTaskStr;
    this.stage = stage;
  }

  @Override
  public void handle(Event event) {
    if(!isInvalidBujo()) {
      //take the existing bujo
      Path path = Path.of(pathStr);
      runOnExisting(path);
    } else {
      //make new bujo with numbers
      int maxEvent = getValidNum(maxEventStr);
      int maxTask = getValidNum(maxTaskStr);


    }
  }

  public void runOnExisting(Path path) {
    ScannerBujo scannerBujo = new ScannerBujo();
    Calendar cal = scannerBujo.readFromFile(path.toFile());
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
