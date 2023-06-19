package cs3500.pa05.controller;

import cs3500.pa05.model.Calendar;
import cs3500.pa05.model.Day;
import cs3500.pa05.model.DayWeek;
import cs3500.pa05.model.EventIn;
import cs3500.pa05.model.Task;
import cs3500.pa05.model.UserCalInput;
import java.util.List;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * Represents the cs3500.pa05.controller for the journal.
 */
public class JournalController implements Controller {

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

  int counter = 0;

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

    updateCalendar(counter);

    List<Day> days = calendar.getDays();
    for(Day d: days) {
      d.getDayInputsObservable().addListener(
          (ListChangeListener) c -> {
            updateCalendar(counter);
          });
    }
}

  public void updateCalendar(int counter) {
    counter++;
    List<EventIn> events = this.calendar.eventsInCal();
    System.out.println(events.get(0).getName());
    int sizeList = events.size();
    List<Task> tasks = this.calendar.tasksInCal();


    int taskSizeList = tasks.size();

    List<UserCalInput> totalList = this.calendar.getTotalUserInputs();
    int totalSize = totalList.size();

    if(counter == 0) {

      for(UserCalInput use : totalList) {
        if(use instanceof EventIn) {
          this.addUserIn(use, this.createEvent((EventIn) use));
        } else {
          this.addUserIn(use, this.createTask((Task) use));
        }
      }

    } else {

      UserCalInput lastInput = totalList.get(totalSize - 1);

      if (lastInput instanceof EventIn) {

        this.addUserIn(lastInput, this.createEvent((EventIn) lastInput));

      } else if (lastInput instanceof Task) {

        this.addUserIn(lastInput, this.createTask((Task) lastInput));
        taskBox.getChildren().add(createTaskBox((Task) lastInput));
      }
    }
  }

  public void addUserIn(UserCalInput event, VBox eventBox) {
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
