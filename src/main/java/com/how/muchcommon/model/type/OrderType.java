package com.how.muchcommon.model.type;

import lombok.Getter;

@Getter
public enum OrderType {
    DESC("DESC"),
    ASC("ASC");

    private String value;

    OrderType(String value) {
        this.value = value;
    }
}
