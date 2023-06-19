package cs3500.pa05.controller.bujofile;

import cs3500.pa05.controller.Controller;
import java.io.File;
import java.nio.file.Path;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class BujoPopupController implements Controller {

  @FXML
  private Button submitButton;

  @FXML
  private TextField bujoText;

  @FXML
  private TextField maxEventText;

  @FXML
  private TextField maxTaskText;

  @FXML
  private TextField newNameText;

  @FXML
  private Stage stage;

  //Stage stage;

  public BujoPopupController() {
   // this.stage = stage;
  }


  @Override
  public void run() {
    submitButton.setOnAction(e -> makeSubmitButton(e));
/*
    Stage stage = new Stage();
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
    */


  }

  public void makeSubmitButton(Event eventEn) {
    if (this.isNullInput()) {
      System.out.println("all inputs are null");
      // do nothing

      System.out.println("NULLLLL:L:L");
      System.out.println(maxEventText.getText());
      System.out.println(!isValidNum(maxEventText.getText()) );
      System.out.println(!isValidNum(maxTaskText.getText()));
      System.out.println(maxTaskText.getText());
      System.out.println("is invalid bujo " + isValidBujo(bujoText.getText()));
      System.out.println("is not path valid " + !isPathValid(bujoText.getText()));

    } else {
      System.out.println("all inputs aren't null");

      System.out.println(maxEventText.getText());
      System.out.println(isValidNum(maxEventText.getText()) );
      System.out.println(isValidNum(maxTaskText.getText()));
      System.out.println(maxTaskText.getText());

      BujoSubmitHandler submit = new BujoSubmitHandler(bujoText.getText(), maxEventText.getText(),
          maxTaskText.getText(), newNameText.getText());
      submit.handle(eventEn);
    }
  }

  //are these being grabbed at the right time?
  public boolean isNullInput() {
    return ((!isValidBujo(bujoText.getText()) || !isPathValid(bujoText.getText())
  && (newNameText.getText().isEmpty() || !isValidNum(maxEventText.getText())
        || !isValidNum(maxTaskText.getText()))));
  }


  public boolean isValidBujo(String str) {
    return !(bujoText.getText() == "")
    || (!isPathValid(str))
    || (!isBujo(str));
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

  public boolean isBujo(String str) {
    Path givenPath = Path.of(str);
    return givenPath.toString().endsWith(".bujo");
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
