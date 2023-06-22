package cs3500.pa05.model;

/**
 * Task class contains a new creation of a task
 */
public class Task extends UserCalInput {
  private boolean complete;

  /**
   * Instantiates a new Task.
   *
   * @param name        the name
   * @param description the description
   * @param day         the day
   * @param category    the category
   * @param complete    the complete
   */
  public Task(String name, String description, DayWeek day, String category,
              boolean complete) {
    super(name, description, day, category);
    this.complete = complete;
  }

  /**
   * Mark complete.
   */
  public void markComplete() {
    this.complete = true;
  }

  /**
   * Mark incomplete.
   */
  public void markIncomplete() {
    this.complete = false;
  }

  /**
   * Gets complete.
   *
   * @return the complete
   */
  public boolean getComplete() {
    return this.complete;
  }
}