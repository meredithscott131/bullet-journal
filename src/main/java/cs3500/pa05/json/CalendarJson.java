package cs3500.pa05.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CalendarJson(
    @JsonProperty("max tasks") int maxTasks,
    @JsonProperty("max events") int maxEvents,
    @JsonProperty("title") String title,
    @JsonProperty("days") DayJson[] days) {}
