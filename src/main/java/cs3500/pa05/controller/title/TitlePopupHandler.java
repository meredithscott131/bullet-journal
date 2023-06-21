package cs3500.pa05.controller.title;

import cs3500.pa05.model.Calendar;
import cs3500.pa05.view.gui.TitlePopupView;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class TitlePopupHandler implements EventHandler {

  private Calendar calendar;
  private Label titleLabel;

  TitlePopupHandler(Calendar calendar, Label titleLable) {
    this.calendar = calendar;
    this.titleLabel = titleLable;
  }
  @Override
  public void handle(Event event) {
    Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
    window.close(); // closes popup window
    this.titleLabel.setText(this.calendar.getName());
  }
}
