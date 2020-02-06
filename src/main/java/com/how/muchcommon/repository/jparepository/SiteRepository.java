package com.how.muchcommon.repository.jparepository;

import com.how.muchcommon.entity.jpaentity.SiteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SiteRepository extends JpaRepository<SiteEntity, String> {
}
