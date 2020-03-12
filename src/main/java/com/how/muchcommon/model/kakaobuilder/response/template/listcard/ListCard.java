package com.how.muchcommon.model.kakaobuilder.response.template.listcard;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class ListCard {
    public ListCardHeader header;
    public List<ListCardItem> items;
    public List<ListCardButton> buttons;
}
