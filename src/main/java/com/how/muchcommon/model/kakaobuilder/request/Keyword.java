package com.how.muchcommon.model.kakaobuilder.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;

@Getter
public class Keyword {
    @SerializedName("origin")
    @Expose
    public String origin;
    @SerializedName("value")
    @Expose
    public String value;
    @SerializedName("groupName")
    @Expose
    public String groupName;
}
