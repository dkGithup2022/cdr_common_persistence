package com.dk0124.cdr.entity.bithumb.tick.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BithumbSocketTickMessage {
    @JsonProperty("type")
    private String type;

    @JsonProperty("content")
    private BithumbTicksMessage content;

    @JsonProperty("status")
    private String status;

    @JsonProperty("resmsg")
    private String resmsg;
}
