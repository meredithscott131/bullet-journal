package cs3500.pa05.controller;

import cs3500.pa05.model.Calendar;
import cs3500.pa05.view.gui.PopupView;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import  javafx.event.EventHandler;
import javafx.stage.Stage;

public class ButtonsEventHandler implements EventHandler {

  Calendar calendar;

  @Override
  public void handle(Event event) {
    Stage stage = new Stage();
    PopupController popupController = new PopupController(calendar);
    PopupView popupView = new PopupView(popupController);
    stage.setScene(popupView.load());
    popupController.run();
    stage.show();
  }
}
