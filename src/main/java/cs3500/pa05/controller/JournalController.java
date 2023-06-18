package cs3500.pa05.controller;

import cs3500.pa05.model.Calendar;
import cs3500.pa05.model.DayWeek;
import cs3500.pa05.model.EventIn;
import cs3500.pa05.model.Task;
import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * Represents the cs3500.pa05.controller for the journal
 */
public class JournalController implements Controller {

  //Fields:

  //CalendarHandler handler;??????
  private Calendar calendar;

  PopupController popupController;

  @FXML
  private Button taskButton;

  @FXML
  private VBox sundayBox;
  @FXML
  private VBox mondayBox;
  @FXML
  private VBox tuesdayBox;
  @FXML
  private VBox wednesdayBox;
  @FXML
  private VBox thursdayBox;
  @FXML
  private VBox fridayBox;
  @FXML
  private VBox saturdayBox;
  @FXML
  private Button eventButton;

  public JournalController(Calendar calendar) {
    this.calendar = calendar;
  }

  /**
   * Initializes the journal
   */
  @Override
  public void run() {
    ButtonsEventHandler butt = new ButtonsEventHandler(this.calendar);
    eventButton.setOnAction(butt);

    updateCalendar();

    List<EventIn> events = this.calendar.eventsInCal();
    List<Task> tasks = this.calendar.tasksInCal();
    for(EventIn e : events) {
      System.out.println("in update RUN : " + e.getName());
    }
    for(Task ee : tasks) {
      System.out.println("in update cal TASK RUN : " + ee.getName());
    }


  }

  public void updateCalendar() {
    List<EventIn> events = this.calendar.eventsInCal();
    List<Task> tasks = this.calendar.tasksInCal();
    for(EventIn e : events) {
      System.out.println("in update cal : " + e.getName());
      this.addEvent(e, this.createEvent(e));
    }
    for(Task ee : tasks) {
      System.out.println("in update cal TASK : " + ee.getName());
    }
  }

  public void updateCalendar2() {
    List<EventIn> events = this.calendar.eventsInCal();
    List<Task> tasks = this.calendar.tasksInCal();
    for(EventIn e : events) {
      System.out.println("in update cal : " + e.getName());
      this.addEvent(e, this.createEvent(e));
    }
    for(Task ee : tasks) {
      System.out.println("in update cal TASK : " + ee.getName());
    }
  }


  public void addEvent(EventIn event, VBox eventBox) {
    if (event.getDayWeek().equals(DayWeek.SUNDAY)) {
      sundayBox.getChildren().add(eventBox);
    } else if (event.getDayWeek().equals(DayWeek.MONDAY)) {
      mondayBox.getChildren().add(eventBox);
    } else if (event.getDayWeek().equals(DayWeek.TUESDAY)) {
      tuesdayBox.getChildren().add(eventBox);
    } else if (event.getDayWeek().equals(DayWeek.WEDNESDAY)) {
      wednesdayBox.getChildren().add(eventBox);
    } else if (event.getDayWeek().equals(DayWeek.THURSDAY)) {
      thursdayBox.getChildren().add(eventBox);
    } else if (event.getDayWeek().equals(DayWeek.FRIDAY)) {
      fridayBox.getChildren().add(eventBox);
    } else if (event.getDayWeek().equals(DayWeek.SATURDAY)) {
      saturdayBox.getChildren().add(eventBox);
    }
  }

  public VBox createEvent(EventIn event) {
    String cssLayout = "-fx-border-color: grey;\n" +
        "-fx-border-insets: 5;\n" +
        "-fx-border-width: 1;\n";
    VBox newEvent = new VBox();
    newEvent.setStyle(cssLayout);
    Label titleLabel = new Label(event.getName());
    Label descriptionLabel = new Label(event.getDescription());
    Label startTimeLabel = new Label(event.getStartTime());
    Label durationLabel = new Label(String.valueOf(event.getDuration() + " minutes"));

    newEvent.getChildren().add(titleLabel);
    newEvent.getChildren().add(descriptionLabel);
    newEvent.getChildren().add(startTimeLabel);
    newEvent.getChildren().add(durationLabel);

    return newEvent;
  }


}
