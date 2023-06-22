package cs3500.pa05.controller.bujofile;

import cs3500.pa05.controller.Controller;
import cs3500.pa05.model.DayWeek;
import java.io.File;
import java.nio.file.Path;
import java.util.Objects;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Representation of the controller for the bujo popup.
 */
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

  @FXML
  private TextField setPassword;


  /**
   * Instantiates a new bujo popup controller.
   */
  public BujoPopupController() {
    this.startDayIn = null;
  }


  /**
   * Runs the bujo popup controller.
   */
  @Override
  public void run() {
    initChoiceBox();
    // TODO move this
    choiceBox.setOnAction(e -> {
      int selectedIndex = choiceBox.getSelectionModel().getSelectedIndex();
      setStartDayIn(selectedIndex);
    });
    submitButton.setOnAction(this::makeSubmitButton);
  }

  /**
   * Given a selected integer, sets the
   * starting day for the calendar view.
   *
   * @param selected the selected start day
   */
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

  /**
   * Initializes the choice box for the bujo popup
   */
  public void initChoiceBox() {
    choiceBox.getItems().add(DayWeek.MONDAY);
    choiceBox.getItems().add(DayWeek.TUESDAY);
    choiceBox.getItems().add(DayWeek.WEDNESDAY);
    choiceBox.getItems().add(DayWeek.THURSDAY);
    choiceBox.getItems().add(DayWeek.FRIDAY);
    choiceBox.getItems().add(DayWeek.SATURDAY);
    choiceBox.getItems().add(DayWeek.SUNDAY);
  }

  /**
   * Creates the submit button on the bujo popup
   *
   * @param eventEn the event
   */
  public void makeSubmitButton(Event eventEn) {
    if (!this.isNullInput()) {
      BujoSubmitHandler submit = new BujoSubmitHandler(bujoText.getText(), maxEventText.getText(),
          maxTaskText.getText(), newNameText.getText(), calendarTitle.getText(),
          startDayIn, setPassword.getText());
      submit.handle(eventEn);
    }
  }

  /**
   * Determines whether the popup input is null.
   *
   * @return whether the input is null
   */
  public boolean isNullInput() {
    return ((!isValidBujo(bujoText.getText())
        || !isPathValid(bujoText.getText()))
        && (newNameText.getText().isEmpty()
        || !isValidNum(maxEventText.getText())
        || !isValidNum(maxTaskText.getText())
        || (startDayIn == null)
        || (setPassword.getText().isEmpty())));
  }

  /**
   * Determines whether the given bujo file is valid
   *
   * @param str the link to the bujo file
   * @return whether the file is valid
   */
  public boolean isValidBujo(String str) {
    return !(Objects.equals(bujoText.getText(), ""))
        && (isPathValid(str))
        && (isBujo(str));
  }

  /**
   * Determines whether the given file path is valid.
   *
   * @param str the file path
   * @return whether the path is valid
   */
  public static boolean isPathValid(String str) {
    Path givenPath = Path.of(str);
    File file = givenPath.toFile();
    return file.exists();
  }

  /**
   * Is bujo boolean.
   *
   * @param str the str
   * @return the boolean
   */
  public boolean isBujo(String str) {
    Path givenPath = Path.of(str);
    return givenPath.toString().endsWith(".bujo");
  }

  /**
   * Determines whether the given string is an integer
   *
   * @param strNum the user input
   * @return whether the input is valid
   */
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