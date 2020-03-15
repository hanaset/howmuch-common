package com.how.muchcommon.repository.jparepository;

import com.how.muchcommon.entity.jpaentity.PopularRankEntity;
import com.how.muchcommon.entity.jpaentity.PopularRankId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.ZonedDateTime;
import java.util.List;

@Repository
public interface PopularRankRepository extends JpaRepository<PopularRankEntity, PopularRankId> {
    @Query(value = "select search_date, keyword, sum(count) as count, reg_dtime, upd_dtime " +
            "from TB_POPULAR_CHART where search_date between :startTime and :endTime group by keyword order by count desc LIMIT 10", nativeQuery = true)
    List<PopularRankEntity> findAllByPopularRank(@Param("startTime") ZonedDateTime start, @Param("endTime")ZonedDateTime end);

}
