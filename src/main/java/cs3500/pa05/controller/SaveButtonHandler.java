package cs3500.pa05.controller;

import cs3500.pa05.model.Calendar;
import cs3500.pa05.model.ParseToFile;
import java.nio.file.Paths;
import javafx.event.Event;
import javafx.event.EventHandler;

public class SaveButtonHandler implements EventHandler {
  private Calendar calendar;

  SaveButtonHandler(Calendar calendar) {
    this.calendar = calendar;
  }

  @Override
  public void handle(Event event) {
    ParseToFile parseToFile = new ParseToFile();
    parseToFile.writeToFile(Paths.get(this.calendar.getBujoPath()), this.calendar);
  }
}