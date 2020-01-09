package com.how.muchcommon.repository;

import com.how.muchcommon.entity.SiteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SiteRepository extends JpaRepository<SiteEntity, String> {
}
