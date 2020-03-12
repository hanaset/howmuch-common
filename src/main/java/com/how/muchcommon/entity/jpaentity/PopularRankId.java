package com.how.muchcommon.entity.jpaentity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.ZonedDateTime;

@Embeddable
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PopularRankId implements Serializable {

    @Column(name = "search_date")
    private ZonedDateTime searchDate;

    @Column(name = "keyword")
    private String keyword;

    @Builder
    public PopularRankId(ZonedDateTime searchDate, String keyword) {
        this.searchDate = searchDate;
        this.keyword = keyword;
    }

    @Override
    public boolean equals(Object o) {
        if(o == this) {
            return true;
        }
        if(!(o instanceof PopularRankId)) {
            return false;
        }
        PopularRankId id = (PopularRankId) o;
        return id.getKeyword().equals(keyword) && id.getSearchDate().isEqual(searchDate);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + searchDate.hashCode();
        result = 31 * result + keyword.hashCode();
        return result;
    }
}
