package com.how.muchcommon.entity;

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
@Table(name = "TB_ARTICLE")
public class ArticleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "article_id")
    private Long articleId;

    private String subject;

    private Long price;

    private String url;

    private String site;

    private String image;

    @Enumerated(EnumType.STRING)
    private ArticleState state;

    private String content;

    @Column(name = "posting_dtime")
    @Convert(converter = ZonedDateTimeConverter.class)
    private ZonedDateTime postingDtime;

    @Column(name = "reg_dtime")
    @Convert(converter = ZonedDateTimeConverter.class)
    private ZonedDateTime regDtime;

    @Column(name = "upd_dtime")
    @Convert(converter = ZonedDateTimeConverter.class)
    private ZonedDateTime updDtime;
}
