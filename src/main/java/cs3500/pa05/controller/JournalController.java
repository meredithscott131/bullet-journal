package cs3500.pa05.controller;

import cs3500.pa05.controller.Task.TaskButtonsEventHandler;
import cs3500.pa05.controller.event.ButtonsEventHandler;
import cs3500.pa05.controller.title.TitleEventHandler;
import cs3500.pa05.model.Calendar;
import cs3500.pa05.model.CompareByDuration;
import cs3500.pa05.model.CompareByInputName;
import cs3500.pa05.model.Day;
import cs3500.pa05.model.DayWeek;
import cs3500.pa05.model.EventIn;
import cs3500.pa05.model.OrderType;
import cs3500.pa05.model.Task;
import cs3500.pa05.model.UserCalInput;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 * Represents the cs3500.pa05.controller for the journal
 */
public class JournalController implements Controller {

  private Calendar calendar;
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
  private Button taskButton;
  @FXML
  private Button saveButton;
  @FXML
  private Button themeButton;

  @FXML
  private VBox taskBox;
  @FXML
  private TextField quotesNotes;

  @FXML
  private ProgressBar progressbar;

  @FXML
  private ProgressIndicator progressindicator;

  @FXML
  private Label titleLabel;

  @FXML
  private ChoiceBox dropDown;

  private int counter = 0;

  //comment
  private int checkboxCouter = 0;

  public JournalController(Calendar calendar) {
    this.calendar = calendar;
  }

  /**
   * Initializes the journal
   */
  @Override
  public void run() {

    initOrder();

    ButtonsEventHandler butt = new ButtonsEventHandler(this.calendar);
    eventButton.setOnAction(butt);

    TaskButtonsEventHandler taskButt = new TaskButtonsEventHandler(this.calendar);
    taskButton.setOnAction(taskButt);

    ThemeButtonHandler themeButt = new ThemeButtonHandler(this.calendar, themeButton);
    themeButton.setOnAction(themeButt);

    SaveButtonHandler saveButt = new SaveButtonHandler(this.calendar);
    saveButton.setOnAction(saveButt);

    updateCalenderFirst();

    Sorting sorting = new Sorting(this.calendar);

    List<Day> days = calendar.getDays();
    for (Day d : days) {
      d.getDayInputsObservable().addListener(
          (ListChangeListener) c -> {
            if (this.calendar.getOrderType().equals(OrderType.NORMAL)) {
              updateCalendarOnAction();

              taskBox.getChildren().clear();
              sorting.sortJustTask(this.calendar.getOrderType());
              displayJustTask();
            } else {
              d.listClear();
              updateCalendarOnAction();
              organize();

              taskBox.getChildren().clear();
              sorting.sortJustTask(this.calendar.getOrderType());
              displayJustTask();
            }
          });
    }

    this.quotesNotes.textProperty().addListener((observable, oldValue, newValue) -> {
      this.calendar.setQuotesNotes(newValue);
    });

    dropDown.setOnAction(e -> {
      int selectedIndex = dropDown.getSelectionModel().getSelectedIndex();
      if (selectedIndex == 0) {
        organizeBasedOnName();
        taskBox.getChildren().clear();
        sorting.sortJustTask(OrderType.NAME);
        displayJustTask();
      } else if (selectedIndex == 1) {
        organizeBasedOnDur();
        taskBox.getChildren().clear();
        sorting.sortJustTask(OrderType.DURATION);
        displayJustTask();
      }
    });

    this.titleLabel.setOnMouseClicked(new TitleEventHandler(this.calendar, this.titleLabel));

  }

  public void organize() {
    if (this.calendar.getOrderType() == OrderType.NAME) {
      organizeBasedOnName();
    } else if (this.calendar.getOrderType() == OrderType.DURATION) {
      organizeBasedOnDur();
    }
  }

  public void organizeBasedOnName() {
    this.calendar.setOrderType(OrderType.NAME);
    Sorting sorting = new Sorting(this.calendar);

    for (Day d : this.calendar.getDays()) {
      d.listClear();
      d.listCopy();
    }

    sorting.updateOrder(OrderType.NAME);
    clearCalendar();
    updateCalOrderDisplay();
  }

  public void organizeBasedOnDur() {
    Sorting sorting = new Sorting(this.calendar);
    this.calendar.setOrderType(OrderType.DURATION);

    for (Day d : this.calendar.getDays()) {
      d.listClear();
      d.listCopy();
    }

    sorting.updateOrder(OrderType.DURATION);
    clearCalendar();
    updateCalOrderDisplay();
  }

  public void clearCalendar() {
    sundayBox.getChildren().clear();
    mondayBox.getChildren().clear();
    tuesdayBox.getChildren().clear();
    wednesdayBox.getChildren().clear();
    thursdayBox.getChildren().clear();
    fridayBox.getChildren().clear();
    saturdayBox.getChildren().clear();
    //taskBox.getChildren().clear();
  }


  //make a copy of the complete list of tasks


  public void displayJustTask() {
    for (Task t : this.calendar.getListTasks()) {
      taskBox.getChildren().add(createTaskBox(t));
    }
  }

  public void initOrder() {
    dropDown.getItems().add(OrderType.NAME);
    dropDown.getItems().add(OrderType.DURATION);
  }


  public void updateCalOrderDisplay() {
    List<Day> days = this.calendar.getDays();
    for (Day d : days) {
      List<UserCalInput> inputs = d.getListCopy();
      for (UserCalInput use : inputs) {
        if (use instanceof EventIn) {
          this.addUserIn(use, this.createEvent((EventIn) use));
        } else if (use instanceof Task) {
          this.addUserIn(use, this.createTask((Task) use));
        }
      }
    }
  }

  public void updateCalenderFirst() {
    this.titleLabel.setText(this.calendar.getName());
    this.quotesNotes.setText(this.calendar.getQuotesNotes());
    List<UserCalInput> totalList = this.calendar.getTotalUserInputs();
    int totalSize = totalList.size();

    for (UserCalInput use : totalList) {
      if (use instanceof EventIn) {
        this.addUserIn(use, this.createEvent((EventIn) use));
      } else {
        this.addUserIn(use, this.createTask((Task) use));
        taskBox.getChildren().add(createTaskBox((Task) use));
      }
    }
  }

  public void updateCalendarOnAction() {
    List<UserCalInput> totalList = this.calendar.getTotalUserInputs();
    int totalSize = totalList.size();

    UserCalInput lastInput = totalList.get(totalSize - 1);

    if (lastInput instanceof EventIn) {
      this.addUserIn(lastInput, this.createEvent((EventIn) lastInput));
    } else if (lastInput instanceof Task) {
      this.addUserIn(lastInput, this.createTask((Task) lastInput));
      taskBox.getChildren().add(createTaskBox((Task) lastInput));
    }
  }


  public void updateCalendar2() {
    this.titleLabel.setText(this.calendar.getName());
    this.quotesNotes.setText(this.calendar.getQuotesNotes());
    List<UserCalInput> totalList = this.calendar.getTotalUserInputs();
    int totalSize = totalList.size();

    if (counter == 0) {

      //add calendar title
      titleLabel.setText(this.calendar.getName());

      for (UserCalInput use : totalList) {
        if (use instanceof EventIn) {
          this.addUserIn(use, this.createEvent((EventIn) use));
        } else {
          this.addUserIn(use, this.createTask((Task) use));
          taskBox.getChildren().add(createTaskBox((Task) use));
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
    counter++;
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
    String cssLayout = "-fx-border-color: grey;\n"
        + "-fx-border-insets: 5;\n"
        + "-fx-border-width: 1;\n";
    VBox newEvent = new VBox();
    newEvent.setStyle(cssLayout);
    Label titleLabel = new Label(event.getName());
    Label descriptionLabel = new Label(event.getDescription());
    Label startTimeLabel = new Label(event.getStartTime());
    Label durationLabel = new Label(event.getDuration() + " minutes");

    titleLabel.setWrapText(true);
    titleLabel.setMaxWidth(220);

    descriptionLabel.setWrapText(true);
    descriptionLabel.setMaxWidth(220);

    startTimeLabel.setWrapText(true);
    startTimeLabel.setMaxWidth(220);

    durationLabel.setWrapText(true);
    durationLabel.setMaxWidth(220);

    Label categoryLabel;
    if (event.getCategory() != null) {
      categoryLabel = new Label(event.getCategory().toUpperCase());
    } else {
      categoryLabel = new Label();
    }

    categoryLabel.setWrapText(true);
    categoryLabel.setMaxWidth(220);

    newEvent.getChildren().add(titleLabel);
    newEvent.getChildren().add(descriptionLabel);
    newEvent.getChildren().add(startTimeLabel);
    newEvent.getChildren().add(durationLabel);
    newEvent.getChildren().add(categoryLabel);

    return newEvent;
  }

  public VBox createTask(Task task) {
    String cssLayout = "-fx-border-color: grey;\n"
        + "-fx-border-insets: 5;\n"
        + "-fx-border-width: 1;\n";
    VBox newEvent = new VBox();
    newEvent.setStyle(cssLayout);
    Label titleLabel = new Label(task.getName());
    Label descriptionLabel = new Label(task.getDescription());

    titleLabel.setWrapText(true);
    titleLabel.setMaxWidth(220);

    descriptionLabel.setWrapText(true);
    descriptionLabel.setMaxWidth(220);

    Label categoryLabel;
    if (task.getCategory() != null) {
      categoryLabel = new Label(task.getCategory().toUpperCase());
    } else {
      categoryLabel = new Label();
    }

    categoryLabel.setWrapText(true);
    categoryLabel.setMaxWidth(220);

    newEvent.getChildren().add(titleLabel);
    newEvent.getChildren().add(descriptionLabel);
    newEvent.getChildren().add(categoryLabel);

    return newEvent;
  }

  public VBox createTaskBox(Task task) {

    String cssLayout = "-fx-border-color: grey;\n"
        + "-fx-border-insets: 5;\n"
        + "-fx-border-width: 1;\n";

    VBox newEvent = new VBox();
    newEvent.setStyle(cssLayout);

    CheckBox checkBox = new CheckBox(task.getName());

    updateProgress(checkBox, task);

    checkBox.selectedProperty().addListener((observable, oldValue, newValue) -> {
      if (newValue) {
        task.markComplete();
        updateProgress(checkBox, task);
      } else {
        task.markIncomplete();
        updateProgress(checkBox, task);
      }
    });

    newEvent.getChildren().add(checkBox);
    checkboxCouter++;
    return newEvent;
  }

  public void updateProgress(CheckBox checkBox, Task task) {
    int numCompleted = this.calendar.getTotalTasksCount();
    int maxTasksTotal = this.calendar.getTotalTasks().size();
    double number = (double) numCompleted / (double) maxTasksTotal;
    progressbar.setProgress(number);
    progressindicator.setProgress(number);
    checkBox.setSelected(task.getComplete());
  }
}
