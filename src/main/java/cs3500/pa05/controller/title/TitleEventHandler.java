package cs3500.pa05.controller.title;

import cs3500.pa05.model.Calendar;
import cs3500.pa05.view.gui.TitlePopupView;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * Represents the handler for the title label
 */
public class TitleEventHandler implements EventHandler {
  private final Calendar calendar;
  private final Label titleLabel;

  /**
   * Instantiates a new title event handler.
   *
   * @param calendar   the calendar
   * @param titleLabel the title label
   */
  public TitleEventHandler(Calendar calendar, Label titleLabel) {
    this.calendar = calendar;
    this.titleLabel = titleLabel;
  }

  /**
   * Handles the action event by launching the popup
   */
  @Override
  public void handle(Event event) {
    Stage stage = new Stage();
    TitlePopupController popupController = new TitlePopupController(this.calendar, this.titleLabel);
    TitlePopupView popupView = new TitlePopupView(popupController);
    stage.setScene(popupView.load());
    //call run while the tab is open
    stage.show();
    popupController.run();
  }
}
