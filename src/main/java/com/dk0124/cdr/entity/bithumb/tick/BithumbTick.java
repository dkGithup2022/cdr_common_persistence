package com.dk0124.cdr.entity.bithumb.tick;


import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.util.Date;



@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class BithumbTick{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @JsonProperty("code")
    @JsonAlias("symbol")
    @Column(name="code")
    private String code;

    @JsonProperty("buySellGb")
    @Column(name="buy_sell_gb")
    private int buySellGb;

    @JsonProperty("contPrice")
    @Column(name="cont_price")
    private Double contPrice;

    @JsonProperty("contQty")
    @Column(name="cont_qty")
    private Double contQty;

    @JsonProperty("contAmt")
    @Column(name = "cont_amt")
    private Double contAmt;

    @JsonProperty ("contDtm")
    @Column(name="cont_dtm")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSSSSS")
    private Date contDtm;

    @JsonProperty ("updn")
    @Column (name = "updn")
    private String dpdn;

    // 생성된 값 .
    @Column(name="timestamp")
    private Long timestamp;

}