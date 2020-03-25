package com.how.muchcommon.entity.jpaentity.id;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.sql.Date;

@Embeddable
@Getter
@ToString
@NoArgsConstructor
public class CrawlingStatId implements Serializable {

    private Date date;

    private String site;

    @Builder
    public CrawlingStatId(Date date, String site) {
        this.date = date;
        this.site = site;
    }
}
