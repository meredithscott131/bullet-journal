package cs3500.pa05.json;

import cs3500.pa05.model.DayWeek;
import cs3500.pa05.model.UserCalInput;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public record DayJson(
    @JsonProperty("day") DayWeek day,
    @JsonProperty("events") List<EventJson> events,
    @JsonProperty("tasks") List<TaskJson> tasks) {
}