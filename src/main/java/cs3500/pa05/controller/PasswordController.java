package cs3500.pa05.controller;

import cs3500.pa05.model.Calendar;
import java.nio.file.Path;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;

public class PasswordController implements Controller {


  @FXML
  private Button enterButton;

  @FXML
  private PasswordField passwordField;

  @FXML
  private VBox vbox;

  private Path path;

  public PasswordController(Path path) {
    this.path = path;
  }

  @Override
  public void run() {
    passwordField.setStyle("-fx-text-fill: black;");

    enterButton.setOnAction(e -> {
      pressEnter(e);
    });

  }

  public boolean isPasswordCorrect() {
    String enteredPas = passwordField.getText();
    String expectedPas =  "password"; //this.calendar.getPassword();
    return enteredPas.equals(expectedPas);
  }

  public void pressEnter(Event e) {
    if(isPasswordCorrect()) {
      PasswordHandler handler = new PasswordHandler(path);
      handler.handle(e);
    } else {
      passwordField.setStyle("-fx-text-fill: red;");
    }
  }
}
