package cs3500.pa05.controller.password;

import cs3500.pa05.controller.Controller;
import cs3500.pa05.model.Calendar;
import java.nio.file.Path;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Represents the controller for the password
 */
public class PasswordController implements Controller {
  @FXML
  private Button enterButton;
  @FXML
  private PasswordField passwordField;
  private final Calendar calendar;
  @FXML
  private VBox vbox;
  private final Path path;
  private String nameStr;

  /**
   * Instantiates a new password controller.
   *
   * @param path     the path
   * @param calendar the calendar
   * @param nameStr the name
   */
  public PasswordController(Path path, Calendar calendar, String nameStr) {
    this.path = path;
    this.calendar = calendar;
    this.nameStr = nameStr;
  }

  /**
   * Runs the password controller
   * // Todo move this?
   */
  @Override
  public void run() {
    passwordField.setStyle("-fx-text-fill: black;");

    enterButton.setOnAction(e -> {
      pressEnter(e);
    });

  }

  /**
   * Determines whether the password is correct
   *
   * @return whether the password is correct
   */
  public boolean isPasswordCorrect() {
    String enteredPas = passwordField.getText();
    String expectedPas = this.calendar.getPassword();
    return enteredPas.equals(expectedPas);
  }

  /**
   * Handles the enter button being pressed.
   *
   * @param e the action event
   */
  public void pressEnter(Event e) {
    if (isPasswordCorrect()) {
      PasswordHandler handler = new PasswordHandler(path, nameStr, this.calendar);
      handler.handle(e);

      Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
      window.close(); // closes popup window
    } else {
      passwordField.setStyle("-fx-text-fill: red;");
    }
  }
}