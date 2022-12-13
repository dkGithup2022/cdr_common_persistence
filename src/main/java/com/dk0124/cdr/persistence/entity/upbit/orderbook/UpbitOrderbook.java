package com.dk0124.cdr.persistence.entity.upbit.orderbook;


import com.dk0124.cdr.persistence.entity.abstraction.Orderbook;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.*;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@MappedSuperclass
@AllArgsConstructor @NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "id")
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class UpbitOrderbook implements Serializable, Orderbook {

    public UpbitOrderbook(String code, Long timestamp, Double totalAskSize , Double totalBidSize, List<OrderBookUnit> orderBookUnits){
        this.code = code;
        this.timestamp = timestamp;
        this.totalAskSize = totalAskSize;
        this.totalBidSize = totalBidSize;
        this.orderBookUnits = orderBookUnits;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @JsonAlias({"code","market"})
    private String code;

    @NotNull
    @JsonAlias("timestamp")
    private Long timestamp;

    @JsonAlias("total_ask_size")
    private Double totalAskSize;

    @JsonAlias("total_bid_size")
    private Double totalBidSize;

    @JsonAlias("orderbook_units")
    @Type(type = "jsonb")
    @Column(columnDefinition = "json")
    private List<OrderBookUnit> orderBookUnits;

}
