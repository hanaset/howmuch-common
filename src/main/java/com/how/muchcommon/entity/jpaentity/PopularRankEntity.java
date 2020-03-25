package com.how.muchcommon.entity.jpaentity;

import com.how.muchcommon.converter.ZonedDateTimeConverter;
import com.how.muchcommon.entity.jpaentity.id.PopularRankId;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "TB_POPULAR_CHART")
public class PopularRankEntity {

    @EmbeddedId
    private PopularRankId id;

    @Column(name = "count")
    private long count = 0;

    @Column(name = "reg_dtime")
    @CreationTimestamp
    @Convert(converter = ZonedDateTimeConverter.class)
    private ZonedDateTime regDtime;

    @Column(name = "upd_dtime")
    @UpdateTimestamp
    @Convert(converter = ZonedDateTimeConverter.class)
    private ZonedDateTime updDtime;

    @Builder
    public PopularRankEntity(PopularRankId id, long count) {
        this.id = id;
        this.count = count;
    }

    public void addCount() {
        this.count += 1;
    }

}
