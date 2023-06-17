package cs3500.pa05.json;

import cs3500.pa05.model.DayWeek;
import cs3500.pa05.model.UserCalInput;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Day(
    @JsonProperty("day") DayWeek day,
    @JsonProperty("inputs")UserCalInput[] inputs) {
}
