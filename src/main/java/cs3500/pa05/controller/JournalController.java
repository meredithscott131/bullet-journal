package cs3500.pa05.controller;

import cs3500.pa05.model.Calendar;
import cs3500.pa05.model.Day;
import cs3500.pa05.model.DayWeek;
import cs3500.pa05.model.EventIn;
import cs3500.pa05.model.Task;
import cs3500.pa05.model.UserCalInput;
import cs3500.pa05.view.JournalView;
import cs3500.pa05.view.gui.PopupView;
import java.util.ArrayList;
import java.util.List;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.controlsfx.control.PropertySheet;

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

  @FXML
  private VBox taskBox;

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

    TaskButtonsEventHandler taskButt = new TaskButtonsEventHandler(this.calendar);
    taskButton.setOnAction(taskButt);

    updateCalendar();
    List<Day> days = calendar.getDays();
    for(Day d: days) {
      d.getDayInputsObservable().addListener(
          (ListChangeListener) c -> {
            updateCalendar();
          });
    }

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
    int sizeList = events.size();
    List<Task> tasks = this.calendar.tasksInCal();
    int taskSizeList = tasks.size();

    if(sizeList > 0) {
      EventIn e = events.get(sizeList - 1);
      System.out.println("in update cal : " + e.getName());
      this.addEvent(e, this.createEvent(e));
    }

    if(taskSizeList > 0) {
      Task ee = tasks.get(taskSizeList - 1);
      System.out.println("in update cal TASK : " + ee.getName());
      this.addEvent(ee, this.createTask(ee));
      taskBox.getChildren().add(createTaskBox(ee));
    }
  }

  public void updateCalendarTask() {
    List<EventIn> events = this.calendar.eventsInCal();
    List<Task> tasks = this.calendar.tasksInCal();
    for(EventIn e : events) {
      System.out.println("in update cal : " + e.getName());
      this.addEvent(e, this.createEvent(e));
    }
    for(Task ee : tasks) {
      System.out.println("in update cal TASK : " + ee.getName());
      this.addEvent(ee, this.createTask(ee));
    }
  }


  public void addEvent(UserCalInput event, VBox eventBox) {
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

  public VBox createTask(Task task) {
    String cssLayout = "-fx-border-color: grey;\n" +
        "-fx-border-insets: 5;\n" +
        "-fx-border-width: 1;\n";
    VBox newEvent = new VBox();
    newEvent.setStyle(cssLayout);
    Label titleLabel = new Label(task.getName());
    Label descriptionLabel = new Label(task.getDescription());

    newEvent.getChildren().add(titleLabel);
    newEvent.getChildren().add(descriptionLabel);

    return newEvent;
  }

  public VBox createTaskBox(Task task) {
    String cssLayout = "-fx-border-color: grey;\n" +
        "-fx-border-insets: 5;\n" +
        "-fx-border-width: 1;\n";

    VBox newEvent = new VBox();
    newEvent.setStyle(cssLayout);

    CheckBox checkBox = new CheckBox(task.getName() + "\n" + task.getDescription());
    newEvent.getChildren().add(checkBox);
    return newEvent;
  }
}
