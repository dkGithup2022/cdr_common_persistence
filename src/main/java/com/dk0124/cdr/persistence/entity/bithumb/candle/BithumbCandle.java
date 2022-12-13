package com.dk0124.cdr.persistence.entity.bithumb.candle;

import com.dk0124.cdr.persistence.entity.abstraction.Candle;
import lombok.*;

import javax.persistence.*;

@MappedSuperclass
@AllArgsConstructor @NoArgsConstructor
@Builder @Getter @Setter
@EqualsAndHashCode(of = "id")
@ToString
public class BithumbCandle  implements Candle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Transient
    private String code;

    @Column(name = "timestamp")
    public Long timestamp;

    @Column(name = "opening_price")
    private Double openingPrice;

    @Column(name = "closing_price")
    private Double closingPrice;

    @Column(name = "high_price")
    private Double highPrice;

    @Column(name = "low_price")
    private Double lowPrice;

    @Column(name = "trade_amount")
    private Double tradeAmount;

}
