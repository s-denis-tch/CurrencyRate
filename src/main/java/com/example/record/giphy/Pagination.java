package com.example.record.giphy;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Pagination {

    @JsonProperty("total_count")
    private Integer totalCount;

    @JsonProperty("count")
    private Integer count;

    @JsonProperty("offset")
    private Integer offset;

    @JsonProperty("total_count")
    public Integer getTotalCount() {
        return totalCount;
    }

    @JsonProperty("total_count")
    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    @JsonProperty("count")
    public Integer getCount() {
        return count;
    }

    @JsonProperty("count")
    public void setCount(Integer count) {
        this.count = count;
    }

    @JsonProperty("offset")
    public Integer getOffset() {
        return offset;
    }

    @JsonProperty("offset")
    public void setOffset(Integer offset) {
        this.offset = offset;
    }

}
