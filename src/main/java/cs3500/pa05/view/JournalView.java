package cs3500.pa05.view;

import cs3500.pa05.controller.JournalController;
import cs3500.pa05.model.DayWeek;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

/**
 * Represents a interface journal GUI cs3500.pa05.view.view.
 */
public class JournalView implements View {
  private FXMLLoader loader;
  private JournalController controller;

  private DayWeek startDay;

  public JournalView(JournalController controller) {
    this.loader = new FXMLLoader();
    this.loader.setLocation(getClass().getClassLoader().getResource("bulletJournalMonday.fxml"));
    this.loader.setController(controller);
    this.controller = controller;
    this.startDay = startDay;
  }

  public String getFXML() {
    if(startDay.equals(DayWeek.SUNDAY)) {
      return "bulletJournal.fxml";
    } else if(startDay.equals(DayWeek.MONDAY)) {
      return "bulletJournalMonday.fxml";
    } else if(startDay.equals(DayWeek.TUESDAY)) {
      return "bulletJournalTuesday.fxml";
    } else if(startDay.equals(DayWeek.WEDNESDAY)) {
      return "bulletJournalWednesday.fxml";
    } else if(startDay.equals(DayWeek.THURSDAY)) {
      return "bulletJournalThurday.fxml";
    } else if(startDay.equals(DayWeek.FRIDAY)) {
      return "bulletJournalFriday.fxml";
    } else {
      return "bulletJournalSaturday.fxml";
    }
  }

  /**
   * Loads a scene from a journal GUI layout.
   *
   * @return the layout
   */
  @Override
  public Scene load() throws IllegalStateException {
    try {
      return this.loader.load();
    } catch (IOException exc) {
      throw new IllegalStateException("Unable to load layout.");
    }
  }
}
