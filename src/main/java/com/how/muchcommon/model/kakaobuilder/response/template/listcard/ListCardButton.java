package com.how.muchcommon.model.kakaobuilder.response.template.listcard;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ListCardButton {
    public String label;
    public String action;
    public String webLinkUrl;
}
