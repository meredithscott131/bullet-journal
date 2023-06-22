package cs3500.pa05.controller.title;

import cs3500.pa05.controller.Controller;
import cs3500.pa05.model.Calendar;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * The type Title popup controller.
 */
public class TitlePopupController implements Controller {
  @FXML
  private DialogPane titlePane;
  private final Calendar calendar;
  @FXML
  private TextField titleInput;
  private final Label titleLabel;

  /**
   * Instantiates a new title popup controller.
   *
   * @param calendar   the calendar
   * @param titleLabel the title label
   */
  public TitlePopupController(Calendar calendar, Label titleLabel) {
    this.calendar = calendar;
    this.titleLabel = titleLabel;
  }

  /**
   * Runs the title popup controller
   */
  @Override
  public void run() {
    Button b = (Button) titlePane.lookupButton(ButtonType.APPLY);
    titleInput.textProperty().addListener((observable, oldValue, newValue) -> {
      this.calendar.setName(newValue);
    });
    b.setOnAction(new TitlePopupHandler(this.calendar, this.titleLabel));
  }
}