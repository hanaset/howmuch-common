package com.how.muchcommon.model.type;

import lombok.Getter;

@Getter
public enum FieldParam {
    date("posting_dtime"),
    price("price")
    ;

    private String value;

    FieldParam(String value) {
        this.value = value;
    }

}
