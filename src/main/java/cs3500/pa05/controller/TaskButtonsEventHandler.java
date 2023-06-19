package cs3500.pa05.controller;

import cs3500.pa05.model.Calendar;
import cs3500.pa05.view.gui.TaskPopupView;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class TaskButtonsEventHandler implements EventHandler {

  private Calendar calendar;

  TaskButtonsEventHandler(Calendar calendar) {
    this.calendar = calendar;
  }

  @Override
  public void handle(Event event) {
    Stage stage = new Stage();
    TaskPopupController popupController = new TaskPopupController(this.calendar);
    TaskPopupView popupView = new TaskPopupView(popupController);
    stage.setScene(popupView.load());
    //call run while the tab is open
    stage.show();
    popupController.run();
  }
}
