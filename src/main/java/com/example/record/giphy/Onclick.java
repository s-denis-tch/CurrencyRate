package com.example.record.giphy;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Onclick {

    @JsonProperty("url")
    private String url;

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

}

