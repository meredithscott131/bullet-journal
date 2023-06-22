package cs3500.pa05.view;

import cs3500.pa05.controller.JournalController;
import cs3500.pa05.model.DayWeek;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

/**
 * Represents the View for the Journal
 */
public class JournalView implements View {
  private final FXMLLoader loader;
  private final DayWeek startDay;

  /**
   * Instantiates a new Journal view.
   *
   * @param controller the controller
   * @param startDay   the start day
   */
  public JournalView(JournalController controller, DayWeek startDay) {
    this.startDay = startDay;
    this.loader = new FXMLLoader();
    this.loader.setLocation(getClass().getClassLoader().getResource(getFxMl()));
    this.loader.setController(controller);
  }

  /**
   * Gets fxml.
   *
   * @return the fxml
   */
  public String getFxMl() {
    if (startDay.equals(DayWeek.SUNDAY)) {
      return "bulletJournal.fxml";
    } else if (startDay.equals(DayWeek.MONDAY)) {
      return "bulletJournalMonday.fxml";
    } else if (startDay.equals(DayWeek.TUESDAY)) {
      return "bulletJournalTuesday.fxml";
    } else if (startDay.equals(DayWeek.WEDNESDAY)) {
      return "bulletJournalWednesday.fxml";
    } else if (startDay.equals(DayWeek.THURSDAY)) {
      return "bulletJournalThursday.fxml";
    } else if (startDay.equals(DayWeek.FRIDAY)) {
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