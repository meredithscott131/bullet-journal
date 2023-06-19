package cs3500.pa05.controller;

import cs3500.pa05.model.Calendar;
import cs3500.pa05.view.gui.SetMaxPopUpView;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class SetMaxButtonHandler implements EventHandler {

  private Calendar calendar;

  SetMaxButtonHandler(Calendar calendar) {this.calendar = calendar; }



  @Override
  public void handle(Event event) {
    Stage stage = new Stage();
    SetMaxPopupController popupController = new SetMaxPopupController(this. calendar);
    SetMaxPopUpView popUpView = new SetMaxPopUpView(popupController);
    stage.setScene(popUpView.load());
    stage.show();
    popupController.run();
  }
}
