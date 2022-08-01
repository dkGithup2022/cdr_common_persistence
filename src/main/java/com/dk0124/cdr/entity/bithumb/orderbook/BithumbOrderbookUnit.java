package com.dk0124.cdr.entity.bithumb.orderbook;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.Column;

@AllArgsConstructor
@Builder
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class BithumbOrderbookUnit {

    @JsonProperty("orderType")
    @Column(name = "order_type")
    private String orderType;

    @JsonProperty("price")
    @Column(name = "price")
    private Double price;

    @JsonProperty("quantity")
    @Column(name = "quantity")
    private Double quantity;;

    @JsonProperty("total")
    @Column(name = "total")
    private Double total;

}
