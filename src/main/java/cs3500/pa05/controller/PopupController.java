package cs3500.pa05.controller;

import cs3500.pa05.model.Calendar;
import cs3500.pa05.model.Day;
import cs3500.pa05.model.DayWeek;
import cs3500.pa05.model.Event;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PopupController implements Controller{

  private Event eventIn;

  private boolean popupOn;

  private Calendar calendar;
  @FXML
  TextField nameTask;

  @FXML
  TextField decription;

  @FXML
  TextField duration;

  @FXML
  TextField startTime;

  @FXML
  Button monButton;

  @FXML
  Button tuesButton;

  @FXML
  Button wedButton;

  @FXML
  Button thurButton;

  @FXML
  Button friButton;

  @FXML
  Button satButton;

  @FXML
  Button sunButton;

  @FXML
  Button submitButton;

  @FXML
  Button cancelButton;

  public PopupController(Calendar calendar) {
    this.eventIn = new Event(null, null, null, null, 0);
    this.calendar = calendar;
    this.popupOn = popupOn;
  }

  public boolean getIsOn() {
    return popupOn;
  }

  public boolean turnOn() {
    return popupOn = true;
  }

  public void setUserNameInput() {
    eventIn.setName(nameTask.getText());
  }

  public void setUserDescriptionInput() {
    eventIn.setDescription(decription.getText());
  }

  EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
    public void handle(ActionEvent e) {
      //getTarget gets what the action was done on
      if (e.getTarget().equals(thurButton)) {
        eventIn.setDay(DayWeek.THURSDAY);
      } else if (e.getTarget().equals(satButton)) {
        eventIn.setDay(DayWeek.SATURDAY);
      } else if (e.getTarget().equals(sunButton)) {
        eventIn.setDay(DayWeek.SUNDAY);
      } else if (e.getTarget().equals(monButton)) {
        eventIn.setDay(DayWeek.MONDAY);
      } else if (e.getTarget().equals(tuesButton)) {
        eventIn.setDay(DayWeek.TUESDAY);
      } else if (e.getTarget().equals(wedButton)) {
        eventIn.setDay(DayWeek.WEDNESDAY);
      } else if (e.getTarget().equals(friButton)){
        eventIn.setDay(DayWeek.FRIDAY);
      } else if(e.getTarget().equals(submitButton)) {
        setSubmit();
      } else {
        popupOn = false;
      }
    }
  };

  public void setSubmit() {
    if(isNullEvent()) {
      //nothing happens
    } else {
      //sets the userIn name and description
      setUserNameInput();
      setUserDescriptionInput();
      //adds this event to the list of events on the day of this event
      calendar.getOneDay(eventIn.getDayWeek()).getDayInputs().add(eventIn);
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

  }



}
