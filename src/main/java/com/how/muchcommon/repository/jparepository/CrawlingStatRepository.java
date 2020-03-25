package com.how.muchcommon.repository.jparepository;

import com.how.muchcommon.entity.jpaentity.CrawlingStatEntity;
import com.how.muchcommon.entity.jpaentity.id.CrawlingStatId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CrawlingStatRepository extends JpaRepository<CrawlingStatEntity, CrawlingStatId> {
    Optional<CrawlingStatEntity> findById(CrawlingStatId crawlingStatId);
}
