package cs3500.pa05.controller.welcome;

import cs3500.pa05.controller.ChooseJournalController;
import cs3500.pa05.controller.bujofile.BujoPopupController;
import cs3500.pa05.view.gui.BujoPopupView;
import cs3500.pa05.view.gui.ChooseJournalView;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.stage.Stage;

public class WelcomeHandler implements EventHandler {
  @Override
  public void handle(Event event) {
    //runBujoPopup();

    Stage stage = new Stage();
    ChooseJournalController chooseController = new ChooseJournalController();
    ChooseJournalView chooseView = new ChooseJournalView(chooseController);

    try {
      stage.setScene(chooseView.load());
      stage.show();
      chooseController.run();


    } catch (IllegalStateException exc) {
      System.err.println("Unable to load bujoPopup GUI.");
    }


  }

  public void runBujoPopup() {



    /*
    Stage stage = new Stage();
    BujoPopupController bujoController = new BujoPopupController();
    BujoPopupView bujoPopupView = new BujoPopupView(bujoController);

    try {
      stage.setScene(bujoPopupView.load());
      stage.show();
      bujoController.run();

    } catch (IllegalStateException exc) {
      System.err.println("Unable to load bujoPopup GUI.");
    }
*/
  }
}