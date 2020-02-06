package com.how.muchcommon.repository.jparepository;

import com.how.muchcommon.entity.jpaentity.FilterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilterRepository extends JpaRepository<FilterEntity, Long> {
}
