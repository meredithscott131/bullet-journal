package cs3500.pa05.controller;

import cs3500.pa05.model.Calendar;
import cs3500.pa05.model.ParseToFile;
import java.nio.file.Path;
import java.nio.file.Paths;
import javafx.event.Event;
import javafx.event.EventHandler;

/**
 * Represents the handler for the save button
 */
public class SaveButtonHandler implements EventHandler {
  private final Calendar calendar;

  /**
   * Instantiates a new save button handler.
   *
   * @param calendar the calendar
   */
  SaveButtonHandler(Calendar calendar) {
    this.calendar = calendar;
  }

  /**
   * Handles a button press
   */
  @Override
  public void handle(Event event) {
    ParseToFile parseToFile = new ParseToFile();

    if (!this.calendar.getIsTemp()) {
      parseToFile.writeToFile(Paths.get(this.calendar.getBujoPath()), this.calendar);
      System.out.println("eeeeeeee");
    } else {

      System.out.println("here");
      Path path =
          Path.of("/Users/lalcelikbilek/Documents/cs3500/pa05-boujeebujo/NewBujo/newTempFile.bujo");
      System.out.println(this.calendar.getTotalUserInputs().size());
      System.out.println(this.calendar.getTotalUserInputs().get(0).getName());
      //System.out.println(this.calendar.getTotalUserInputs().get(1).getName());

      //this.calendar.getDays().get(0).getDayInputs().get(0).getName();
      parseToFile.writeToFile(path, this.calendar); //cahnged this
    }
  }
}