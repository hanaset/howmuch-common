package com.how.muchcommon.model.popular;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class PopularRankItem {
    private String keyword;
    private int state;
    private long count;
}
