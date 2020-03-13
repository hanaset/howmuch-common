package com.how.muchcommon.entity.jpaentity;

import com.how.muchcommon.converter.ZonedDateTimeConverter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TC_SITE")
public class SiteEntity {

    @Id
    private String code;

    private String name;

    private String description;

    @Column(name = "is_check")
    private String isCheck;

    @Column(name = "reg_dtime")
    @Convert(converter = ZonedDateTimeConverter.class)
    private ZonedDateTime regDtime;

    @Column(name = "upd_dtime")
    @Convert(converter = ZonedDateTimeConverter.class)
    private ZonedDateTime updDtime;
}
