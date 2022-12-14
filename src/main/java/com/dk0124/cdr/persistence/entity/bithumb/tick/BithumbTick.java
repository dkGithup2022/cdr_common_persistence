package com.dk0124.cdr.persistence.entity.bithumb.tick;


import com.dk0124.cdr.persistence.entity.abstraction.Ticks;
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
public class BithumbTick implements Ticks {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @JsonAlias({"symbol","code"})
    @Column(name = "code")
    private String code;

    @JsonAlias("buySellGb")
    @Column(name = "buy_sell_gb")
    private int buySellGb;

    @JsonAlias("contPrice")
    @Column(name = "cont_price")
    private Double contPrice;

    @JsonAlias("contQty")
    @Column(name = "cont_qty")
    private Double contQty;

    @JsonAlias("contAmt")
    @Column(name = "cont_amt")
    private Double contAmt;

    @JsonAlias("contDtm")
    @Column(name = "cont_dtm")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSSSSS")
    private Date contDtm;

    @JsonAlias("updn")
    @Column(name = "updn")
    private String dpdn;

    // 생성된 값 .
    @Column(name = "timestamp")
    private Long timestamp;


    public void setContDtm(Date contDtm) {
        this.timestamp = contDtm.getTime();
        this.contDtm = contDtm;
    }

    public static BithumbTickBuilder builder() {
        return new CustomBithumbTickBuilder();
    }

    private static class CustomBithumbTickBuilder extends BithumbTickBuilder{
        @Override
        public BithumbTickBuilder contDtm(Date date){
            this.timestamp(date.getTime());
            return super.contDtm(date);
        }
    }

}