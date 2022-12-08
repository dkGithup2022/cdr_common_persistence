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

    @JsonAlias({"symbol","code"})
    private String code;

    @JsonAlias("buySellGb")
    private int buySellGb;

    @JsonAlias("contPrice")
    private Double contPrice;

    @JsonAlias("contQty")
    private Double contQty;

    @JsonAlias("contAmt")
    private Double contAmt;

    @JsonAlias ("contDtm")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSSSSS")
    private Date contDtm;

    @JsonAlias ("updn")
    private String dpdn;

    // 생성된 값 .
    private Long timestamp;
}
