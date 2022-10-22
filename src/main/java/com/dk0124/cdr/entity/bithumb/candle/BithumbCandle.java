package com.dk0124.cdr.entity.bithumb.candle;

import com.dk0124.cdr.entity.abstraction.Candle;
import lombok.*;

import javax.persistence.*;

@MappedSuperclass
@AllArgsConstructor @NoArgsConstructor
@Builder @Getter @Setter
@EqualsAndHashCode(of = "id")
public class BithumbCandle  implements Candle {

    public BithumbCandle(String code, Long timestamp, Double openingPrice, Double closingPrice, Double highPrice, Double lowPrice, Double tradeAmount) {
        this.code = code;
        this.timestamp = timestamp;
        this.openingPrice = openingPrice;
        this.closingPrice = closingPrice;
        this.highPrice = highPrice;
        this.lowPrice = lowPrice;
        this.tradeAmount = tradeAmount;
    }

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

    @Override
    public String toString() {
        return "BithumbCandle{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", timestamp=" + timestamp +
                ", openingPrice=" + openingPrice +
                ", closingPrice=" + closingPrice +
                ", highPrice=" + highPrice +
                ", lowPrice=" + lowPrice +
                ", tradeAmount=" + tradeAmount +
                '}';
    }
}
