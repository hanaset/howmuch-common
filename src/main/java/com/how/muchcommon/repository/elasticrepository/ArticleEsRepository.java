package com.how.muchcommon.repository.elasticrepository;

import com.how.muchcommon.entity.elasticentity.ArticleEsEntity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleEsRepository extends ElasticsearchRepository<ArticleEsEntity, Long> {

}

