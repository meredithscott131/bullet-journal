package cs3500.pa05.controller.password;

import cs3500.pa05.controller.JournalController;
import cs3500.pa05.model.Calendar;
import cs3500.pa05.model.Day;
import cs3500.pa05.view.JournalView;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Represents the handler for the password popup
 */
public class PasswordHandler implements EventHandler {
  private final Path path;
  private String nameStr;
  private Calendar cal;

  PasswordHandler(Path path, String nameStr, Calendar cal) {
    this.path = path;
    this.nameStr = nameStr;
    this.cal = cal;
  }

  /**
   * Instantiates a new password handler.
   *
   * @param path the path
   */
  PasswordHandler(Path path) {
    this.path = path;
  }

  /**
   * Handles the password popup event
   */
  @Override
  public void handle(Event event) {
    if (cal.getIsTemp()) {
      initCalendar(cal);
    }

    JournalController journalCont = new JournalController(cal);

    //based on dayweek load a certain journaliew (change fxml)
    JournalView journalView = new JournalView(journalCont, cal.getStartDay());
    Stage stage = new Stage();
    Scene scene = journalView.load();

    try {
      stage.setScene(scene);
      scene.getStylesheets().add("Normal.css");
      stage.show();
      journalCont.run();

    } catch (IllegalStateException exc) {
      System.err.println("Unable to load existing GUI.");
    }
  }

  private void initCalendar(Calendar cal) {
    List<Day> days = cal.getDays();
    for (Day d : days) {
      d.setDayInputs(new ArrayList<>());
      d.setObservable(new ArrayList<>());
    }
    cal.setQuotesNotes("");
    cal.setName(nameStr); //here?
    cal.setIsTemp();
    cal.setTotalUserInputs(new ArrayList<>());
  }
}
