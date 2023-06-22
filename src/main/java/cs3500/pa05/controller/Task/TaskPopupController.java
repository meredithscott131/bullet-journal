package cs3500.pa05.controller.Task;

import cs3500.pa05.controller.Controller;
import cs3500.pa05.controller.WarningPopupController;
import cs3500.pa05.model.Calendar;
import cs3500.pa05.model.Day;
import cs3500.pa05.model.DayWeek;
import cs3500.pa05.model.Task;
import cs3500.pa05.view.gui.WarningPopupView;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Represents the controller for the task popup.
 */
public class TaskPopupController implements Controller {
  private Task task;
  private Calendar calendar;
  @FXML
  private TextField nameTask;
  @FXML
  private TextField description;
  @FXML
  private Button monButton;
  @FXML
  private Button tuesButton;
  @FXML
  private Button wedButton;
  @FXML
  private Button thurButton;
  @FXML
  private Button friButton;
  @FXML
  private Button satButton;
  @FXML
  private Button sunButton;
  @FXML
  private Button submitButton;
  @FXML
  private Stage stage;

  /**
   * Instantiates a new task popup controller.
   *
   * @param calendar the calendar
   */
  public TaskPopupController(Calendar calendar) {
    this.task = new Task(null, null, null, null, false);
    this.calendar = calendar;
  }

  /**
   * Runs the task popup controller
   */
  @Override
  public void run() {
    sunButton.setOnAction(new TaskDayButtonHandler(DayWeek.SUNDAY, task));
    satButton.setOnAction(new TaskDayButtonHandler(DayWeek.SATURDAY, task));
    monButton.setOnAction(new TaskDayButtonHandler(DayWeek.MONDAY, task));
    tuesButton.setOnAction(new TaskDayButtonHandler(DayWeek.TUESDAY, task));
    wedButton.setOnAction(new TaskDayButtonHandler(DayWeek.WEDNESDAY, task));
    thurButton.setOnAction(new TaskDayButtonHandler(DayWeek.THURSDAY, task));
    friButton.setOnAction(new TaskDayButtonHandler(DayWeek.FRIDAY, task));

    submitButton.setOnAction(e -> makeSubmitButton(e));
  }

  /**
   * Make submit button.
   *
   * @param eventEn the action event
   */
  public void makeSubmitButton(Event eventEn) {
    if (isAtMaxEvent()) {
      runWarningPopup(eventEn);
    } else {
      TaskSubmitButtonHandler submit =
          new TaskSubmitButtonHandler(calendar, task, nameTask.getText(),
              description.getText());
      submit.handle(eventEn);
    }
  }

  /**
   * Run a warning popup.
   *
   * @param eventEn the action event
   */
  public void runWarningPopup(Event eventEn) {
    WarningPopupController warningCont = new WarningPopupController();
    WarningPopupView warningView = new WarningPopupView(warningCont);
    Stage warningStage = new Stage();
    try {
      warningStage.setScene(warningView.load());
      warningStage.show();
      warningCont.run();
    } catch (IllegalStateException exc) {
      System.err.println("Unable to load warning GUI.");
    }

    Stage window = (Stage) ((Node) eventEn.getSource()).getScene().getWindow();
    window.close(); // closes popup window
  }

  /**
   * Determines whether the user has reached the max event limit
   *
   * @return whether they are at the limit
   */
  public boolean isAtMaxEvent() {
    DayWeek dayWeek = task.getDayWeek();
    Day oneDay = this.calendar.getOneDay(dayWeek);
    int numOfInputsCurr = oneDay.getNumTaskInDay();
    int maxTask = this.calendar.getMaxTask();
    return numOfInputsCurr == maxTask;
  }
}