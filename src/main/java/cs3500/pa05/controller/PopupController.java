package cs3500.pa05.controller;

import cs3500.pa05.model.Day;
import cs3500.pa05.model.Event;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class PopupController {

  Event event;
  @FXML
  TextField nameTask;

  @FXML
  TextField decription;

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

  public PopupController() {
    this.event = new Event();
  }

  /**
   * Initializes the controller
   */
  @Override
  public void run() {

  }

  public void getUserNameinput() {

  }

  EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
    public void handle(ActionEvent e)
    {
      //getTarget gets what the action was done on
      e.getTarget().equals(thurButton);
    }
  };



}
