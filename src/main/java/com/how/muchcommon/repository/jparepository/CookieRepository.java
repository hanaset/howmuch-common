package com.how.muchcommon.repository.jparepository;

import com.how.muchcommon.entity.jpaentity.CookieEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CookieRepository extends JpaRepository<CookieEntity, String> {
    CookieEntity findBySite(String site);
}
