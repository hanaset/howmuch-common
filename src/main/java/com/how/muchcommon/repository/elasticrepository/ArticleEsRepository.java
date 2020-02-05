package com.how.muchcommon.repository.elasticrepository;

import com.how.muchcommon.entity.elasticentity.ArticleEsEntity;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ArticleEsRepository extends ElasticsearchRepository<ArticleEsEntity, Long> {

    List<ArticleEsEntity> findBySubjectLikeOrContentLike(String subject, String content);
}

