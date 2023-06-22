package cs3500.pa05.controller;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class ChooseJournalTempHandler implements EventHandler {
  @Override
  public void handle(Event event) {
    //run it here
    Stage stage = new Stage();
    TempJournalController tempController = new TempJournalController();
    TempJournalView tempPopupView = new TempJournalView(tempController);

    try {
      stage.setScene(tempPopupView.load());
      stage.show();
      tempController.run();

    } catch (IllegalStateException exc) {
      System.err.println("Unable to load temp Popup GUI.");
    }
  }
}
