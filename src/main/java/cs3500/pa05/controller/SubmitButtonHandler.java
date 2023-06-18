package cs3500.pa05.controller;

import cs3500.pa05.model.Calendar;
import cs3500.pa05.model.Day;
import cs3500.pa05.model.DayWeek;
import cs3500.pa05.model.EventIn;
import cs3500.pa05.view.JournalView;
import cs3500.pa05.view.gui.PopupView;
import java.io.IOException;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SubmitButtonHandler implements EventHandler {
  private final EventIn eventIn;
  private final Calendar calendar;
  private final String nameTask;
  private final String nameDecription;
  private final int duration;
  private final String startTime;
  private final Stage stage;

 public SubmitButtonHandler(Calendar calendar, EventIn eventIn, String nameTask,
                            String nameDecription, String startTime, int duration, Stage stage) {
    this.calendar = calendar;
    this.eventIn = eventIn;
    this.nameTask = nameTask;
    this.nameDecription = nameDecription;
    this.duration = duration;
    this.startTime = startTime;
    this.stage = stage;
  }

  @Override
  public void handle(Event event) {
    if(isNullEvent()) {
      System.out.println("Null " + this.nameTask);
      System.out.println("Null " + this.nameDecription);
      System.out.println("Null " + this.duration);
      //nothing happens
    } else {

      // CURRENT ISSUE... this is creating a new journal controller to add the event onto. we need a way
      // to get our current journal controller without passing in through all of this lol
      // Good news is... its being added correctly!
      FXMLLoader loader = new FXMLLoader(getClass().getResource("/bulletJournal.fxml"));
      JournalController journalCont = new JournalController(this.calendar);
      JournalView journalView = new JournalView(journalCont);
      Stage stage = new Stage();
      stage.setScene(journalView.load());
      stage.show();
      journalCont.run();
      journalCont.addEvent(eventIn, this.createEvent());

      Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
      window.close(); // closes popup window

      // Adds event to calendar object
      setUserNameInput();
      setUserDescriptionInput();
      setUserDurationInput();
      setStartTimeInput();
      Day dayToAddTo = this.calendar.getOneDay(eventIn.getDayWeek());
      dayToAddTo.getDayInputs().add(eventIn);
    }
  }

  //listener: obj that modifies or changes when looking at a certina property
  //when we click play we are reading whats in the text field
  //listener looks at the text field and tells us when we update the text field
  //onchange event listener --> listener that only listens when they stop typing
  //

  public void setUserNameInput() {
    eventIn.setName(nameTask);
  }

  public void setUserDescriptionInput() {
    eventIn.setDescription(nameDecription);
  }

  public void setUserDurationInput() {
    eventIn.setDuration(duration);
  }

  public void setStartTimeInput() {
    eventIn.setStartTime(startTime);
  }

  public boolean isNullEvent() {
    return nameTask == ""
        || nameDecription == ""
        || eventIn.getDayWeek() == null
        || duration == 0
        || startTime == "";
  }

  public VBox createEvent() {
   VBox newEvent = new VBox();
   Label titleLabel = new Label(this.nameTask);
   Label descriptionLabel = new Label(this.nameDecription);
   Label startTimeLabel = new Label(this.startTime);
   Label durationLabel = new Label(String.valueOf(this.duration));

   newEvent.getChildren().add(titleLabel);
   newEvent.getChildren().add(descriptionLabel);
   newEvent.getChildren().add(startTimeLabel);
   newEvent.getChildren().add(durationLabel);

   return newEvent;
  }
}
