package cs3500.pa05.controller;

import static java.lang.Integer.parseInt;

import cs3500.pa05.model.Calendar;
import cs3500.pa05.model.DayWeek;
import cs3500.pa05.model.EventIn;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PopupController implements Controller {

  private EventIn eventIn;
  private boolean popupOn;
  private Calendar calendar;
  @FXML
  private TextField nameTask;
  @FXML
  private TextField description;
  @FXML
  private TextField duration;
  @FXML
  private TextField startTime;
  @FXML
  private Button monButton;
  @FXML
  private Button tuesButton;
  @FXML
  private Button wedButton;
  @FXML
  private Button thurButton;
  @FXML
  private Button friButton;
  @FXML
  private Button satButton;
  @FXML
  private Button sunButton;
  @FXML
  private Button submitButton;

  @FXML
  private Stage stage;

  public PopupController(Calendar calendar) {
    this.eventIn = new EventIn(null, null, null, null, 0);
    this.calendar = calendar;
    this.popupOn = false;
  }

  public void setUserNameInput() {
    eventIn.setName(nameTask.getText());
  }

  public void setUserDescriptionInput() {
    eventIn.setDescription(description.getText());
  }

  public boolean validTime(String time) {
    Pattern p = Pattern.compile("[0-23]:[0-59]");
    Matcher m = p.matcher(time);
    return m.matches();
  }

  public int takeDuration(String durationStr) {
    if (isValidNum(durationStr)) {
      return parseInt(durationStr);
    }
    return 0;
  }

  public boolean isValidNum(String str) {
    try {
      parseInt(str);
      return true;
    } catch (NumberFormatException n) {
      return false;
    }
  }

  public boolean isNullEvent() {
    return eventIn.getName() == null
        && eventIn.getDescription() == null
        && eventIn.getStartTime() == null
        && eventIn.getDuration() == 0;
  }

  @Override
  public void run() {
    sunButton.setOnAction(new PopButtonHandler(DayWeek.SUNDAY, eventIn));
    satButton.setOnAction(new PopButtonHandler(DayWeek.SATURDAY, eventIn));
    monButton.setOnAction(new PopButtonHandler(DayWeek.MONDAY, eventIn));
    tuesButton.setOnAction(new PopButtonHandler(DayWeek.TUESDAY, eventIn));
    wedButton.setOnAction(new PopButtonHandler(DayWeek.WEDNESDAY, eventIn));
    thurButton.setOnAction(new PopButtonHandler(DayWeek.THURSDAY, eventIn));
    friButton.setOnAction(new PopButtonHandler(DayWeek.FRIDAY, eventIn));

    submitButton.setOnAction(e -> makeSubmitButton(e));
  }

  public void makeSubmitButton(Event eventEn) {
    SubmitButtonHandler submit = new SubmitButtonHandler(calendar, eventIn, nameTask.getText(),
        description.getText(), startTime.getText(),
        takeDuration(duration.getText()), this.stage);
    submit.handle(eventEn);
  }
}
