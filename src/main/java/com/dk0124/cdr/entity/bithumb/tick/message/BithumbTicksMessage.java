package com.dk0124.cdr.entity.bithumb.tick.message;

import com.dk0124.cdr.entity.bithumb.tick.BithumbTick;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class BithumbTicksMessage {
    @JsonProperty("list")
    private List<BithumbTick> list;
}
