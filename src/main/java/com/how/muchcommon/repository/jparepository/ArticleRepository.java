package com.how.muchcommon.repository.jparepository;

import com.how.muchcommon.entity.jpaentity.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArticleRepository extends JpaRepository<ArticleEntity, Long> {

    ArticleEntity findTopByOrderByArticleIdDesc();
    Optional<ArticleEntity> findTopBySiteOrderByArticleIdDesc(String site);
}
