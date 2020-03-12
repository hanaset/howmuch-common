package com.how.muchcommon.model.type;

import lombok.Getter;

@Getter
public enum FieldParam {
    state("state"),
    date("posting_dtime"),
    price("price"),
    subject("subject")
    ;

    private String value;

    FieldParam(String value) {
        this.value = value;
    }

}
