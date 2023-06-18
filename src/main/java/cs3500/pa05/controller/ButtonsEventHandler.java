package cs3500.pa05.controller;

import cs3500.pa05.model.Calendar;
import cs3500.pa05.view.gui.PopupView;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import  javafx.event.EventHandler;
import javafx.stage.Stage;

public class ButtonsEventHandler implements EventHandler {

  private Calendar calendar;

  ButtonsEventHandler(Calendar calendar) {
    this.calendar = calendar;
  }

  ButtonsEventHandler(Calendar calendar) {
    this.calendar = calendar;
  }

  @Override
  public void handle(Event event) {
    Stage stage = new Stage();
    PopupController popupController = new PopupController(this.calendar);
    PopupView popupView = new PopupView(popupController);
    stage.setScene(popupView.load());
    //call run while the tab is open
    stage.show();
    popupController.run();
  }
}
