package cs3500.pa05.controller;

import cs3500.pa05.controller.Task.TaskPopupController;
import cs3500.pa05.model.Calendar;
import cs3500.pa05.view.gui.TaskPopupView;
import cs3500.pa05.view.gui.TitlePopupView;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class TitleEventHandler implements EventHandler {

  private Calendar calendar;

  TitleEventHandler(Calendar calendar) {
    this.calendar = calendar;
  }
  @Override
  public void handle(Event event) {
    Stage stage = new Stage();
    TitlePopupController popupController = new TitlePopupController(this.calendar);
    TitlePopupView popupView = new TitlePopupView(popupController);
    stage.setScene(popupView.load());
    //call run while the tab is open
    stage.show();
    popupController.run();
  }
}