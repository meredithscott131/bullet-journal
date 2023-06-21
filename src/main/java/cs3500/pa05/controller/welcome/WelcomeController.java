package cs3500.pa05.controller.welcome;

import cs3500.pa05.controller.Controller;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class WelcomeController implements Controller {

  @FXML
  private Button startButton;

  @FXML
  private VBox welcomeBox;

  public WelcomeController() {
  }

  @Override
  public void run() {

    BackgroundImage image= new BackgroundImage(new Image("photoSky.png",
        400,450,false,true),
        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
        BackgroundSize.DEFAULT);
    welcomeBox.setBackground(new Background(image));

    startButton.setOnAction(e -> {
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