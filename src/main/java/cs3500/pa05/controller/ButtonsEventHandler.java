package cs3500.pa05.controller;

import cs3500.pa05.controller.event.PopupController;
import cs3500.pa05.model.Calendar;
import cs3500.pa05.view.gui.PopupView;
import javafx.event.Event;
import  javafx.event.EventHandler;
import javafx.stage.Stage;

public class ButtonsEventHandler implements EventHandler {

  //this is a calendar.
  private Calendar calendar;

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
