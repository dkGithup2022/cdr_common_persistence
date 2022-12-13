package com.dk0124.cdr.persistence.entity.bithumb.orderbook;


import com.dk0124.cdr.persistence.entity.abstraction.Orderbook;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.*;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.List;

@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "id")
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class BithumbOrderbook implements Orderbook {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @JsonProperty("datetime")
    @Column(name = "datetime")
    private Long datetime;

    @JsonAlias({"symbol", "code"})
    @Column(name = "code")
    private String code;

    @JsonAlias("orderbookUnit")
    @Type(type = "jsonb")
    @Column(name = "orderbook_unit", columnDefinition = "json")
    private List<BithumbOrderbookUnit> orderbookUnits;

}
