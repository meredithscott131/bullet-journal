package cs3500.pa05.controller;

import cs3500.pa05.controller.bujofile.BujoPopupController;
import cs3500.pa05.view.gui.BujoPopupView;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ChooseJournalController implements Controller {

  @FXML
  private Button templateJournal;

  @FXML
  private Button regularJournal;

  public ChooseJournalController() {
  }


  @Override
  public void run() {

    templateJournal.setOnAction(e -> {
      runTemplate(e);

      Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
      window.close(); // closes popup window
    });

    regularJournal.setOnAction(e -> {
      runRegular(e);

      Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
      window.close(); // closes popup window
    });
  }

  public void runRegular(Event e) {
    ChooseJournalHandlerRegular regular = new ChooseJournalHandlerRegular();
    regular.handle(e);
  }

  public void runTemplate(Event e) {
    ChooseJournalTempHandler temp = new ChooseJournalTempHandler();
    temp.handle(e);
  }
}
