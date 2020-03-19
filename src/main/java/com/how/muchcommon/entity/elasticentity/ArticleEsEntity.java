package com.how.muchcommon.entity.elasticentity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.how.muchcommon.model.type.ArticleState;
import com.how.muchcommon.model.type.MarketName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "arybyung", type = "doc")
public class ArticleEsEntity {

    @Id
    private Long id;

    @JsonProperty("article_id")
    private Long articleId;

    private String subject;

    private String content;

    private Long price;

    private String url;

    @Enumerated(EnumType.STRING)
    private MarketName site;

    private String image;

    @Enumerated(EnumType.STRING)
    private ArticleState state;

    @JsonProperty("posting_dtime")
    @Field(format = DateFormat.date_hour_minute)
    private Date postingDtime;

    @JsonProperty("reg_dtime")
    @Field(format = DateFormat.date_hour_minute)
    private Date regDtime;

    @JsonProperty("upd_dtime")
    @Field(format = DateFormat.date_hour_minute)
    private Date updDtime;
}
