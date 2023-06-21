package cs3500.pa05.controller.bujofile;

import cs3500.pa05.controller.Controller;
import cs3500.pa05.model.DayWeek;
import java.io.File;
import java.nio.file.Path;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
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

  @FXML
  private TextField calendarTitle;
  @FXML
  private ChoiceBox choiceBox;

  private DayWeek startDayIn;


  public BujoPopupController() {
    this.startDayIn = null;
  }


  @Override
  public void run() {
    initChoiceBox();
    choiceBox.setOnAction(e -> {
      int selectedIndex = choiceBox.getSelectionModel().getSelectedIndex();
      setStartDayIn(selectedIndex);
    });

    submitButton.setOnAction(e -> makeSubmitButton(e));
  }

  public void setStartDayIn(int selected) {
    if (selected == 0) {
      startDayIn = DayWeek.MONDAY;
    } else if (selected == 1) {
      startDayIn = DayWeek.TUESDAY;
    } else if (selected == 2) {
      startDayIn = DayWeek.WEDNESDAY;
    } else if (selected == 3) {
      startDayIn = DayWeek.THURSDAY;
    } else if (selected == 4) {
      startDayIn = DayWeek.FRIDAY;
    } else if (selected == 5) {
      startDayIn = DayWeek.SATURDAY;
    } else if (selected == 6) {
      startDayIn = DayWeek.SUNDAY;
    } else {
      startDayIn = null;
    }
  }

  public void initChoiceBox() {
    choiceBox.getItems().add(DayWeek.MONDAY);
    choiceBox.getItems().add(DayWeek.TUESDAY);
    choiceBox.getItems().add(DayWeek.WEDNESDAY);
    choiceBox.getItems().add(DayWeek.THURSDAY);
    choiceBox.getItems().add(DayWeek.FRIDAY);
    choiceBox.getItems().add(DayWeek.SATURDAY);
    choiceBox.getItems().add(DayWeek.SUNDAY);
  }

  public void makeSubmitButton(Event eventEn) {
    if (this.isNullInput()) {
      System.out.println("all inputs are null");
      // do nothing

      System.out.println(!isValidBujo(bujoText.getText()));
      System.out.println(!isPathValid(bujoText.getText()));

      System.out.println(newNameText.getText().isEmpty());
      System.out.println(!isValidNum(maxEventText.getText()));
      System.out.println(!isValidNum(maxTaskText.getText()));
      System.out.println((submitButton == null));

    } else {
      System.out.println("all inputs aren't null");

      System.out.println(maxEventText.getText());
      System.out.println(isValidNum(maxEventText.getText()));
      System.out.println(isValidNum(maxTaskText.getText()));
      System.out.println(maxTaskText.getText());

      BujoSubmitHandler submit = new BujoSubmitHandler(bujoText.getText(), maxEventText.getText(),
          maxTaskText.getText(), newNameText.getText(), calendarTitle.getText(),
          startDayIn);
      submit.handle(eventEn);
    }
  }

  //are these being grabbed at the right time?
  public boolean isNullInput() {
    return ((!isValidBujo(bujoText.getText()) || !isPathValid(bujoText.getText()))

        && (newNameText.getText().isEmpty() || !isValidNum(maxEventText.getText())
        || !isValidNum(maxTaskText.getText()) || (startDayIn == null))); //added this
  }


  public boolean isValidBujo(String str) {
    return !(bujoText.getText() == "")
        && (isPathValid(str))
        && (isBujo(str));
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
