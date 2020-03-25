package com.how.muchcommon.entity.jpaentity;

import com.how.muchcommon.converter.ZonedDateTimeConverter;
import com.how.muchcommon.entity.jpaentity.id.CrawlingStatId;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TB_CRAWLING_STAT")
public class CrawlingStatEntity {

    @EmbeddedId
    private CrawlingStatId id;

    @Column(name = "success_count")
    private long successCount;

    @Column(name = "fail_count")
    private Long failCount;

    @Column(name = "filtering_count")
    private Long filteringCount;

    @Column(name = "reg_dtime")
    @CreationTimestamp
    @Convert(converter = ZonedDateTimeConverter.class)
    private ZonedDateTime regDtime;

    @Column(name = "upd_dtime")
    @UpdateTimestamp
    @Convert(converter = ZonedDateTimeConverter.class)
    private ZonedDateTime updDtime;
}
