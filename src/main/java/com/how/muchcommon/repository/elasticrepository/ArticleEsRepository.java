package com.how.muchcommon.repository.elasticrepository;

import com.how.muchcommon.entity.elasticentity.ArticleEsEntity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

public interface ArticleEsRepository extends ElasticsearchRepository<ArticleEsEntity, Long> {

    List<ArticleEsEntity> findByContentLikeOrSubjectLikeAndPostingDtimeBetween(String content, String subject, Date startDate, Date endDate);

    List<ArticleEsEntity> findBySubjectLikeAndPostingDtimeAfter(String keyword, String date);

    List<ArticleEsEntity> findBySubjectLike(String keyword);

    List<ArticleEsEntity> findByPostingDtime(LocalDateTime date);

    List<ArticleEsEntity> findByPostingDtimeBefore(LocalDateTime date);
}

