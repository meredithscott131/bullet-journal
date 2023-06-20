package cs3500.pa05.controller;

import cs3500.pa05.model.Calendar;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TitlePopupController implements Controller {

  @FXML
  private DialogPane titlePane;
  private Calendar calendar;
  @FXML
  private TextField titleInput;
  private Label titleLabel;

  public TitlePopupController(Calendar calendar, Label titleLabel) {
    this.calendar = calendar;
    this.titleLabel = titleLabel;
  }

  @Override
  public void run() {
    Button b = (Button) titlePane.lookupButton(ButtonType.APPLY);
    titleInput.textProperty().addListener((observable, oldValue, newValue) -> {
      this.calendar.setName(newValue);
    });
    b.setOnAction(new TitlePopupHandler(this.calendar, this.titleLabel));
  }
}
