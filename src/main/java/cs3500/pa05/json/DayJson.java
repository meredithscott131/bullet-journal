package cs3500.pa05.json;

import cs3500.pa05.model.DayWeek;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * Represents Json for a day object.
 */
public record DayJson (
    @JsonProperty("day") DayWeek day,
    @JsonProperty("events") List<EventJson> events,
    @JsonProperty("tasks") List<TaskJson> tasks) {}