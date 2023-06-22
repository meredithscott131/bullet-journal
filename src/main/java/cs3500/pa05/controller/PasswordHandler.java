package cs3500.pa05.controller;

import cs3500.pa05.model.Calendar;
import cs3500.pa05.model.ScannerBujo;
import cs3500.pa05.view.JournalView;
import java.nio.file.Path;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PasswordHandler implements EventHandler {

  Path path;

  PasswordHandler(Path path) {
    this.path = path;
  }

  @Override
  public void handle(Event event) {

    //runs the existing file journal
    //Path path = Path.of(path);
    ScannerBujo scannerBujo = new ScannerBujo();
    Calendar cal = scannerBujo.readFromFile(path.toFile());
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
}
