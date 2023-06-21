package cs3500.pa05.model;

/**
 * Task class contains a new creation of a task
 */
public class Task extends UserCalInput {
  private boolean complete;

  public Task(String name, String description, DayWeek day, String category,
              boolean complete) {
    super(name, description, day, category);
    this.complete = complete;
  }

  public void markComplete() {
    this.complete = true;
  }

  public void markIncomplete() {
    this.complete = false;
  }

  public boolean getComplete() {
    return this.complete;
  }

} //closes Task class
