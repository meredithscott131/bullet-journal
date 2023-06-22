package cs3500.pa05.controller.event;

import static java.lang.Integer.parseInt;

import cs3500.pa05.controller.Controller;
import cs3500.pa05.controller.WarningPopupController;
import cs3500.pa05.model.Calendar;
import cs3500.pa05.model.Day;
import cs3500.pa05.model.DayWeek;
import cs3500.pa05.model.EventIn;
import cs3500.pa05.view.gui.WarningPopupView;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Represents the controller for the Event popup
 */
public class PopupController implements Controller {
  private EventIn eventIn;
  private boolean popupOn;
  private Calendar calendar;
  @FXML
  private TextField nameTask;
  @FXML
  private TextField description;
  @FXML
  private TextField duration;
  @FXML
  private TextField startTime;
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

  /**
   * Instantiates a new Event Popup controller.
   *
   * @param calendar the calendar
   */
  public PopupController(Calendar calendar) {
    this.eventIn = new EventIn(null, null,
        null, null, null, 0);
    this.calendar = calendar;
    this.popupOn = false;
  }

  /**
   * Determines whether the given time is valid
   *
   * @param time the time
   * @return whether its valid
   */
  public boolean validTime(String time) {
    Pattern p = Pattern.compile("([01]?[0-9]|2[0-3]):[0-5][0-9]");
    Matcher m = p.matcher(time);
    return m.matches();
  }

  /**
   * Parses the given duration time to an integer
   *
   * @param durationStr the duration time
   * @return the duration time as an int
   */
  public int takeDuration(String durationStr) {
    if (isValidNum(durationStr)) {
      return parseInt(durationStr);
    }
    return 0;
  }

  /**
   * Returns the start time set by the user
   *
   * @param timeStr the start time
   * @return the start time (null or valid value)
   */
  public String takeTime(String timeStr) {
    if (validTime(timeStr)) {
      return timeStr;
    }
    return null;
  }

  /**
   * Determines whether the given duration is valid
   *
   * @param str the duration amount
   * @return whether its valid
   */
  public boolean isValidNum(String str) {
    try {
      return Integer.parseInt(str) > 0;
    } catch (NumberFormatException n) {
      return false;
    }
  }

  /**
   * Determines whether this event created by the user
   * has any null parameters.
   *
   * @return whether the event has any null parameters.
   */
  public boolean isNullEvent() {
    return eventIn.getName() == null
        || eventIn.getDayWeek() == null
        || eventIn.getStartTime() == null
        || eventIn.getDuration() == 0;
  }

  /**
   * Runs the event popup controller.
   * // TODO move this stuff?
   */
  @Override
  public void run() {
    sunButton.setOnAction(new PopButtonHandler(DayWeek.SUNDAY, eventIn));
    satButton.setOnAction(new PopButtonHandler(DayWeek.SATURDAY, eventIn));
    monButton.setOnAction(new PopButtonHandler(DayWeek.MONDAY, eventIn));
    tuesButton.setOnAction(new PopButtonHandler(DayWeek.TUESDAY, eventIn));
    wedButton.setOnAction(new PopButtonHandler(DayWeek.WEDNESDAY, eventIn));
    thurButton.setOnAction(new PopButtonHandler(DayWeek.THURSDAY, eventIn));
    friButton.setOnAction(new PopButtonHandler(DayWeek.FRIDAY, eventIn));
    this.nameTask.textProperty().addListener((observable, oldValue, newValue) -> {
      this.eventIn.setName(newValue);
    });
    this.startTime.textProperty().addListener((observable, oldValue, newValue) -> {
      this.eventIn.setStartTime(this.takeTime(newValue));
      System.out.println(this.eventIn.getStartTime());
    });
    this.duration.textProperty().addListener((observable, oldValue, newValue) -> {
      this.eventIn.setDuration(this.takeDuration(newValue));
    });
    submitButton.setOnAction(e -> makeSubmitButton(e));
  }

  /**
   * Initialize the submit button.
   *
   * @param eventEn the action event.
   */
  public void makeSubmitButton(Event eventEn) {
    if (this.isNullEvent()) {
      // do nothing
    } else if (isAtMaxEvent()) {
      //if we have reached the max number of events
      //set up warning popup
      runWarningPopup(eventEn);
    } else {
      SubmitButtonHandler submit = new SubmitButtonHandler(calendar, eventIn, nameTask.getText(),
          description.getText(), this.takeTime(startTime.getText()),
          this.takeDuration(duration.getText()));
      submit.handle(eventEn);
    }
  }

  /**
   * Run the warning popup.
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
    window.close();
  }

  /**
   * Whether the user is at their max event limit
   *
   * @return whether they are at their max
   */
  public boolean isAtMaxEvent() {
    DayWeek dayWeek = eventIn.getDayWeek();
    Day oneDay = this.calendar.getOneDay(dayWeek);

    int numOfEventsCurr = oneDay.getNumEventsAndTasksInDay();
    int maxEvents = this.calendar.getMaxEvent();
    return numOfEventsCurr == maxEvents;
  }
}