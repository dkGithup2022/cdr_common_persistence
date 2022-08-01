package com.dk0124.cdr.dto.bithumb.candle;


import com.sun.istack.NotNull;
import lombok.*;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotEmpty;

@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class BithumbCandleDto {

    @NotEmpty
    private String code;

    @NotNull
    public Long timestamp;

    private Double openingPrice;

    private Double closingPrice;

    private Double highPrice;

    private Double lowPrice;

    private Double tradeAmount;
}
