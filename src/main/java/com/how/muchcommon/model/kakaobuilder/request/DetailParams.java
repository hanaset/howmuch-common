package com.how.muchcommon.model.kakaobuilder.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DetailParams {
    @SerializedName("keyword")
    @Expose
    public Keyword keyword;
}
