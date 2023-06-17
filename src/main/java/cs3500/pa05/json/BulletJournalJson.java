package cs3500.pa05.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

public record BulletJournalJson(
    @JsonProperty("journal") JsonNode node
    ) {
}
