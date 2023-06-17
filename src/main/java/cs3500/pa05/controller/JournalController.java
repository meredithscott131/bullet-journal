package cs3500.pa05.controller;

import cs3500.pa05.model.Calendar;
import cs3500.pa05.view.JournalView;
import cs3500.pa05.view.gui.PopupView;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * Represents the cs3500.pa05.controller for the journal
 */
public class JournalController implements Controller {

  //Fields:

  //CalendarHandler handler;??????
  Calendar calendar;

  PopupController popupController;

  @FXML
   private Button taskButton;


  public JournalController(Calendar calendar) {
    this.calendar = calendar;
  }


  /**
   * Initializes the journal
   */
  @Override
  public void run() {
    //handleNewEvet();
      start();
  }

  EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
    public void handle(ActionEvent e) {
      //getTarget gets what the action was done on
      System.out.println(popupController);
      popupController.turnOn();
    }
  };

  public void start() {
    Stage stage = new Stage();
    popupController = new PopupController(calendar);
    PopupView popupView = new PopupView(this);

    try {
      //handleNewEvent(popupController);

      //event.handle(new ActionEvent());

      handleNewEvet();

      if (popupController.getIsOn()) {
        stage.setScene(popupView.load());
        popupController.run();
        stage.show();
    } else {
      stage.close();
    }
    } catch (IllegalStateException exc) {
      System.err.println("Unable to load GUI.");
    }
  }

  /*public void handleNewEvent( Button button) {
    button.setOnAction(e -> System.out.println("hi")); //popup.turnOn()
  }*/

  public void handleNewEvet() {
    System.out.println("hdkjwlejdlkjeklfewk");
    Button newButt = new Button("bro");
   // taskButton = newButt;
    //System.out.println(e.getTarget()); r
      taskButton.setOnAction(e -> new ButtonsEventHandler());
  }





}
