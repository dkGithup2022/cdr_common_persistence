package com.dk0124.cdr.persistence.dto.bithumb.tick;


import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class BithumbTickDto {
    @JsonProperty("code")
    @JsonAlias("symbol")
    private String code;

    @JsonProperty("buySellGb")
    private int buySellGb;

    @JsonProperty("contPrice")
    private Double contPrice;

    @JsonProperty("contQty")
    private Double contQty;

    @JsonProperty("contAmt")
    private Double contAmt;

    @JsonProperty ("contDtm")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSSSSS")
    private Date contDtm;

    @JsonProperty ("updn")
    private String dpdn;

    // 생성된 값 .
    private Long timestamp;
}
