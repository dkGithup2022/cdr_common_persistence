package com.dk0124.cdr.persistence.entity.bithumb.orderbook;

import com.fasterxml.jackson.annotation.JsonAlias;
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

    @JsonAlias("orderType")
    @Column(name = "order_type")
    private String orderType;

    @JsonAlias("price")
    @Column(name = "price")
    private Double price;

    @JsonAlias("quantity")
    @Column(name = "quantity")
    private Double quantity;


    @JsonAlias("total")
    @Column(name = "total")
    private Double total;

}
