package cs3500.pa05.controller.tempjournal;

import cs3500.pa05.controller.Controller;
import cs3500.pa05.controller.bujofile.BujoPopupController;
import java.io.File;
import java.nio.file.Path;
import java.util.Objects;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class TempJournalController implements Controller {

  @FXML
  private TextField bujoPath;

  @FXML
  private TextField bujoName;

  @FXML
  private Button submitButton;

  public TempJournalController() {
  }

  @Override
  public void run() {
    submitButton.setOnAction(e -> {
      runTemp(e);
    });
  }

  public void runTemp(Event e) {

    BujoPopupController bujoCont = new BujoPopupController();

    if(isValidBujo(bujoPath.getText()) && !(bujoName == null)) {
      TempJournalHandler regular = new TempJournalHandler(bujoPath.getText(), bujoName.getText());
      regular.handle(e);
    }
  }


  /**
   * Determines whether the given bujo file is valid
   *
   * @param str the link to the bujo file
   * @return whether the file is valid
   */
  public boolean isValidBujo(String str) {
    return !(Objects.equals(bujoPath.getText(), ""))
        && (isPathValid(str))
        && (isBujo(str));
  }

  /**
   * Determines whether the given file path is valid.
   *
   * @param str the file path
   * @return whether the path is valid
   */
  public static boolean isPathValid(String str) {
    Path givenPath = Path.of(str);
    File file = givenPath.toFile();
    return file.exists();
  }

  /**
   * Is bujo boolean.
   *
   * @param str the str
   * @return the boolean
   */
  public boolean isBujo(String str) {
    Path givenPath = Path.of(str);
    return givenPath.toString().endsWith(".bujo");
  }
}
