package cs3500.pa05.controller;

import cs3500.pa05.controller.Task.TaskButtonsEventHandler;
import cs3500.pa05.controller.event.ButtonsEventHandler;
import cs3500.pa05.controller.title.TitleEventHandler;
import cs3500.pa05.model.Calendar;
import cs3500.pa05.model.Day;
import cs3500.pa05.model.DayWeek;
import cs3500.pa05.model.EventIn;
import cs3500.pa05.model.OrderType;
import cs3500.pa05.model.Sorting;
import cs3500.pa05.model.Task;
import cs3500.pa05.model.UserCalInput;
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
 * Represents the controller for the journal
 */
public class JournalController implements Controller {
  private final Calendar calendar;
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

  private int checkboxCounter = 0;

  /**
   * Instantiates a new journal controller.
   *
   * @param calendar the calendar
   */
  public JournalController(Calendar calendar) {
    this.calendar = calendar;
  }

  /**
   * Runs the journal controller
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

    updateCalendarFirst();

    Sorting sorting = new Sorting(this.calendar);

    //when we make changes to the day lists
    List<Day> days = calendar.getDays();
    for (Day d : days) {
      d.getDayInputsObservable().addListener(
          (ListChangeListener) c -> {
            updateJournal(sorting, d);
          });
    }
    this.quotesNotes.textProperty().addListener((observable, oldValue, newValue) -> {
      this.calendar.setQuotesNotes(newValue);
    });

    dropDown.setOnAction(e -> {
      updateJournalOnAction(sorting);
    });

    this.titleLabel.setOnMouseClicked(new TitleEventHandler(this.calendar, this.titleLabel));
  }

  /**
   * Update journal on action.
   *
   * @param sorting the sorting
   */
  public void updateJournalOnAction(Sorting sorting) {
    int selectedIndex = dropDown.getSelectionModel().getSelectedIndex();
    if (selectedIndex == 0) {
      organizeBasedOnName();
      organizeAndDisplay(OrderType.NAME, sorting);
    } else if (selectedIndex == 1) {
      organizeBasedOnDur();
      organizeAndDisplay(OrderType.DURATION, sorting);
    }
  }

  /**
   * Update journal.
   *
   * @param sorting the sorting
   * @param d       the day
   */
  public void updateJournal(Sorting sorting, Day d) {
    if (this.calendar.getOrderType().equals(OrderType.NORMAL)) {
      updateCalendarOnInput();
      organizeAndDisplay(this.calendar.getOrderType(), sorting);
    } else {
      d.listClear();
      updateCalendarOnInput();
      organize();
      organizeAndDisplay(this.calendar.getOrderType(), sorting);
    }
  }

  /**
   * Organize and display.
   *
   * @param order   the order
   * @param sorting the sorting
   */
  public void organizeAndDisplay(OrderType order, Sorting sorting) {
    taskBox.getChildren().clear();
    sorting.sortJustTask(order);
    displayJustTask();
  }

  /**
   * Organize the calendar based on its order type
   */
  public void organize() {
    if (this.calendar.getOrderType() == OrderType.NAME) {
      organizeBasedOnName();
    } else if (this.calendar.getOrderType() == OrderType.DURATION) {
      organizeBasedOnDur();
    }
  }

  /**
   * Organize based on name.
   */
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

  /**
   * Organize based on duration.
   */
  public void organizeBasedOnDur() {
    this.calendar.setOrderType(OrderType.DURATION);
    Sorting sorting = new Sorting(this.calendar);

    for (Day d : this.calendar.getDays()) {
      d.listClear();
      d.listCopy();
    }

    sorting.updateOrder(OrderType.DURATION);
    clearCalendar();
    updateCalOrderDisplay();
  }

  /**
   * Clear calendar.
   */
  public void clearCalendar() {
    sundayBox.getChildren().clear();
    mondayBox.getChildren().clear();
    tuesdayBox.getChildren().clear();
    wednesdayBox.getChildren().clear();
    thursdayBox.getChildren().clear();
    fridayBox.getChildren().clear();
    saturdayBox.getChildren().clear();
  }

  /**
   * Display just task.
   */
  public void displayJustTask() {
    for (Task t : this.calendar.getListTasks()) {
      taskBox.getChildren().add(createTaskBox(t));
    }
  }

  /**
   * Init order.
   */
  public void initOrder() {
    dropDown.getItems().add(OrderType.NAME);
    dropDown.getItems().add(OrderType.DURATION);
  }

  /**
   * Update calendar order display.
   */
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

  /**
   * Update calendar based on pre-existing inputs in its bujo file.
   */
  public void updateCalendarFirst() {
    this.titleLabel.setText(this.calendar.getName());
    this.quotesNotes.setText(this.calendar.getQuotesNotes());
    List<UserCalInput> totalList = this.calendar.getTotalUserInputs();

    for (UserCalInput use : totalList) {
      if (use instanceof EventIn) {
        this.addUserIn(use, this.createEvent((EventIn) use));
      } else {
        this.addUserIn(use, this.createTask((Task) use));
        taskBox.getChildren().add(createTaskBox((Task) use));
      }
    }
  }

  /**
   * Update calendar when a new input is entered.
   */
  public void updateCalendarOnInput() {
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

  /**
   * Add user input onto its designated day.
   *
   * @param event    the event
   * @param eventBox the event box
   */
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

  /**
   * Create and format event VBox
   *
   * @param event the event
   * @return the VBox holding the event content
   */
  public VBox createEvent(EventIn event) {
    VBox newEvent = new VBox();
    assignStyle(newEvent);


    Label titleLabel = new Label(event.getName());
    titleLabel.setWrapText(true);
    titleLabel.setMaxWidth(220);

    Label descriptionLabel = new Label(event.getDescription());
    descriptionLabel.setWrapText(true);
    descriptionLabel.setMaxWidth(220);

    Label startTimeLabel = new Label(event.getStartTime());
    startTimeLabel.setWrapText(true);
    startTimeLabel.setMaxWidth(220);

    Label durationLabel = new Label(event.getDuration() + " minutes");
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

  /**
   * Create task VBox.
   *
   * @param task the task
   * @return the VBox holding the task content.
   */
  public VBox createTask(Task task) {
    VBox newEvent = new VBox();
    assignStyle(newEvent);

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

  /**
   * Create task VBox.
   *
   * @param task the task
   * @return the v box
   */
  public VBox createTaskBox(Task task) {
    VBox newEvent = new VBox();
    assignStyle(newEvent);

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
    checkboxCounter++;
    return newEvent;
  }

  /**
   * Assign style to the input boxes.
   *
   * @param newEvent the new event
   */
  public void assignStyle(VBox newEvent) {
    String cssLayout = "-fx-border-color: grey;\n"
        + "-fx-border-insets: 5;\n"
        + "-fx-border-width: 1;\n";
    newEvent.setStyle(cssLayout);
  }

  /**
   * Update the progress bar.
   *
   * @param checkBox the checkbox
   * @param task     the task
   */
  public void updateProgress(CheckBox checkBox, Task task) {
    int numCompleted = this.calendar.getTotalTasksCount();
    int maxTasksTotal = this.calendar.getTotalTasks().size();
    double number = (double) numCompleted / (double) maxTasksTotal;
    progressbar.setProgress(number);
    progressindicator.setProgress(number);
    checkBox.setSelected(task.getComplete());
  }
}