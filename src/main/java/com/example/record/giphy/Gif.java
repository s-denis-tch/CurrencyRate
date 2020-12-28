package com.example.record.giphy;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Gif {

    @JsonProperty("data")
    private List<Data> data = null;

    @JsonProperty("pagination")
    private Pagination pagination;

    @JsonProperty("meta")
    private Meta meta;

    @JsonProperty("data")
    public List<Data> getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(List<Data> data) {
        this.data = data;
    }

    @JsonProperty("pagination")
    public Pagination getPagination() {
        return pagination;
    }

    @JsonProperty("pagination")
    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    @JsonProperty("meta")
    public Meta getMeta() {
        return meta;
    }

    @JsonProperty("meta")
    public void setMeta(Meta meta) {
        this.meta = meta;
    }

}

