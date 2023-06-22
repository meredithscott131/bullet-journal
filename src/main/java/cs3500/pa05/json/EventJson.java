package cs3500.pa05.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import cs3500.pa05.model.DayWeek;

/**
 * Represents Json for an Event object.
 */
public record EventJson(
    @JsonProperty("name") String name,
    @JsonProperty("description") String description,
    @JsonProperty("day") DayWeek day,
    @JsonProperty("start time") String startTime,
    @JsonProperty("duration") int duration,
    @JsonProperty("category") String category) {
}