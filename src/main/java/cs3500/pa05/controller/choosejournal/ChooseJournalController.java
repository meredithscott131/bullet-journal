package cs3500.pa05.controller.choosejournal;

import cs3500.pa05.controller.Controller;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * Represents the controller for
 * choosing a type of journal
 */
public class ChooseJournalController implements Controller {

  @FXML
  private Button templateJournal;

  @FXML
  private Button regularJournal;

  /**
   * Instantiates a new choose journal handler.
   */
  public ChooseJournalController() {
  }


  /**
   * Runs the choose journal controller.
   */
  @Override
  public void run() {

    templateJournal.setOnAction(e -> {
      runTemplate(e);

      Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
      window.close(); // closes popup window.
    });

    regularJournal.setOnAction(e -> {
      runRegular(e);

      Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
      window.close(); // closes popup window
    });
  }

  /**
   * Runs the regular type of journal
   * @param e event
   */
  public void runRegular(Event e) {
    ChooseJournalHandlerRegular regular = new ChooseJournalHandlerRegular();
    regular.handle(e);
  }

  /**
   * Runs the template type of journal
   * @param e event
   */
  public void runTemplate(Event e) {
    ChooseJournalTempHandler temp = new ChooseJournalTempHandler();
    temp.handle(e);
  }
}
