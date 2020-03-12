package com.how.muchcommon.model.popular;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
@Builder
public class PopularRankResponse {
    private String updateTime;
    private List<PopularRankItem> list;
}
