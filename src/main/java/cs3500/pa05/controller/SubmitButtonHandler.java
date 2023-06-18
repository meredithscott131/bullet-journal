package cs3500.pa05.controller;

import cs3500.pa05.model.Calendar;
import cs3500.pa05.model.Day;
import cs3500.pa05.model.DayWeek;
import cs3500.pa05.model.EventIn;
import cs3500.pa05.model.UserCalInput;
import cs3500.pa05.view.JournalView;
import cs3500.pa05.view.gui.PopupView;
import java.io.IOException;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
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
      // Adds event to calendar object
      setUserNameInput();
      setUserDescriptionInput();
      setUserDurationInput();
      setStartTimeInput();

      for(Day d: this.calendar.getDays()) {
        for(UserCalInput in: d.getDayInputs()) {
          System.out.println("inital : " + in.getName());
        }
      }

      Day dayToAddTo = this.calendar.getOneDay(eventIn.getDayWeek());
      //dayToAddTo.getDayInputs().add(eventIn);
      dayToAddTo.getDayInputsObservable().add(eventIn);

      for(Day d: this.calendar.getDays()) {
        for(UserCalInput in: d.getDayInputs()) {
          System.out.println("updates : " + in.getName());
        }
      }

      Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
      window.close(); // closes popup window
    }
  }

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
        || eventIn.getDayWeek() == null
        || duration == 0
        || startTime == "";
  }

}
