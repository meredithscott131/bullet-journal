package cs3500.pa05.model;

/**
 * UserCalInput class information for an event or task
 */
public abstract class UserCalInput {
  private String name;
  private String description;
  private DayWeek day;
  private String category;

  /**
   * Instantiates a new user cal input.
   *
   * @param name        the name
   * @param description the description
   * @param day         the day
   * @param category    the category
   */
  public UserCalInput(String name, String description, DayWeek day, String category) {
    this.name = name;
    this.description = description;
    this.day = day;
    this.category = category;
  }

  /**
   * Gets name.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets description.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Gets day week.
   *
   * @return the day week
   */
  public DayWeek getDayWeek() {
    return day;
  }

  /**
   * Gets category.
   *
   * @return the category
   */
  public String getCategory() {
    return category;
  }

  /**
   * Sets category.
   *
   * @param category the category
   */
  public void setCategory(String category) {
    this.category = category;
  }

  /**
   * Sets name.
   *
   * @param str the str
   */
  public void setName(String str) {
    this.name = str;
  }

  /**
   * Sets day.
   *
   * @param dayWeek the day week
   */
  public void setDay(DayWeek dayWeek) {
    day = dayWeek;
  }

  /**
   * Sets description.
   *
   * @param str the str
   */
  public void setDescription(String str) {
    description = str;
  }
}