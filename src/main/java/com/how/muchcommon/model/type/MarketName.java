package com.how.muchcommon.model.type;

import lombok.Getter;

@Getter
public enum MarketName {
    joonggonara("joonggonara"),
    danggn("danggn"),
    bunjang("bunjang")
    ;

    private String name;

    MarketName(String name) {
        this.name = name;
    }

}
