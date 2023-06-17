package cs3500.pa05.controller;

import static java.lang.Integer.parseInt;

import cs3500.pa05.model.Calendar;
import cs3500.pa05.model.DayWeek;
import cs3500.pa05.model.EventIn;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

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

  public PopupController(Calendar calendar) {
    this.eventIn = new EventIn(null, null, null, null, 0);
    this.calendar = calendar;
    this.popupOn = false;
  }

  public boolean isOn() {
    return popupOn;
  }

  public void turnOn() {
    popupOn = true;
  }

  public void setUserNameInput() {
    eventIn.setName(nameTask.getText());
  }

  public void setUserDescriptionInput() {
    eventIn.setDescription(description.getText());
  }

  //EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {

/*

    public void handle(ActionEvent e) {

      sunButton.setOnAction(new PopButtonHandler(DayWeek.SUNDAY));
      satButton.setOnAction(new PopButtonHandler(DayWeek.SATURDAY));
      monButton.setOnAction(new PopButtonHandler(DayWeek.MONDAY));
      tuesButton.setOnAction(new PopButtonHandler(DayWeek.TUESDAY));
      wedButton.setOnAction(new PopButtonHandler(DayWeek.WEDNESDAY));
      thurButton.setOnAction(new PopButtonHandler(DayWeek.THURSDAY));
      friButton.setOnAction(new PopButtonHandler(DayWeek.FRIDAY));

      submitButton.setOnAction(new SubmitButtonHandler(eventIn, nameTask.getText(),
          decription.getText(), takeValidTime(startTime.getText()),
          takeDuration(duration.getText())));
    }
  //}
*/

  public boolean validTime(String time) {
    Pattern p = Pattern.compile("[0-23]:[0-59]");
    Matcher m = p.matcher(time);
    return m.matches();
  }

  public String takeValidTime(String time) {
    if (validTime(time)) {
      return time;
    } else {
      return null;
    }
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


  public void setSubmit() {
    if (isNullEvent()) {
      //nothing happens
    } else {
      //sets the userIn name and description
      setUserNameInput();
      setUserDescriptionInput();
      //adds this event to the list of events on the day of this event
      calendar.getOneDay(eventIn.getDayWeek()).getDayInputs().add(eventIn);
      System.out.println(eventIn.getDayWeek());
    }
  }

  public boolean isNullEvent() {
    return eventIn.getName() == null
        && eventIn.getDescription() == null
        && eventIn.getStartTime() == null
        && eventIn.getDuration() == 0;
  }


// Listen for TextField text changes


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
        takeDuration(duration.getText()));
    submit.handle(eventEn);
  }

  /*
  submitButton.setOnAction(new SubmitButtonHandler(eventIn, nameTask.getText(),
  listenToField2(description), listenToField2(startTime),
  takeDuration(listenToField2(duration))));
*/
  public String changeToStr(String given) {
    return given;
  }
/*

  public String listenToField(TextField textField) {
    String exStr = new String();
    nameTask.textProperty().addListener(
        (observable, oldValue, newValue) -> changeToStr(newValue));
    return changeToStr(newValue);
  }
*/

  public String listenToField2(TextField textField) {
    StringBuilder sb = new StringBuilder();
    textField.textProperty().addListener(
        (observable, oldValue, newValue) -> sb.append(newValue));
    //sb.append(newValue)
    //sb.append(newValue)
    System.out.println("printing: " + sb);
    return sb.toString();
  }
}