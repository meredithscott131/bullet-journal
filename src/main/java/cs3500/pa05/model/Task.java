package cs3500.pa05.model;

/**
 * Task class contains a new creation of an task
 */
public class Task extends UserCalInput {
  private boolean complete;

  public Task(String name, String description, DayWeek day,
              boolean complete) {
    super(name, description, day);
    this.complete = complete;
  }





  /**
   * changeStage method changes a task to be incomplete(false) or complete(true)
   */
  public void changeStage() {

  }

  public boolean getComplete() {
    return this.complete;
  }

} //closes Task class
