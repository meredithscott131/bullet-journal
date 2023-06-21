package cs3500.pa05.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import cs3500.pa05.model.DayWeek;
import java.util.ArrayList;

public record CalendarJson(
    @JsonProperty("max tasks") int maxTasks,
    @JsonProperty("max events") int maxEvents,
    @JsonProperty("title") String title,
    @JsonProperty("days") DayJson[] days,
    @JsonProperty("quotes & notes") String quotesNotes,
    @JsonProperty("start day") String startDay,
    @JsonProperty("categories") ArrayList<String> categories,
    @JsonProperty("password") String password) {}