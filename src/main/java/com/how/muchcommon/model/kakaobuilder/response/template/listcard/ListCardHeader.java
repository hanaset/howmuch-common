package com.how.muchcommon.model.kakaobuilder.response.template.listcard;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ListCardHeader {
    public String title;
    public String imageUrl;
}
