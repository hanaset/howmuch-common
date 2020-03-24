package com.how.muchcommon.repository.jparepository;

import com.how.muchcommon.entity.jpaentity.TopArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TopArticleRepository extends JpaRepository<TopArticleEntity, String> {

    Optional<TopArticleEntity> findBySite(String site);
}
