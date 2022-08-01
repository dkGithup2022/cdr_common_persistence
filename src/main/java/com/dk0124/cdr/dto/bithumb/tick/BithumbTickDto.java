package com.dk0124.cdr.dto.bithumb.tick;


import com.dk0124.cdr.entity.upbit.CallType;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
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
