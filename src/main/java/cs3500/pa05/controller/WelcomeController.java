package cs3500.pa05.controller;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class WelcomeController implements Controller {

  @FXML
  private Button start;

  public WelcomeController() {
  }

  @Override
  public void run() {

    start.setOnAction(e -> {
      makeHandler(e);

      Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
      window.close(); // closes popup window
    });

  }

  public void makeHandler(Event e) {
    WelcomeHandler welcomeHandler = new WelcomeHandler();
    welcomeHandler.handle(e);
  }
}
