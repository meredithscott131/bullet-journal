package cs3500.pa05.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import cs3500.pa05.model.DayWeek;

public record TaskJson (
    @JsonProperty("name") String name,
    @JsonProperty("description") String description,
    @JsonProperty("day") DayWeek day,
    @JsonProperty("complete") boolean complete) {}