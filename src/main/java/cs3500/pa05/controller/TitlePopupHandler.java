package cs3500.pa05.controller;

import cs3500.pa05.model.Calendar;
import cs3500.pa05.view.gui.TitlePopupView;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.stage.Stage;

public class TitlePopupHandler implements EventHandler {

  private Calendar calendar;
  private String input;

  TitlePopupHandler(Calendar calendar, String input) {
    this.calendar = calendar;
    this.input = input;
  }
  @Override
  public void handle(Event event) {
    System.out.println("Input: " + this.input);
    Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
    window.close(); // closes popup window
  }
}
