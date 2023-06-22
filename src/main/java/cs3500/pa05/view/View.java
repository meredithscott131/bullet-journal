package cs3500.pa05.view;

import javafx.scene.Scene;

/**
 * Represents a View
 */
public interface View {

  /**
   * Loads a scene from a journal GUI layout.
   *
   * @return the layout
   */
  Scene load();
}