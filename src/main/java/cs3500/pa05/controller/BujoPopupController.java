package cs3500.pa05.controller;

import cs3500.pa05.controller.event.SubmitButtonHandler;
import cs3500.pa05.model.Calendar;
import cs3500.pa05.model.EventIn;
import cs3500.pa05.model.ScannerBujo;
import cs3500.pa05.view.JournalView;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class BujoPopupController implements Controller{

  @FXML
  private Button submitButton;

  @FXML
  private TextField bujoText;

  @FXML
  private TextField maxEventText;

  @FXML
  private TextField maxTaskText;

  Stage stage;

  public BujoPopupController(Stage stage) {
    this.stage = stage;
  }


  @Override
  public void run() {
    //oldBujo.setOnAction(e -> makeSubmitButton(e));

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

  public void makeSubmitButton(Event eventEn) {
    if (this.isNullEvent()) {
      // do nothing
    } else {
      BujoSubmitHandler submit = new BujoSubmitHandler(bujoText.getText(), maxEventText.getText(),
          maxTaskText.getText(), stage);
      submit.handle(eventEn);
    }
  }

  //are these being grabbed at the right time?
  public boolean isNullEvent() {
    return ((isInvalidBujo(bujoText.getText()) || !isPathValid(bujoText.getText())
    && (!isValidNum(maxEventText.getText()) || !isValidNum(maxTaskText.getText()))));
  }

  public boolean isInvalidBujo(String str) {
    return (bujoText.getText() == "")
    || (!isPathValid(str));
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

  //check this
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
