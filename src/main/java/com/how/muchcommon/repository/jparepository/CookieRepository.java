package com.how.muchcommon.repository.jparepository;

import com.how.muchcommon.entity.jpaentity.CookieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CookieRepository extends JpaRepository<CookieEntity, String> {
    CookieEntity findBySite(String site);
}
