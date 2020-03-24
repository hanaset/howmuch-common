package com.how.muchcommon.entity.jpaentity;

import com.how.muchcommon.converter.ZonedDateTimeConverter;
import com.how.muchcommon.model.type.ArticleState;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TB_TOP_ARTICLE")
public class TopArticleEntity {

    @Id
    private String site;

    @Column(name = "article_id")
    private Long articleId;

    @Column(name = "reg_dtime")
    @Convert(converter = ZonedDateTimeConverter.class)
    private ZonedDateTime regDtime;

    @Column(name = "upd_dtime")
    @Convert(converter = ZonedDateTimeConverter.class)
    private ZonedDateTime updDtime;
}

