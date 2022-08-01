package com.dk0124.cdr.entity.upbit;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CallType {
    RESTAPI("REST"),
    SOCKET("SOCKET");
    private String description;
}
