package cs3500.pa05.controller;

import cs3500.pa05.model.Calendar;
import cs3500.pa05.model.Day;
import cs3500.pa05.model.DayWeek;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class SetMaxPopupController {

  private Calendar calendar;

  @FXML
  private TextField maxTask;
  @FXML
  private TextField maxEvent;
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
  private Button maxSubmitButton;

  public SetMaxPopupController(Calendar calendar) {
    this.calendar = calendar;
  }


  //@Override
  public void run() {
    sunButton.setOnAction(new SetMaxDayButtonHandler(new Day(DayWeek.SUNDAY), maxTask.getText(), maxEvent.getText()));
    satButton.setOnAction(new SetMaxDayButtonHandler(new Day(DayWeek.SATURDAY), maxTask.getText(), maxEvent.getText()));
    monButton.setOnAction(new SetMaxDayButtonHandler(new Day(DayWeek.MONDAY), maxTask.getText(), maxEvent.getText()));
    tuesButton.setOnAction(new SetMaxDayButtonHandler(new Day(DayWeek.TUESDAY), maxTask.getText(), maxEvent.getText()));
    wedButton.setOnAction(new SetMaxDayButtonHandler(new Day(DayWeek.WEDNESDAY), maxTask.getText(), maxEvent.getText()));
    thurButton.setOnAction(new SetMaxDayButtonHandler(new Day(DayWeek.THURSDAY), maxTask.getText(), maxEvent.getText()));
    friButton.setOnAction(new SetMaxDayButtonHandler(new Day(DayWeek.FRIDAY), maxTask.getText(), maxEvent.getText()));

    //maxSubmitButton.setOnAction(e -> makeSubmitButton(e));
  }
//  public void makeSubmitButton(Event eventEn) {
//    SetMaxSubmitButtonHandler submit = new SetMaxSubmitButtonHandler(calendar, task, nameTask.getText(),
//        description.getText(), this.stage);
//    submit.handle(eventEn);
//  }


}
